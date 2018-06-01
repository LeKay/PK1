package de.fh.Lessons.Lesson8.Dialogs;

import de.fh.Model.WithStream.Bild;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;

public class PictureInputDialog extends Dialog<Bild> {

    public PictureInputDialog() throws IOException {

        DialogPane dialogPane = FXMLLoader.load(getClass().getResource("picInputDialog.fxml"));
        setDialogPane(dialogPane);
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        final TextField firstField  = (TextField) dialogPane.lookup("#firstField");
        final TextField secondField = (TextField) dialogPane.lookup("#secondField");
        final TextField thirdField  = (TextField) dialogPane.lookup("#thirdField");

        try {
            setResultConverter((dialogButton) -> {
                ButtonBar.ButtonData data =
                        dialogButton == null ? null : dialogButton.getButtonData();
                return data == ButtonBar.ButtonData.OK_DONE
                        ? new Bild(firstField.getText(), Integer.parseInt(thirdField.getText()), secondField.getText())
                        : null;
            });
        } catch (NumberFormatException e) {
            System.out.println("Invalid year! " + e.getMessage());
            new PictureInputDialog();
        }
    }

}
