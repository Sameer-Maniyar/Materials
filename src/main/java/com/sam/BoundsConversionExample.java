package com.sam;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.geometry.Bounds;

public class BoundsConversionExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a rectangle and add some transformations
        Rectangle rect = new Rectangle(50,50,100, 100);

        rect.setEffect(new DropShadow());
        rect.getTransforms().add(new Translate(50,50));

//        rect.setStroke(Color.RED);?\
//        rect.setStrokeWidth(5);;// Move 50 pixels to the right

        Pane root = new Pane(rect);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Bounds Conversion Example");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Get bounds in different coordinate systems
        Bounds ly = rect.getLayoutBounds();
        System.out.println("Layout bound : " + ly);

        Bounds localBounds = rect.getBoundsInLocal();
        System.out.println("Bounds in Local: " + localBounds);

        Bounds parentBounds = rect.getBoundsInParent();
        System.out.println("Bounds in Parent: " + parentBounds);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
