public class Profile extends SocialMediaEntity {
    private String username;
    private int followers;

    public Profile(String name, String username, int followers) {
        super(name);
        this.username = username;
        this.followers = followers;
    }
    public int getFollowers() {
        return followers;
    }
    @Override
    public void printInfo() {
        System.out.println("Profile → Username: " + username + ", Followers: " + followers);
    }
}
