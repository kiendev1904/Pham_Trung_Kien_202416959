package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadio;

    @FXML
    private RadioButton eraserRadio;

    @FXML
    private ToggleGroup toolGroup;

    @FXML
    void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        Circle dot = new Circle(x, y, 4);
        if (eraserRadio.isSelected()) {
            dot.setFill(Color.WHITE);
            dot.setStroke(Color.WHITE);
        } else {
            dot.setFill(Color.BLACK);
            dot.setStroke(Color.BLACK);
        }
        drawingAreaPane.getChildren().add(dot);
    }
}