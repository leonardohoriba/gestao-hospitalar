package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/gestao_hosp";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Conexão com o banco de dados
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        }
        catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao: ", ex);
        }
    }
    public static void closeConnection(Connection con) {
        closeConnection(con);
    }

    public static void main(String[] args) throws Exception{
        Connection con = getConnection();
        if(con != null){
            System.out.println("Conexao estabelecida com sucesso");
            con.close();
        }
    }

}
