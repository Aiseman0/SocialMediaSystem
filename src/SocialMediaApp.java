import java.sql.*;
import java.util.Scanner;  // Добавьте этот импорт для Scanner

public class SocialMediaApp {

    public static void menu(PostCrudOperations postCrudOperations) {
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
                    try {
                        postCrudOperations.createPost();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        postCrudOperations.readPost();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        postCrudOperations.updatePost();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        postCrudOperations.deletePost();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
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
    }
}