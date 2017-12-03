package trabalholab3final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javafx.scene.media.MediaPlayer;
import tabalholab3final.Connection.ConexaoJavaDB;
import trabalholab3final.modelos.Pessoa;
import trabalholab3final.modelos.Projeto;
import trabalholab3final.modelos.Status;
import trabalholab3final.modelos.Tarefa;

public class TarefaDAO {

    Connection conexao;
    String sqlInserir = "INSERT INTO PROJETO(descricao) VALUES (?,?);";
    String sqlAlterar = "UPDATE PROJETO SET descricao = ? WHERE idtarefa = ?;";
    String sqlExcluir = "DELETE FROM PROJETO WHERE idtarefa = ?";
    String sqlListar = "SELECT * FROM PROJETO WHERE idtarefa = ?";
    String sqlListarProjeto = "SELECT ¨FROM TAREFA WHERE fk_projeto = ?";

    TarefaDAO() throws SQLException, ClassNotFoundException {
        this.conexao = ConexaoJavaDB.getConnection();
    }

    public void inserir(Tarefa tarefa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlInserir);
        operacao.setString(1, tarefa.getDescricao());
        operacao.execute();
        operacao.close();
    }

    public void alterar(Tarefa tarefa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlAlterar);
        operacao.setString(1, tarefa.getDescricao());
        operacao.setInt(2, tarefa.getId());
        operacao.execute();
        operacao.close();

    }

    public void excluir(Integer id) throws SQLException {

        PreparedStatement operacao = conexao.prepareStatement(sqlExcluir);
        operacao.setInt(1, id);
        operacao.execute();
        operacao.close();

    }

    public Tarefa listar(Integer id) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListar);
        operacao.setInt(1, id);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        Tarefa p = null;
        while (rs.next()) {
        }

        operacao.close();
        return p;

    }
    
    public List<Tarefa> listarPorProjeto (Projeto p) throws SQLException{
        PreparedStatement operacao = conexao.prepareStatement(sqlListar);
        operacao.setInt(1, p.getId());
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        List<Tarefa> tarefas = null;
        while (rs.next()) {
            Integer id = rs.getInt("idtarefa");
            Projeto projeto = p;
            String descricao = rs.getString("descricao");
            Integer duracao = rs.getInt("duracao");
            Double valorConclusao = rs.getDouble("valorPercentual");
            LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
            LocalDate dataConclusao = rs.getDate("dataConclusao").toLocalDate(); 
            Status status = Status.valueOf(rs.getString("status"));
            List<Tarefa> requisitos = null;
            List<Pessoa> colaboradores = null;
            tarefas.add(new Tarefa(id, projeto, descricao, duracao, valorConclusao, dataInicio, dataConclusao, status, requisitos, colaboradores));
            
        }
        return tarefas;
    
    }
}

