package com.example.dungeongame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.paint.Color;

public class Player {
    public interface RoomChangeListener {
        void onChangeRoom(String nextRoom);
    }

    private ImageView imageView;
    private RoomChangeListener listener;

    public Player() throws FileNotFoundException {
        Image player = new Image(new FileInputStream("Add player sprite"));
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

    public void setRoomChangeListener(RoomChangeListener listener) {
        this.listener = listener;
    }

    public void handleMovement(KeyEvent event, Rectangle doorLeft, Rectangle doorRight, Runnable switchRoom, Runnable switchRoomB) {
        double currentX = imageView.getX();
        double currentY = imageView.getY();

        // Move the player
        switch (event.getCode()) {
            case W: imageView.setY(currentY - 5); break;
            case S: imageView.setY(currentY + 5); break;
            case A: imageView.setX(currentX - 5); break;
            case D: imageView.setX(currentX + 5); break;
        }

        // Check for collision with doors
        if (imageView.getBoundsInParent().intersects(doorLeft.getBoundsInParent())) {
        switchRoomB.run();
        imageView.setX(1100);
        imageView.setY(450);
    }
    
    if (imageView.getBoundsInParent().intersects(doorRight.getBoundsInParent())) {
        switchRoom.run(); // Calls loadRoomB() in MainApp
     }
  }    
}