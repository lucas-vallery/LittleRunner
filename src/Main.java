import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Little Runner");
        Group root = new Group();

        Scene gameScene = new GameScene(root, 800, 400);

        //Launching the starting scene
        displayingTheScene(gameScene, primaryStage);

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