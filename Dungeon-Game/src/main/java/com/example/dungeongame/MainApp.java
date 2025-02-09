package com.example.dungeongame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;

public class MainApp extends Application {
    private Stage primaryStage;
    private Scene scene;
    private Pane root;
    private Player player;
    private Room roomA;
    private RoomB roomB;
    
    private String currentRoom = "RoomA"; // Spurt welcher Raum Aktiv ist
    private String _roomB = "RoomB";

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        try {
            player = new Player();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Spielerbild nicht gefunden!");
            return;
        }

        roomA = new Room();
        roomB = new RoomB();

        root = new Pane();
    
        scene = new Scene(root, 1400, 800);
    
    
       loadRoomA();

        primaryStage.setTitle("Room Switching Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadRoomA() {
        currentRoom = "RoomA"; // Aktiven Raum setten
        root.getChildren().clear();
        root.getChildren().addAll(roomA.getRoom(), player.getImageView());
    
        player.getImageView().setX(850);
        player.getImageView().setY(460);

        scene.setOnKeyPressed(event -> 
            player.handleMovement(event, roomA.getDoorLeft(), roomA.getDoorRight(), this::switchRoom, this::switchRoomB)
        );

        primaryStage.setScene(scene);
    }

    private void loadRoomB() {
        currentRoom = "RoomB"; // Aktiven Raum setzen
        root.getChildren().clear();
        root.getChildren().addAll(roomB.getRoom(), player.getImageView());
        
        // Spieler Spawn in RoomB setzen
        player.getImageView().setX(760);
        player.getImageView().setY(450);
        
        scene.setOnKeyPressed(event -> 
            player.handleMovement(event, roomB.getDoorLeft(), roomB.getDoorRight(), this::switchRoom, this::switchRoomB)
        );

        primaryStage.setScene(scene);
    }

    private void switchRoom() {
        if (currentRoom.equals("RoomA")) {
            loadRoomB(); // Nur wechseln, wenn in RoomA
        }
    }
    private void switchRoomB() {
      if (currentRoom.equals("RoomB")) {
        loadRoomA();
      }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
