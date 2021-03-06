package trabalholab3final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import trabalholab3final.Connection.ConexaoJavaDB;
import trabalholab3final.modelos.Projeto;
import trabalholab3final.modelos.Tarefa;

public class ProjetoDAO {

    Connection conexao;
    private String sqlInserir = "INSERT INTO PROJETO(descricao) VALUES (?)";
    private String sqlAlterar = "UPDATE PROJETO SET descricao = ? WHERE idprojeto = ?";
    private String sqlExcluir = "DELETE FROM PROJETO WHERE idprojeto = ?";
    private String sqlListar = "SELECT * FROM PROJETO WHERE idprojeto = ?";
    private String sqlListarTodos = "SELECT * FROM PROJETO";
    private TarefaDAO tarefaDAO;

    public ProjetoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = ConexaoJavaDB.getConnection();
        this.tarefaDAO = new TarefaDAO(this);
    }

    public void inserir(Projeto projeto) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlInserir,Statement.RETURN_GENERATED_KEYS);
        operacao.setString(1, projeto.getDescricao());
        operacao.execute();
        ResultSet rs = operacao.getGeneratedKeys();
        if (rs.next()) {
            int ultimo = rs.getInt(1);
            projeto.setId(ultimo);
        }
        operacao.close();
    }

    public void alterar(Projeto projeto) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlAlterar);
        operacao.setString(1, projeto.getDescricao());
        operacao.setInt(2, projeto.getId());
        operacao.execute();
        operacao.close();

    }

    public void excluir(Integer id) throws SQLException {

        PreparedStatement operacao = conexao.prepareStatement(sqlExcluir);
        operacao.setInt(1, id);
        operacao.execute();
        operacao.close();

    }

    public Projeto listar(Integer id) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListar);
        operacao.setInt(1, id);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        Projeto p = null;
        while (rs.next()) {
            Integer idprojeto = rs.getInt("idprojeto");
            String descricao = rs.getString("descricao");
            p = new Projeto(idprojeto, descricao);
        }
            List<Tarefa> tarefas = tarefaDAO.listarPorProjeto(p);
            p.setTarefas(tarefas);

        operacao.close();
        return p;

    }
    
     public List<Projeto> listarTodos() throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListarTodos);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        Projeto p = null;
        List<Projeto> projetos = new ArrayList<>();
        while (rs.next()) {
            Integer idprojeto = rs.getInt("idprojeto");
            String descricao = rs.getString("descricao");
            p = new Projeto(idprojeto, descricao);
            List<Tarefa> tarefas = tarefaDAO.listarPorProjeto(p);
            p.setTarefas(tarefas);
            projetos.add(p);
        }

        operacao.close();
        return projetos;
    }
}
