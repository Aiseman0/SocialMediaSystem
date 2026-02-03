import java.sql.*;
import java.util.Scanner;

public class PostCrudOperations implements PostOperations {
    private DatabaseConnection databaseConnection;

    public PostCrudOperations(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void createPost() throws SQLException {
        Connection connection = databaseConnection.connect();
        String name = InputHandler.getInput("Enter post name: ");
        String content = InputHandler.getInput("Enter post content: ");
        int likes = InputHandler.getIntInput("Enter number of likes: ");
        boolean published = InputHandler.getBooleanInput("Is the post published? (true/false): ");

        String query = "INSERT INTO Post (name, content, likes, published) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, content);
            statement.setInt(3, likes);
            statement.setBoolean(4, published);
            statement.executeUpdate();
            System.out.println("Post created successfully.");
        }
    }

    @Override
    public void readPost() throws SQLException {
        Connection connection = databaseConnection.connect();
        String query = "SELECT * FROM Post";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                System.out.println("Post ID: " + resultSet.getInt("post_id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Content: " + resultSet.getString("content"));
                System.out.println("Likes: " + resultSet.getInt("likes"));
                System.out.println("Published: " + resultSet.getBoolean("published"));
                System.out.println("---------------------------");
            }
        }
    }

    @Override
    public void updatePost() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter post ID to update: ");
        int postId = scanner.nextInt();
        System.out.println("Enter new number of likes: ");
        int likes = scanner.nextInt();

        String query = "UPDATE Post SET likes = ? WHERE post_id = ?";
        try (PreparedStatement statement = databaseConnection.connect().prepareStatement(query)) {
            statement.setInt(1, likes);
            statement.setInt(2, postId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Post updated successfully.");
            } else {
                System.out.println("Post not found.");
            }
        }
    }

    @Override
    public void deletePost() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter post ID to delete: ");
        int postId = scanner.nextInt();

        String query = "DELETE FROM Post WHERE post_id = ?";
        try (PreparedStatement statement = databaseConnection.connect().prepareStatement(query)) {
            statement.setInt(1, postId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Post deleted successfully.");
            } else {
                System.out.println("Post not found.");
            }
        }
    }
}
