package belajar.gradle;

import javafx.scene.image.Image;
public class Post {
    private String caption;
    private String postImage;
    
    public Post() {}
    
    public Post(String caption, String postImage) {
        this.caption = caption;
        this.postImage = postImage;
    }
    
    // Getters and Setters
    public String getCaption() { return caption; }
    public void setCaption(String caption) { this.caption = caption; }
    
    public String getPostImage() { return postImage; }
    public void setPostImage(String postImage) { this.postImage = postImage; }
}
