public class SocialMediaEntity {
    private String name;

    public SocialMediaEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Name: " + name;
    }
    public void printInfo() {
        System.out.println("SocialMediaEntity: Information");
    }
}
