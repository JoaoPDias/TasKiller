package trabalholab3final.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tabalholab3final.Connection.ConexaoJavaDB;
import trabalholab3final.modelos.Pessoa;
import trabalholab3final.modelos.Projeto;
import trabalholab3final.modelos.Status;
import trabalholab3final.modelos.Tarefa;

public class TarefaDAO {

    Connection conexao;
    private String sqlInserir = "INSERT INTO TAREFA(fk_projeto,descricao,duracao,valorpercentual,datainicio,dataconclusao,status) VALUES (?,?,?,?,?,?,?)";
    private String sqlAlterar = "UPDATE TAREFA SET fk_projeto = ?, descricao = ?, duracao = ?, valorpercentual = ?, datainicio = ?, dataconclusao = ?, status = ? WHERE idtarefa = ?";
    private String sqlExcluir = "DELETE FROM PROJETO WHERE idtarefa = ?";
    private String sqlListar = "SELECT * FROM TAREFA WHERE idtarefa = ?";
    private String sqlListarProjeto = "SELECT FROM TAREFA WHERE fk_projeto = ?";
    private String sqlAlterarStatus = "UPDATE TAREFA SET STATUS = ? WHERE idtarefa = ?";
    private String sqlListarStatus = "SELECT * FROM TAREFAS WHERE status = ?";
    private String sqlListarTodos = "SELECT¨* FROM TAREFA";

    private RequisitoDAO requisitoDAO;
    private TarefaPessoaDAO tarefapessoaDAO;
    private ProjetoDAO projetoDAO;

    public TarefaDAO() throws SQLException, ClassNotFoundException {
        this.conexao = ConexaoJavaDB.getConnection();
        this.requisitoDAO = new RequisitoDAO(this);
        this.tarefapessoaDAO = new TarefaPessoaDAO();
        this.projetoDAO = new ProjetoDAO();
    }

    public void inserir(Tarefa tarefa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlInserir, Statement.RETURN_GENERATED_KEYS);
        operacao.setInt(1, tarefa.getProjeto().getId());
        operacao.setString(2, tarefa.getDescricao());
        operacao.setInt(3, tarefa.getDuracao());
        operacao.setDouble(4, tarefa.getValorConclusao());
        operacao.setDate(5, Date.valueOf(tarefa.getDataInicio()));
        operacao.setDate(6, Date.valueOf(tarefa.getDataConclusao()));
        if (tarefa.getRequisitos() != null && tarefa.getRequisitos().size() > 0) {
            operacao.setString(7, Status.BLOQUEADO.toString());
        } else {
            operacao.setString(7, Status.DISPONIVEL.toString());
        }
        System.out.print(operacao);
        operacao.execute();
        ResultSet rs = operacao.getGeneratedKeys();
        if (rs.next()) {
            int ultimoid = rs.getInt(1);
            tarefa.setId(ultimoid);
        }
        if (tarefa.getColaboradores() != null && tarefa.getColaboradores().size() > 0) {
            tarefapessoaDAO.inserirColaborador(tarefa, tarefa.getColaboradores());
        }
        if (tarefa.getRequisitos() != null && tarefa.getRequisitos().size() > 0) {
            requisitoDAO.inserirRequisito(tarefa, tarefa.getRequisitos());
        }

        operacao.close();
    }

    public void alterar(Tarefa tarefa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlAlterar);
        operacao.setInt(1, tarefa.getProjeto().getId());
        operacao.setString(2, tarefa.getDescricao());
        operacao.setInt(3, tarefa.getDuracao());
        operacao.setDouble(4, tarefa.getValorConclusao());
        operacao.setDate(5, Date.valueOf(tarefa.getDataInicio()));
        operacao.setDate(6, Date.valueOf(tarefa.getDataConclusao()));
        operacao.setString(7, tarefa.getStatus().toString());
        operacao.setInt(8, tarefa.getId());
        tarefapessoaDAO.excluirColaborador(tarefa);
        if (tarefa.getColaboradores() != null && tarefa.getColaboradores().size() > 0) {
            tarefapessoaDAO.inserirColaborador(tarefa, tarefa.getColaboradores());
        }
        if (tarefa.getStatus() == Status.CONCLUIDO) {
            requisitoDAO.concluiRequisito(tarefa.getId());
            this.alterarStatus(requisitoDAO.ListarRequisitados(tarefa.getId()));
        }
        operacao.execute();
        operacao.close();

    }

    public void excluir(Integer id) throws SQLException {

        PreparedStatement operacao = conexao.prepareStatement(sqlExcluir);
        operacao.setInt(1, id);
        operacao.execute();
        operacao.close();

    }

    public void alterarStatus(List<Tarefa> lista) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlAlterarStatus);
        for (Tarefa t : lista) {
            operacao.setString(1, t.getStatus().DISPONIVEL.toString());
            operacao.setInt(2, t.getId());
            operacao.execute();
        }
        operacao.close();
    }

    public Tarefa listar(Integer id) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListar);
        operacao.setInt(1, id);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        Tarefa tarefa = null;
        while (rs.next()) {
            Integer idtarefa = rs.getInt("idtarefa");
            Projeto projeto = projetoDAO.listar(rs.getInt("fk_projeto"));
            String descricao = rs.getString("descricao");
            Integer duracao = rs.getInt("duracao");
            Double valorConclusao = rs.getDouble("valorPercentual");
            LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
            LocalDate dataConclusao = rs.getDate("dataConclusao").toLocalDate();
            Status status = Status.valueOf(rs.getString("status"));
            List<Tarefa> requisitos = new ArrayList<>();
            if (requisitoDAO.verificaRequisito(idtarefa)) {
                requisitos.addAll(requisitoDAO.ListarTarefas(idtarefa));
            }
            List<Pessoa> colaboradores = tarefapessoaDAO.ListarPessoas(idtarefa);
            tarefa = new Tarefa(id, projeto, descricao, duracao, valorConclusao, dataInicio, dataConclusao, status, requisitos, colaboradores);
        }

        operacao.close();
        return tarefa;

    }

    public List<Tarefa> listarPorProjeto(Projeto p) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListarProjeto);
        operacao.setInt(1, p.getId());
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        List<Tarefa> tarefas = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("idtarefa");
            Projeto projeto = p;
            String descricao = rs.getString("descricao");
            Integer duracao = rs.getInt("duracao");
            Double valorConclusao = rs.getDouble("valorPercentual");
            LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
            LocalDate dataConclusao = rs.getDate("dataConclusao").toLocalDate();
            Status status = Status.valueOf(rs.getString("status"));
            List<Tarefa> requisitos = new ArrayList<>();
            if (requisitoDAO.verificaRequisito(id)) {
                requisitos.addAll(requisitoDAO.ListarTarefas(id));
            }
            List<Pessoa> colaboradores = tarefapessoaDAO.ListarPessoas(id);
            tarefas.add(new Tarefa(id, projeto, descricao, duracao, valorConclusao, dataInicio, dataConclusao, status, requisitos, colaboradores));

        }
        return tarefas;

    }
    
    public List<Tarefa> listarPorStatus(Status status) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListarStatus);
        operacao.setString(1, status.toString());
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        List<Tarefa> tarefas = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("idtarefa");
            Projeto projeto = projetoDAO.listar(rs.getInt("fk_projeto"));
            String descricao = rs.getString("descricao");
            Integer duracao = rs.getInt("duracao");
            Double valorConclusao = rs.getDouble("valorPercentual");
            LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
            LocalDate dataConclusao = rs.getDate("dataConclusao").toLocalDate();
            Status statusTarefa = Status.valueOf(rs.getString("status"));
            List<Tarefa> requisitos = new ArrayList<>();
            if (requisitoDAO.verificaRequisito(id)) {
                requisitos.addAll(requisitoDAO.ListarTarefas(id));
            }
            List<Pessoa> colaboradores = tarefapessoaDAO.ListarPessoas(id);
            tarefas.add(new Tarefa(id, projeto, descricao, duracao, valorConclusao, dataInicio, dataConclusao, statusTarefa, requisitos, colaboradores));

        }
        return tarefas;

    }
    
    public List<Tarefa> listarTodos() throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListarTodos);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        List<Tarefa> tarefas = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("idtarefa");
            Projeto projeto = projetoDAO.listar(rs.getInt("fk_projeto"));
            String descricao = rs.getString("descricao");
            Integer duracao = rs.getInt("duracao");
            Double valorConclusao = rs.getDouble("valorPercentual");
            LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
            LocalDate dataConclusao = rs.getDate("dataConclusao").toLocalDate();
            Status statusTarefa = Status.valueOf(rs.getString("status"));
            List<Tarefa> requisitos = new ArrayList<>();
            if (requisitoDAO.verificaRequisito(id)) {
                requisitos.addAll(requisitoDAO.ListarTarefas(id));
            }
            List<Pessoa> colaboradores = tarefapessoaDAO.ListarPessoas(id);
            tarefas.add(new Tarefa(id, projeto, descricao, duracao, valorConclusao, dataInicio, dataConclusao, statusTarefa, requisitos, colaboradores));

        }
        return tarefas;

    }
    
//    public static void main(String[] args) {
//        try {
//            Projeto p = new Projeto("Projeto J");
//            ProjetoDAO pdao = new ProjetoDAO();
//            pdao.inserir(p);
//            List<Tarefa> tarefas = new ArrayList<>();
//            List<Pessoa> pessoas = new ArrayList<>();
//            Pessoa p1 = new Pessoa("João Paulo Dias", "jpdias1997@hotmail.com");
//            Pessoa p2 = new Pessoa("Ricardo Furtado", "ricardo@hotmail.com");
//            Pessoa p3 = new Pessoa("Pedro Freitas", "pedro@hotmail.com");
//            PessoaDAO pessoaDao = new PessoaDAO();
//            pessoaDao.inserir(p1);
//            pessoaDao.inserir(p2);
//            pessoaDao.inserir(p3);
//            pessoas.add(p1);
//            pessoas.add(p2);
//            pessoas.add(p3);
//            TarefaDAO tarefadao = new TarefaDAO();
//            Tarefa t1 = new Tarefa(p, "Tarefa 1", 180, 10.0, LocalDate.now(), LocalDate.now().plusDays(180), "DISPONIVEL", null, pessoas);
//            tarefadao.inserir(t1);
//            tarefas.add(t1);
//            Tarefa t2 = new Tarefa(p, "Tarefa 2", 180, 10.0, LocalDate.now(), LocalDate.now().plusDays(180), "DISPONIVEL", tarefas, pessoas);
//            tarefadao.inserir(t2);
//            tarefas.add(t2);
//            Tarefa t3 = new Tarefa(p, "Tarefa 3", 180, 10.0, LocalDate.now(), LocalDate.now().plusDays(180), "DISPONIVEL", tarefas, pessoas);
//            tarefadao.inserir(t3);
//            t1 = tarefadao.listar(1);
//            System.out.println(t1.getStatus().toString());
//            t2 = tarefadao.listar(2);
//            System.out.println(t2.getStatus().toString());
//            t3 = tarefadao.listar(3);
//            System.out.println(t3.getStatus().toString());
//            RequisitoDAO requisitoDAO = new RequisitoDAO(tarefadao);
//            System.out.println(requisitoDAO.verificaRequisito(1));
//            System.out.println(requisitoDAO.verificaRequisito(2));
//            System.out.println(requisitoDAO.verificaRequisito(3));
//            t1.setStatus(Status.CONCLUIDO.toString());
//            tarefadao.alterar(t1);
//            t2.setStatus(Status.CONCLUIDO.toString());
//            tarefadao.alterar(t2);
//            t2 = tarefadao.listar(2);
//            t3 = tarefadao.listar(3);
//            System.out.println(t2.getStatus().toString());
//            System.out.println(t3.getStatus().toString());
//            t3 = tarefadao.listar(3);
//            System.out.println(t3.getStatus().toString());
//        } catch (SQLException ex) {
//            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
