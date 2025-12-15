public class Main {public static void main(String[] args) {

    SocialNetwork network = new SocialNetwork("Instagram", 12000000);

    Profile profile1 = new Profile("Aisulu", 70);
    Profile profile2 = new Profile("Amina", 320);

    Post post1 = new Post("Hello world!", 45, true);
    Post post2 = new Post("Java is awesome!", 80, true);

    // --- OUTPUT 1: Print info ---
    System.out.println("=== SOCIAL NETWORK STATUS ===");
    network.printInfo();
    profile1.printInfo();
    profile2.printInfo();
    post1.printInfo();
    post2.printInfo();

    // --- OUTPUT 2: Compare posts (likes) ---
    System.out.println("\n=== POST COMPARISON ===");

    if (post1.getLikes() > post2.getLikes()) {
        System.out.println("Post 1 is more popular.");
    } else if (post1.getLikes() < post2.getLikes()) {
        System.out.println("Post 2 is more popular.");
    } else {
        System.out.println("Both posts have the same number of likes.");
    }

    // --- OUTPUT 3: Java Basics – count published posts ---
    System.out.println("\n=== COUNT PUBLISHED POSTS ===");
    int publishedCount = 0;

    if (post1.isPublished()) {
        publishedCount++;
    }
    if (post2.isPublished()) {
        publishedCount++;
    }

    System.out.println("Published posts: " + publishedCount);

    // --- OUTPUT 4: Array + for loop ---
    System.out.println("\n=== LOOP THROUGH PROFILES ===");
    Profile[] profiles = { profile1, profile2 };

    int maxFollowers = 0;

    for (int i = 0; i < profiles.length; i++) {
        int current = profiles[i].getFollowers();
        System.out.println("Profile " + (i + 1) +
                " followers: " + current);

        if (current > maxFollowers) {
            maxFollowers = current;
        }
    }

    System.out.println("Maximum followers: " + maxFollowers);
}
}
