package de.fh.Lessons.Lesson8.Dialogs;

import de.fh.Model.WithStream.Audio;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;

public class AudioInputDialog extends Dialog<Audio> {

    public AudioInputDialog() throws IOException, NumberFormatException {

        DialogPane dialogPane = FXMLLoader.load(getClass().getResource("audioInputDialog.fxml"));
        setDialogPane(dialogPane);
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        setTitle("Audioerfassung");

        final TextField firstField  = (TextField) dialogPane.lookup("#firstField");
        final TextField secondField = (TextField) dialogPane.lookup("#secondField");
        final TextField thirdField  = (TextField) dialogPane.lookup("#thirdField");
        final TextField fourthField  = (TextField) dialogPane.lookup("#fourthField");
        setResultConverter((dialogButton) -> {
            ButtonBar.ButtonData data =
                    dialogButton == null ? null : dialogButton.getButtonData();
            Audio audio = null;
            try {
                audio = new Audio(firstField.getText(), Integer.parseInt(fourthField.getText()), secondField.getText(), Integer.parseInt(thirdField.getText()));
            } catch (NumberFormatException e) {
                System.out.println("Invalid year! " + e.getMessage());
            }
            return data == ButtonBar.ButtonData.OK_DONE ? audio : null;
        });
    }
}
