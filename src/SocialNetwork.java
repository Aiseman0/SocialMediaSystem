public class SocialNetwork {
    private String name;
    private int activeUsers;

    public SocialNetwork() {
    }

    public SocialNetwork(String name, int activeUsers) {
        this.name = name;
        this.activeUsers = activeUsers;
    }

    public String getName() {
        return name;
    }

    public int getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(int activeUsers) {
        this.activeUsers = activeUsers;
    }

    public void printInfo() {
        System.out.println("SocialNetwork → Name: " + name +
                ", Active users: " + activeUsers);
    }
}
