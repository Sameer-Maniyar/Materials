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
