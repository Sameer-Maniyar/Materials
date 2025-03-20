package com.sam.input;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import lombok.Data;

import java.util.function.Function;
import java.util.function.Predicate;


@Data
public class SmartTextField extends StackPane {

    private TextField textField;
    private Label promptText;
    private ChangeListener<Boolean> changeListener;
    private Boolean isRequired = false;


//    HBox hbox;

    public SmartTextField() {

        textField = new TextField();
        promptText = new Label(textField.getPromptText());
        promptText.setFont(new Font(10));
        promptText.setVisible(false);
        promptText.setStyle("-fx-text-fill: #888; -fx-background-color:white;");
        promptText.prefWidthProperty().bind(this.widthProperty());







        this.getChildren().addAll(textField, promptText);
        StackPane.setMargin(promptText, new Insets(-35, 0, 0, 5));
        this.setPadding(new Insets(10, 0, 0, 0));

//        textField.setStyle("-fx-background-color:white;\n" +
//                "-fx-border-width:0 0 1 0;\n" +
//                "-fx-border-radius:2px;\n" +
//                "-fx-border-color:rgba(72,79,79,0.5);\n" +
//                "\n" +
//                "-fx-font-size:16px;\n" +
//                "\n" +
//                "-fx-padding:2px;\n" +
//                "-fx-text-fill:rgba(0,0,0,1);\n" +
//                "-fx-prompt-text-size:10px;\n");

        textField.getStyleClass().add("default");


        this.setStyle("-fx-background-color:white");

        addEvent();
        this.getStylesheets().add("/css/SmartTextField.css");

    }


    void addEvent() {


        changeListener = (ObservableValue<? extends Boolean> obj, Boolean oldFocus, Boolean newFocus) -> {


            if (!newFocus && textField.getText().isBlank()) {

                promptText.setVisible(false);

            } else {
                promptText.setVisible(true);

            }
        };


        textField.textProperty().addListener((obj, oldTex, newText) -> {

            promptText.setTextFill(Color.rgb(136, 136, 136, 1));
            promptText.setVisible(true);


        });

        textField.focusedProperty().addListener(changeListener);


    }

    public void validateText(Function<String, String> biFunction) {

        textField.textProperty().addListener((obs, oldTxt, newTxt) -> {

            String validationMessage = biFunction.apply(textField.getText());

            if (!validationMessage.isBlank()) {


                promptText.setText(validationMessage);
                promptText.setTextFill(Color.RED);
            } else {

                promptText.setText(textField.getPromptText());
                promptText.setTextFill(Color.rgb(136, 136, 136, 1));
            }
        });


    }

    public void validateForBlank(String message) {

        textField.focusedProperty().removeListener(changeListener);

        textField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal && textField.getText().isEmpty()) {

                promptText.setText(message);
                promptText.setTextFill(Color.RED);

            }
        });


    }


    public void setText(String text) {
        textField.setText(text);
    }

    public void setPromptText(String promptText) {

        textField.setPromptText(promptText);
        this.promptText.setText(promptText);

    }

    public String getText() {

        return textField.getText();
    }

    public void clear() {
        textField.clear();
        promptText.setVisible(false);
    }

    public void required(Boolean isRequired) {

        this.isRequired = isRequired;
    }


    public void vibrateText() {


        promptText.setVisible(true);
        promptText.setTextFill(Color.RED);
        addInvalidVibrationToText(promptText);
    }


    private void addInvalidVibrationToText(Label text) {

        if (text.isVisible()) {

            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(25), event -> {

                text.setVisible(!text.isVisible());


            }

            ));

            timeline.setCycleCount(7);
            timeline.setAutoReverse(true);
            timeline.play();

        }
    }

    public void style(String style) {
        textField.setStyle(style);
    }


    public static class SmartTextFiledBuilder {
        SmartTextField smartTextField;

        public SmartTextFiledBuilder() {
            this.smartTextField = new SmartTextField();
        }

        public SmartTextFiledBuilder style(String style) {

            smartTextField.style(style);

            return this;
        }

        public SmartTextFiledBuilder promptText(String promptText) {

            smartTextField.setPromptText(promptText);

            return this;

        }

        public SmartTextField build() {


            return smartTextField;


        }

        public SmartTextFiledBuilder validateText(Function<String, String> biFunction) {

            smartTextField.validateText(biFunction);

            return this;


        }

        public SmartTextFiledBuilder allowTypingTo(Predicate predicate) {

            smartTextField.getTextField().textProperty().addListener((obj, oldValue, newValue) -> {


                if (!predicate.test(newValue)) {

                    smartTextField.setText(oldValue);

                }
            });

            return this;
        }




    }

    public static SmartTextFiledBuilder builder() {

        return new SmartTextFiledBuilder();
    }

}
