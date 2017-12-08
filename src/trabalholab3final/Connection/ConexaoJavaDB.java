package trabalholab3final.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//A classe é responsável por realizar a conexão do JAVADB e retornar a quem pediu , utilizando o Padrão Factory
public class ConexaoJavaDB {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/lab1";
        String usuario = "usuario";
        String senha = "1234";
        return DriverManager.getConnection(url, usuario, senha);

    }
}
