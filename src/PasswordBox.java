import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PasswordBox {
    static String password = null;

    public static String show() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        window.setTitle("Authentication");
        window.setMinWidth(450);
        window.setMinHeight(300);
        window.setMaxWidth(450);
        window.setMinHeight(300);
        Label label = new Label();
        label.setText("Enter Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        passwordField.setMaxWidth(280);
        passwordField.setMinWidth(280);

        Button confirm = new Button("Confirm");
        confirm.setOnAction(e -> {
            password = passwordField.getText();
            window.close();
        });

        Button cancel = new Button("Cancel");
        cancel.setOnAction(e -> {
            password = null;
            window.close();
        });
        confirm.setMinWidth(75);
        cancel.setMinWidth(75);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        HBox hBox = new HBox(20);
        hBox.setMinWidth(280);
        hBox.setMaxWidth(280);
        hBox.setMargin(confirm, new Insets(10, 10, 0, 0));
        hBox.setMargin(cancel, new Insets(10, 0, 0, 0));
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(confirm, cancel);

        layout.getChildren().addAll(label, passwordField, hBox);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return password;
    }
}
