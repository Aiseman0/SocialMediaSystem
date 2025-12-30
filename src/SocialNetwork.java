import java.util.Objects;
public class SocialNetwork extends SocialMediaEntity {
    private int activeUsers;


    public SocialNetwork(String name, int activeUsers) {
        super(name);
        this.activeUsers = activeUsers;
    }

    public int getActiveUsers() {
        return activeUsers;
    }

    @Override
    public void printInfo() {
        System.out.println("SocialNetwork → Name: " + getName() + ", Active Users: " + activeUsers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SocialNetwork that = (SocialNetwork) obj;
        return activeUsers == that.activeUsers && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), activeUsers);
    }
}
