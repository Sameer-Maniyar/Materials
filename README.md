# Javafx Materials

   ```java
    SmartTextField priceTxtField = SmartTextField.builder()
            .promptText("Price")
            .validateText((inputText) -> {
                // Validation logic: Only allow numeric input
                if (!inputText.matches("^[0-9]*$")) {
                    return "Only numbers are allowed"; // Error message
                } else {
                    return ""; // No error
                }
            })
            .build();
    ```



