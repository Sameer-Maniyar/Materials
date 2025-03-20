package com.sam;

import com.sam.input.SmartTextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeaWizardMain extends Application {


    @Override public void start(final Stage primaryStage) throws Exception {

        VBox vBox=new VBox(new SmartTextField());
        Scene scene=new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();


    }



    public static void main(String[] args) {
        Application.launch(args);


    }


}
