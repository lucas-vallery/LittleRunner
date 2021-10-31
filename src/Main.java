import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Little Runner");
        Group root = new Group();
        Group root1 = new Group();

        Scene gameScene = new GameScene(root, 600, 400);
        StartingScene startingScene = new StartingScene(root1, 600, 400);

        // Launching the starting scene
        displayingTheScene(startingScene, primaryStage);

        //Waiting a mouse event
        startingScene.setOnMouseReleased(event -> {
                //Launching the game scene on a click release
                displayingTheScene(gameScene, primaryStage);
        });
    }

    public static void main(String[] args) {
        launch(args);
        // write your code here
    }

    private void displayingTheScene(Scene currentScene, Stage primaryStage) {
        primaryStage.setResizable(false);
        primaryStage.setScene(currentScene);
        primaryStage.show();
    }
}