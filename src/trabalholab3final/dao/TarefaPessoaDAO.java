package trabalholab3final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabalholab3final.Connection.ConexaoJavaDB;
import trabalholab3final.modelos.Pessoa;
import trabalholab3final.modelos.Tarefa;

public class TarefaPessoaDAO {

    Connection conexao;
    private String sqlInserirColaborador = "INSERT INTO TAREFA_PESSOA(fk_tarefa,fk_pessoa) VALUES (?,?)";
    private String sqlExcluirColaborador = "DELETE FROM TAREFA_PESSOA WHERE fk_tarefa = ?";
    private String sqlListarColaborador = "SELECT fk_pessoa FROM TAREFA_PESSOA WHERE fk_tarefa = ?";
    private PessoaDAO pessoaDAO;

    TarefaPessoaDAO() throws SQLException, ClassNotFoundException {
        this.conexao = ConexaoJavaDB.getConnection();
        this.pessoaDAO = new PessoaDAO();
    }

    public void inserirColaborador(Tarefa tarefa, List<Pessoa> lista) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlInserirColaborador);
        for (Pessoa p : lista) {
            operacao.setInt(1, tarefa.getId());
            operacao.setInt(2, p.getId());
            operacao.execute();
        }
        operacao.close();

    }

    public void excluirColaborador(Tarefa tarefa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlExcluirColaborador);
        operacao.setInt(1, tarefa.getId());
        operacao.execute();
        operacao.close();
    }

    public List<Pessoa> ListarPessoas(Integer idtarefa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListarColaborador);
        operacao.setInt(1, idtarefa);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        List<Pessoa> pessoas = new ArrayList<>();
        while(rs.next()){
            Pessoa p = pessoaDAO.listar(rs.getInt("fk_pessoa"));
            pessoas.add(p);
        }
        operacao.close();
        return pessoas;
    }
}
