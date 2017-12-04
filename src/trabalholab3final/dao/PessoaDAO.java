package trabalholab3final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import tabalholab3final.Connection.ConexaoJavaDB;
import trabalholab3final.modelos.Pessoa;

public class PessoaDAO {

    Connection conexao;
    private String sqlInserir = "INSERT INTO PESSOA(nome,email) VALUES (?,?)";
    private String sqlAlterar = "UPDATE PESSOA SET nome = ?, email = ? WHERE idpessoa = ?";
    private String sqlExcluir = "DELETE FROM PESSOA WHERE idpessoa = ?";
    private String sqlListar = "SELECT * FROM PESSOA WHERE idpessoa = ?";

    PessoaDAO() throws SQLException, ClassNotFoundException {
        this.conexao = ConexaoJavaDB.getConnection();
    }

    public void inserir(Pessoa pessoa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlInserir,Statement.RETURN_GENERATED_KEYS);
        operacao.setString(1, pessoa.getNome());
        operacao.setString(2, pessoa.getEmail());
        operacao.execute();
        ResultSet rs = operacao.getGeneratedKeys();
        if (rs.next()) {
            int ultimo = rs.getInt(1);
            pessoa.setId(ultimo);
        }
        operacao.close();
        operacao.close();
    }

    public void alterar(Pessoa pessoa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlAlterar);
        operacao.setString(1, pessoa.getNome());
        operacao.setString(2, pessoa.getEmail());
        operacao.setInt(3, pessoa.getId());
        operacao.execute();
        operacao.close();

    }

    public void excluir(Integer id) throws SQLException {

        PreparedStatement operacao = conexao.prepareStatement(sqlExcluir);
        operacao.setInt(1, id);
        operacao.execute();
        operacao.close();

    }

    public Pessoa listar(Integer id) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListar);
        operacao.setInt(1, id);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        Pessoa p = null;
        while (rs.next()) {
            Integer idpessoa = rs.getInt("idpessoa");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            p = new Pessoa(idpessoa, nome, email);
        }

        operacao.close();
        return p;
    }
    /*
    public static void main(String[] args) {
        try {
            PessoaDAO p = new PessoaDAO();
            Pessoa pe = new Pessoa("João", "diasjp1997@gmail.com");
            p.inserir(pe);
            Pessoa pessoa = p.listar(1);
            System.out.println(pessoa);
            pessoa.setEmail("jpdias1997@hotmail.com");
            p.alterar(pessoa);
            p.excluir(2);
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
