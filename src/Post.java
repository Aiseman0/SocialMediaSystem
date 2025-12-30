public class Post extends SocialMediaEntity {
    private String content;
    private int likes;
    private boolean published;


    public Post(String name, String content, int likes, boolean published) {
        super(name);
        this.content = content;
        this.likes = likes;
        this.published = published;
    }

    public int getLikes() {
        return likes;
    }
    public boolean isPublished() {
        return published;
    }



    @Override
    public void printInfo() {
        System.out.println("Post → Content: \"" + content + "\", Likes: " + likes + ", Published: " + published);
    }
}
