package trabalholab3final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tabalholab3final.Connection.ConexaoJavaDB;
import trabalholab3final.modelos.Projeto;

public class ProjetoDAO {

    Connection conexao;
    String sqlInserir = "INSERT INTO PROJETO(descricao) VALUES (?,?);";
    String sqlAlterar = "UPDATE PROJETO SET descricao = ? WHERE idprojeto = ?;";
    String sqlExcluir = "DELETE FROM PROJETO WHERE idprojeto = ?";
    String sqlListar = "SELECT * FROM PROJETO WHERE idprojeto = ?";

    ProjetoDAO() throws SQLException, ClassNotFoundException {
        this.conexao = ConexaoJavaDB.getConnection();
    }

    public void inserir(Projeto projeto) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlInserir);
        operacao.setString(1, projeto.getDescricao());
        operacao.execute();
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

        operacao.close();
        return p;

    }
}
