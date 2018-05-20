package de.fh.Lessons.Lesson6.Timer;

import javafx.scene.control.Alert;

public class Zeitansage {

    public static void start() {
        final long startTime = System.currentTimeMillis();
        Timer timer = new Timer(() -> {
            int passed = Math.round((System.currentTimeMillis() - startTime)/1000);
            System.out.println(passed + " Sekunden seit Start");
        });
        timer.start();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText("Zeitansage stoppen");
        alert.setOnCloseRequest(event -> { alert.close();  timer.terminate(); });
        alert.showAndWait();
    }

}
