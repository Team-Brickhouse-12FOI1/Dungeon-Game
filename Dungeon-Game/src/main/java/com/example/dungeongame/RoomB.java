package com.example.dungeongame;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RoomB {
    private Pane room;
    private Rectangle doorLeft;
    private Rectangle doorRight;

    public RoomB() {
        room = new Pane(); // Pane initializieren

        // Raum Hintergrund
        Rectangle background = new Rectangle(700, 300, 500, 400);
        background.setFill(Color.SKYBLUE);

        // Linke Tür (Führt zum RoomA)
        doorLeft = new Rectangle(700, 450, 30, 100);
        doorLeft.setFill(Color.BROWN);

        // Rechte Tür (Führt zum Rooms)
        doorRight = new Rectangle(1170, 450, 30, 100);
        doorRight.setFill(Color.BROWN);

        room.getChildren().addAll(background, doorLeft, doorRight);
    }

    public Pane getRoom() {
        return room;
    }

    public Rectangle getDoorLeft() {
        return doorLeft;
    }

    public Rectangle getDoorRight() {
        return doorRight;
    }
}
