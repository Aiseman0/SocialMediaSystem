public class Profile {
    private String username;
    private int followers;

    public Profile() {
    }

    public Profile(String username, int followers) {
        this.username = username;
        this.followers = followers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void follow() {
        followers++;
    }

    public void printInfo() {
        System.out.println("Profile → Username: " + username +
                ", Followers: " + followers);
    }
}
