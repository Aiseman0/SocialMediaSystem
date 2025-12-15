public class Post {private String content;
    private int likes;
    private boolean published;

    public Post() {
    }

    public Post(String content, int likes, boolean published) {
        this.content = content;
        this.likes = likes;
        this.published = published;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void likePost() {
        likes++;
    }

    public void printInfo() {
        System.out.println("Post → Content: \"" + content +
                "\", Likes: " + likes +
                ", Published: " + published);
    }
}
