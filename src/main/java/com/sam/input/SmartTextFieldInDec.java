package com.sam.input;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Data;

import java.util.function.Consumer;
import java.util.function.Supplier;


@Data
public class SmartTextFieldInDec extends HBox {


    private SmartTextField smartTextField;

    private Label incrementLabel;
    private Label decrementLabel;
    private VBox vBox;

    private Integer value;

    private Consumer<Integer> consumer;
    private Supplier<Integer> supplier;

    private  TextFieldFamilyValidation textFieldFamilyValidation;

//    HBox hbox;



    public SmartTextFieldInDec(SmartTextField smartTextField) {

        this.smartTextField = smartTextField;


        incrementLabel = new Label();

        FontAwesomeIcon incrementLabelIcon = new FontAwesomeIcon();
        incrementLabelIcon.setIconName("ARROW_UP");
        incrementLabelIcon.setId("icon-color");
//        incrementLabel.setStyle("-fx-background-color: #6467ED");
        incrementLabelIcon.setSize("12px");
        incrementLabel.setGraphic(incrementLabelIcon);
        incrementLabel.setAlignment(Pos.BOTTOM_CENTER);
//        incrementLabel.setMinWidth(30);
//        incrementLabel.setMinHeight(30);


        decrementLabel = new Label();

        FontAwesomeIcon decrementLabelIcon = new FontAwesomeIcon();
        decrementLabelIcon.setIconName("ARROW_DOWN");
//        decrementLabelIcon.setId("save-button-icon");
        decrementLabelIcon.setSize("12px");
        decrementLabelIcon.setId("icon-color");
        decrementLabel.setGraphic(decrementLabelIcon);
        decrementLabel.setAlignment(Pos.TOP_CENTER);
//        decrementLabel.setMinWidth(30);
//        decrementLabel.setMinHeight(30);

//        smartTextField.getChildren().add();

//        incrementLabel.prefHeightProperty().bind(smartTextField.heightProperty());
//        decrementLabel.prefHeightProperty().bind(smartTextField.heightProperty());

        vBox = new VBox(incrementLabel, decrementLabel);
        vBox.setSpacing(5);


        this.getChildren().addAll(smartTextField, vBox);


        addEvent();

        this.getStylesheets().add("/css/Icon.css");

        populateTextField();


    }

    void addConsumer(Consumer<Integer> consumer) {


        this.consumer = consumer;

    }

    public void addSupplier(Supplier<Integer> supplier) {

        this.supplier = supplier;

        populateTextField();
    }

    void populateTextField() {

        if (supplier == null) {

            smartTextField.setText("0");
        } else {

            smartTextField.setText(supplier.get() + "");
        }
    }


    void invokeMethod(Integer value) {

        consumer.accept(value);

    }


    void addEvent() {

        incrementLabel.setOnMouseClicked(e -> {

            String text = smartTextField.getText();
            if (!text.isEmpty()) {

                value = Integer.valueOf(text);

                smartTextField.setText(++value + "");

                if (consumer != null) {

                    invokeMethod(value);
                }


            }


        });

        decrementLabel.setOnMouseClicked(e -> {

            String text = smartTextField.getText();
            if (!text.isEmpty()) {

                value = Integer.valueOf(text);
                if (value > 0) {
                    smartTextField.setText(--value + "");
                }
                if (consumer != null) {

                    invokeMethod(value);
                }

            }


        });


    }


    public static class SmartTextFieldIncDecBuilder {

        SmartTextFieldInDec smartTextFieldIncDec;

        public SmartTextFieldIncDecBuilder(SmartTextField smartTextField) {
            this.smartTextFieldIncDec = new SmartTextFieldInDec(smartTextField);
        }


        public SmartTextFieldIncDecBuilder supplier(Supplier<Integer> supplier) {


            smartTextFieldIncDec.addSupplier(supplier);

            return this;
        }

        public SmartTextFieldIncDecBuilder smartTextField(SmartTextField smartTextField) {


            smartTextFieldIncDec.setSmartTextField(smartTextField);

            return this;
        }


        public SmartTextFieldIncDecBuilder addConsumer(Consumer<Integer> consumer) {


            smartTextFieldIncDec.addConsumer(consumer);

            return this;
        }

        public SmartTextFieldInDec build() {


            return smartTextFieldIncDec;
        }

    }

    public static SmartTextFieldIncDecBuilder builder(SmartTextField smartTextField) {

        return new SmartTextFieldIncDecBuilder(smartTextField);
    }


}
