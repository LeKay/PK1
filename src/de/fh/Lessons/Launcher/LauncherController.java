package de.fh.Lessons.Launcher;

import de.fh.Lessons.Lesson1.Lesson1;
import de.fh.Lessons.Lesson2.Lesson2;
import de.fh.Lessons.Lesson3.Lesson3;
import de.fh.Lessons.Lesson4.Lesson4;
import de.fh.Lessons.Lesson5.Lesson5;
import de.fh.Lessons.Lesson6.Lesson6;
import de.fh.Lessons.Lesson7.Lesson7;
import de.fh.Lessons.Lesson8.Lesson8;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LauncherController implements Initializable{

    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn1.setOnAction(event -> Lesson1.start());
        btn2.setOnAction(event -> Lesson2.start());
        btn3.setOnAction(event -> Lesson3.start());
        btn4.setOnAction(event -> Lesson4.start());
        btn5.setOnAction(event -> Lesson5.start());
        btn6.setOnAction(event -> Lesson6.start());
        btn7.setOnAction(event -> Lesson7.start());
        btn8.setOnAction(event -> Lesson8.start());
    }

}
