import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDatabaseConnection implements DatabaseConnection {
    @Override
    public Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/social_media";
        String user = "postgres";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}