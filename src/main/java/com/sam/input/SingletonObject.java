package com.sam.input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonObject {

   private static Map<String, TextFieldFamilyValidation> textFieldFamilyValidationMap=new HashMap<>();


    public static TextFieldFamilyValidation getTextFieldFamilyValidator(String groupName) {

        TextFieldFamilyValidation textFieldFamilyValidation = getTextFieldFamilyValidation(groupName);

        if (textFieldFamilyValidation == null) {

            TextFieldFamilyValidation object = new TextFieldFamilyValidation();

            textFieldFamilyValidationMap.put(groupName, object);

            return object;
        }

        return textFieldFamilyValidation;

    }


    private static TextFieldFamilyValidation getTextFieldFamilyValidation(String formName) {

        return textFieldFamilyValidationMap.get(formName);

    }


}
