import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Room room = new Room();
        Player player = new Player();

        Group root = new Group();
        root.getChildren().addAll(room.getRoot(), player.getImageView());

        Scene scene = new Scene(root, 1400, 800);

        scene.setOnKeyPressed(event -> player.handleMovement(event, room.getDoorLeft(), room.getDoorRight()));

        stage.setTitle("Room and Player with Collision");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}