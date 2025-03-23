```
       <dependency>
            <groupId>com.sam</groupId>
            <artifactId>Materials</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
```

1) add custom validaton
2) add prompt text when text typed still visible
3) decorate text field for form validation

```
SmartTextField field=SmartTextField.builder()
                .promptText("Price")
                .validateText((inputText) -> {

                    if (!inputText.matches("^[0-9]*$")) {
                        return "Only numbers are allowed";
                    } else {
                        return "";
                    }

                })
                .build();
```

1) allow typing specific text

```
 topMarginTextField = SmartTextField.builder()
                .promptText("Top Margin")
                .allowTypingTo(e -> String.valueOf(e).matches("\\d{0,10}"))
                .build();
```

1) Increament decrement field

```
 topMarginTextField = SmartTextField.builder()
                .promptText("Top Margin")
                .allowTypingTo(e -> String.valueOf(e).matches("\\d{0,10}"))
                .build();

        SmartTextFieldInDec smartTextField = SmartTextFieldInDec.builder(topMarginTextField)
                .addConsumer((Integer e) -> {

                    //Consume
                })
                .supplier(() -> {
                    return //supply

                })
                .build();
```

4) text field family validation


    ```
   firstNameTxtField.validateText((inputText) -> {

            if (!firstNameTxtField.getText().matches("[a-zA-Z0-9 ]*")) {

                return "Special Character Not Allowed";

            } else {

                return "";
            }
        });

   
textFieldFamilyValidation.addSmartTextField(firstNameTxtField) // add multiple textField validate all at once

 if (textFieldFamilyValidation.validateForRequiredFiled()) {

     

}


 ```


