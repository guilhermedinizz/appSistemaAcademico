package appsistemaacademico;
import java.sql.*;
/**
 *
 * @author guilhermedinizdesousa
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            return
            DriverManager.getConnection("jdbc:derby://localhost:1527/servico","app", "app");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
