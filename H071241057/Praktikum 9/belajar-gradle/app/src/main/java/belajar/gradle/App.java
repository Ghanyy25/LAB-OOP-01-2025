package belajar.gradle;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    
    private User currentUser;
    private List<Post> posts;
    private Stage primaryStage;
    private TilePane postsContainer;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.posts = new ArrayList<>();
        
        primaryStage.setTitle("MyMoment");
        primaryStage.setScene(createRegisterScene());
        primaryStage.show();
    }
    
    private Scene createRegisterScene() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #f0f0f0;");
        
        Label titleLabel = new Label("Input User Account");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #333;");
        
        VBox nickSection = new VBox(8);
        nickSection.setAlignment(Pos.CENTER);
        Label nickLabel = new Label("Nick Name");
        nickLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #555;");
        
        TextField nickNameField = new TextField();
        nickNameField.setPrefWidth(350);
        nickNameField.setPrefHeight(35);
        nickNameField.setStyle("-fx-font-size: 14px; -fx-padding: 8;");
        
        nickSection.getChildren().addAll(nickLabel, nickNameField);
        
        VBox fullSection = new VBox(8);
        fullSection.setAlignment(Pos.CENTER);
        Label fullLabel = new Label("Full Name");
        fullLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #555;");
        
        TextField fullNameField = new TextField();
        fullNameField.setPrefWidth(350);
        fullNameField.setPrefHeight(35);
        fullNameField.setStyle("-fx-font-size: 14px; -fx-padding: 8;");
        
        fullSection.getChildren().addAll(fullLabel, fullNameField);
        
        VBox imageSection = new VBox(10);
        imageSection.setAlignment(Pos.CENTER);
        
        Button selectImageBtn = new Button("Upload Foto Profil");
        selectImageBtn.setStyle("-fx-background-color: #5DADE2; -fx-text-fill: white; -fx-font-size: 12px; -fx-padding: 8 20;");
        
        ImageView profileImageView = new ImageView();
        profileImageView.setFitWidth(150);
        profileImageView.setFitHeight(150);
        Circle clip = new Circle(75, 75, 75);
        profileImageView.setClip(clip);

        Circle bg = new Circle(75,75,75);
        bg.setFill(Color.BLACK);

        StackPane stack = new StackPane();
        stack.getChildren().addAll(bg,profileImageView);
        
        profileImageView.setStyle("-fx-background-color: black;");
        
        final String[] selectedImagePath = {null};
        
        selectImageBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Profile Image");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                selectedImagePath[0] = selectedFile.toURI().toString();
                profileImageView.setImage(new Image(selectedImagePath[0]));
            }
        });
        
        imageSection.getChildren().addAll(selectImageBtn, stack);
        
        Button submitBtn = new Button("Submit");
        submitBtn.setPrefWidth(100);
        submitBtn.setPrefHeight(30);
        submitBtn.setStyle("-fx-background-color: #BDC3C7; -fx-text-fill: #333; -fx-font-size: 12px;");
        
        submitBtn.setOnAction(e -> {
            String nickName = nickNameField.getText().trim();
            String fullName = fullNameField.getText().trim();
            
            if (nickName.isEmpty() || fullName.isEmpty()) {
                showAlert("Error", "Please fill in all fields!");
                return;
            }
            
            currentUser = new User(nickName, fullName, selectedImagePath[0]);
            primaryStage.setScene(createHomeScene());
        });
        
        root.getChildren().addAll(titleLabel, nickSection, fullSection, imageSection, submitBtn);
        
        return new Scene(root, 500, 600);
    }
    
    private Scene createHomeScene() {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f0f0f0;");
        
        HBox topSection = new HBox(20);
        topSection.setPadding(new Insets(20));
        topSection.setAlignment(Pos.CENTER_LEFT);
        
        ImageView homeProfileImg = new ImageView();
        homeProfileImg.setFitWidth(150);
        homeProfileImg.setFitHeight(150);
        Circle clip = new Circle(75, 75, 75);
        homeProfileImg.setClip(clip);
        
        
        if (currentUser.getProfileImage() != null) {
            homeProfileImg.setImage(new Image(currentUser.getProfileImage()));
        }
        
        VBox userInfo = new VBox(5);
        userInfo.setAlignment(Pos.CENTER_LEFT);
        
        Label nickNameLabel = new Label(currentUser.getNickName());
        nickNameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #333;");
        
        Label fullNameLabel = new Label(currentUser.getFullName());
        fullNameLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #666;");
        
        userInfo.getChildren().addAll(nickNameLabel, fullNameLabel);
        
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        Button addPostBtn = new Button("Add Post");
        addPostBtn.setStyle("-fx-background-color: #5DADE2; -fx-text-fill: white; -fx-font-size: 12px; -fx-padding: 8 16;");
        addPostBtn.setOnAction(e -> showAddPostDialog());
        
        topSection.getChildren().addAll(homeProfileImg, userInfo, spacer, addPostBtn);
        
        Separator separator = new Separator();
        separator.setStyle("-fx-background-color: #ddd;");
        
        VBox topContainer = new VBox();
        topContainer.getChildren().addAll(topSection, separator);
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background: #f0f0f0; -fx-background-color: #f0f0f0;");
        
        postsContainer = new TilePane();
        postsContainer.setPadding(new Insets(20));
        postsContainer.setHgap(15);
        postsContainer.setVgap(15);
        postsContainer.setPrefColumns(3);
        postsContainer.setStyle("-fx-background-color: #f0f0f0;");
        
        scrollPane.setContent(postsContainer);
        
        root.setTop(topContainer);
        root.setCenter(scrollPane);
        
        return new Scene(root, 700, 500);
    }
    
    private void showAddPostDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle("Add Post");
        
        VBox dialogRoot = new VBox(10);
        dialogRoot.setPadding(new Insets(20));
        dialogRoot.setAlignment(Pos.CENTER);
        
        Label titleLabel = new Label("Add New Post");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        Label imageLabel = new Label("Select Image:");
        
        ImageView postImageView = new ImageView();
        postImageView.setFitWidth(150);
        postImageView.setFitHeight(150);
        postImageView.setPreserveRatio(true);
        postImageView.setStyle("-fx-border-color: gray; -fx-border-width: 1;");
        
        Button selectPostImageBtn = new Button("Browse Image");
        
        final String[] selectedPostImagePath = {null};
        
        selectPostImageBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Post Image");
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            
            File selectedFile = fileChooser.showOpenDialog(dialog);
            if (selectedFile != null) {
                selectedPostImagePath[0] = selectedFile.toURI().toString();
                postImageView.setImage(new Image(selectedPostImagePath[0]));
            }
        });
        
        Label captionLabel = new Label("Caption:");
        TextArea captionArea = new TextArea();
        captionArea.setPrefRowCount(3);
        captionArea.setPrefWidth(200);
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        Button addBtn = new Button("Add");
        Button cancelBtn = new Button("Cancel");
        
        addBtn.setOnAction(e -> {
            String caption = captionArea.getText().trim();
            
            if (selectedPostImagePath[0] == null || caption.isEmpty()) {
                showAlert("Error", "Please select an image and enter a caption!");
                return;
            }
            
            Post newPost = new Post(caption, selectedPostImagePath[0]);
            posts.add(newPost);
            updatePostsDisplay();
            dialog.close();
        });
        
        cancelBtn.setOnAction(e -> dialog.close());
        
        buttonBox.getChildren().addAll(addBtn, cancelBtn);
        
        dialogRoot.getChildren().addAll(
            titleLabel,
            imageLabel,
            postImageView,
            selectPostImageBtn,
            captionLabel,
            captionArea,
            buttonBox
        );
        
        Scene dialogScene = new Scene(dialogRoot, 300, 450);
        dialog.setScene(dialogScene);
        dialog.showAndWait();
    }
    
    private void updatePostsDisplay() {
        postsContainer.getChildren().clear();
        
        for (Post post : posts) {
            VBox postBox = createPostBox(post);
            postsContainer.getChildren().add(postBox);
        }
    }
    
    private VBox createPostBox(Post post) {
        VBox postBox = new VBox(5);
        postBox.setAlignment(Pos.CENTER);
        postBox.setPadding(new Insets(10));
        postBox.setStyle("-fx-border-color: lightgray; -fx-border-width: 1;");
        
        ImageView postImageView = new ImageView(new Image(post.getPostImage()));
        postImageView.setFitWidth(120);
        postImageView.setFitHeight(120);
        postImageView.setPreserveRatio(true);
        
        Tooltip tooltip = new Tooltip(post.getCaption());
        Tooltip.install(postImageView, tooltip);
        
        postBox.getChildren().add(postImageView);
        
        return postBox;
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
