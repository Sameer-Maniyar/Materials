![alt text]([https://url_to_image.com](https://github.com/Sameer-Maniyar/Materials/blob/master/src/main/resources/example/smartTxt.png))

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
