import java.sql.SQLException;  // Импорт SQLException

public interface PostOperations {
    void createPost() throws SQLException;
    void readPost() throws SQLException;
    void updatePost() throws SQLException;
    void deletePost() throws SQLException;
}