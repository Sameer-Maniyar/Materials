package com.sam.input;


import java.util.ArrayList;
import java.util.List;

public class TextFieldFamilyValidation {

    private String formName;

    List<SmartTextField> smartTextFields;

    public TextFieldFamilyValidation() {

        smartTextFields = new ArrayList<>();
    }

    public void addSmartTextField(SmartTextField smartTextField) {

        smartTextFields.add(smartTextField);
    }



    public Boolean validateForRequiredFiled() {
        Boolean isValid = true;

        for (SmartTextField textField : smartTextFields) {

            if (textField.getIsRequired() == true && textField.getTextField().getText().isBlank()) {

                textField.vibrateText();
                isValid = false;


            }

        }

        return isValid;

    }

}
