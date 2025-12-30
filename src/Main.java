public class Main {
    public static void main(String[] args) {

        SocialNetwork network = new SocialNetwork("Instagram", 12000000);
        Profile profile1 = new Profile("Aisulu", "Aisulu123", 777);
        Profile profile2 = new Profile("Amina", "Amina456", 320);
        Post post1 = new Post("Post 1", "Hello world!", 45, true);
        Post post2 = new Post("Post 2", "Java is awesome!", 80, true);

        network.printInfo();
        profile1.printInfo();
        profile2.printInfo();
        post1.printInfo();
        post2.printInfo();


        if (post1.getLikes() > post2.getLikes()) {
            System.out.println("Post 1 is more popular.");
        } else if (post1.getLikes() < post2.getLikes()) {
            System.out.println("Post 2 is more popular.");
        } else {
            System.out.println("Both posts have the same number of likes.");
        }


        int publishedCount = 0;
        if (post1.isPublished()) {
            publishedCount++;
        }
        if (post2.isPublished()) {
            publishedCount++;
        }
        System.out.println("Published posts: " + publishedCount);

        Profile[] profiles = { profile1, profile2 };
        int maxFollowers = 0;
        for (int i = 0; i < profiles.length; i++) {
            int current = profiles[i].getFollowers();
            System.out.println("Profile " + (i + 1) + " followers: " + current);

            if (current > maxFollowers) {
                maxFollowers = current;
            }
        }
        System.out.println("Maximum followers: " + maxFollowers);
    }
}
