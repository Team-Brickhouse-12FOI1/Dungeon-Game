import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Player {
    private ImageView imageView;

    public Player() throws FileNotFoundException {
        Image player = new Image(new FileInputStream("C:\\Users\\User\\Pictures\\player.png"));
        imageView = new ImageView(player);
        imageView.setX(960);
        imageView.setY(450);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setPreserveRatio(true);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void handleMovement(KeyEvent event, Rectangle door) {
        double currentX = imageView.getX();
        double currentY = imageView.getY();

        switch (event.getCode()) {
            case W: imageView.setY(currentY - 5); break;
            case S: imageView.setY(currentY + 5); break;
            case A: imageView.setX(currentX - 5); break;
            case D: imageView.setX(currentX + 5); break;
        }

        for (Rectangle door : doors) {
            if (imageView.getBoundsInParent().intersects(door.getBoundsInParent())) {
                System.out.println("Collision with a door!");
               
            }
        }
    }
}