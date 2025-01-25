import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Room {
    private Group root;
    private Rectangle doorLeft;
    private Rectangle doorRight;

    public Room() {
        // Room definition
        Rectangle room = new Rectangle();
        room.setX(700.0f);
        room.setY(300.0f);
        room.setWidth(500.0f);
        room.setHeight(400.0f);
        room.setFill(Color.GRAY);

        // Door on the left
        doorLeft = new Rectangle();
        doorLeft.setX(1170.0f);
        doorLeft.setY(450.0f);
        doorLeft.setWidth(30.0f);
        doorLeft.setHeight(100.0f);
        doorLeft.setFill(Color.BROWN);

        // Door on the right
        doorRight = new Rectangle();
        doorRight.setX(700.0f); // Adjusted position for the right door
        doorRight.setY(450.0f);
        doorRight.setWidth(30.0f);
        doorRight.setHeight(100.0f);
        doorRight.setFill(Color.DARKRED);

        // Add all elements to the group
        root = new Group(room, doorLeft, doorRight);
    }

    public Group getRoot() {
        return root;
    }

    public Rectangle getDoorLeft() {
        return doorLeft;
    }

    public Rectangle getDoorRight() {
        return doorRight;
    }
}