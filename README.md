# Javafx Materials

1) Smart Text Field -> build on top of exixting text field to add validation and propmt effectively

     SmartTextField priceTxtField = SmartTextField.builder()
                .promptText("Price")
                .validateText((inputText) -> {

                    if (!inputText.matches("^[0-9]*$")) {
                        return "Only numbers are allowed";
                    } else {
                        return "";
                    }

                })
                .build();



