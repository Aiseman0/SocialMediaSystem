import java.sql.*;
import java.util.Scanner;

public class crud{

    public static void createPost(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter post name: ");
        String name = scanner.nextLine();

        System.out.println("Enter post content: ");
        String content = scanner.nextLine();

        System.out.println("Enter number of likes: ");
        int likes = scanner.nextInt();

        System.out.println("Is the post published? (true/false): ");
        boolean published = scanner.nextBoolean();

        String query = "INSERT INTO Post (name, content, likes, published) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setString(2, content);
            statement.setInt(3, likes);
            statement.setBoolean(4, published);

            statement.executeUpdate();
        }

        System.out.println("Post created successfully.");
    }


    public static void readPosts(Connection connection) throws SQLException {

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


    public static void updatePostLikes(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter post ID to update: ");
        int postId = scanner.nextInt();

        System.out.println("Enter new number of likes: ");
        int likes = scanner.nextInt();


        String query = "UPDATE Post SET likes = ? WHERE post_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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


    public static void deletePost(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter post ID to delete: ");
        int postId = scanner.nextInt();


        String query = "DELETE FROM Post WHERE post_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, postId);
            int rowsDeleted = statement.executeUpdate();


            if (rowsDeleted > 0) {
                System.out.println("Post deleted successfully.");
            } else {
                System.out.println("Post not found.");
            }
        }
    }


    public static void menu() {
        try (Connection connection = DatabaseConnection.connect()) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;


            while (running) {
                System.out.println("Choose an action:");
                System.out.println("1. Create Post");
                System.out.println("2. Read Posts");
                System.out.println("3. Update Post Likes");
                System.out.println("4. Delete Post");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();


                switch (choice) {
                    case 1:
                        createPost(connection);
                        break;
                    case 2:
                        readPosts(connection);
                        break;
                    case 3:
                        updatePostLikes(connection);
                        break;
                    case 4:
                        deletePost(connection);
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice, try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        menu();
    }


    private static class DatabaseConnection {

        public static Connection connect() throws SQLException {
            String url = "jdbc:postgresql://localhost:5432/social_media";
            String user = "postgres";
            String password = "1234";
            return DriverManager.getConnection(url, user, password);
        }
    }
}
