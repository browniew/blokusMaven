package blokus.view;

import blokus.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class View implements FXComponent{

    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {

        BorderPane borderPane = new BorderPane();

        int color = controller.getColor();
        int turn = 1;

        GridPane gridBlue = new GridPane();

        Rectangle button;

        int width = 21;
        int height = 13;

        int i = 0;
        int j;
        //int color = 6;

        while (i < width) {
            j = 0;
            while (j < height) {
                int l = i;
                int k = j;
                button = new Rectangle(12, 12);
                if (controller.colorBlue(j, i)) {
                    button.setFill(Paint.valueOf("blue"));
                } else {
                    button.setFill(Paint.valueOf("gray"));
                }
                button.setOnMouseClicked(
                        e -> {
                            if (e.getButton() == MouseButton.PRIMARY) {
                                controller.togglePieceBlue(k, l);
                            }
                        });
                gridBlue.add(button, i, j);
                j += 1;
            }
            i += 1;
        }

        i = 0;

        while (i < width) {
            j = 0;
            while (j < height) {
                int l = i;
                int k = j;
                button = new Rectangle(12, 12);
                if (controller.colorYellow(j, i)) {
                    button.setFill(Paint.valueOf("yellow"));
                } else {
                    button.setFill(Paint.valueOf("gray"));
                }
                button.setOnMouseClicked(
                        e -> {
                            if (e.getButton() == MouseButton.PRIMARY) {
                                controller.togglePieceYellow(k, l);
                            }
                        });
                gridBlue.add(button, i, j + 13);
                j += 1;
            }
            i += 1;
        }

        i = 0;

        while (i < width) {
            j = 0;
            while (j < height) {
                int l = i;
                int k = j;
                button = new Rectangle(12, 12);
                if (controller.colorRed(j, i)) {
                    button.setFill(Paint.valueOf("red"));
                } else {
                    button.setFill(Paint.valueOf("gray"));
                }
                button.setOnMouseClicked(
                        e -> {
                            if (e.getButton() == MouseButton.PRIMARY) {
                                controller.togglePieceRed(k, l);
                            }
                        });
                gridBlue.add(button, i, j + 13 + 13);
                j += 1;
            }
            i += 1;
        }

        i = 0;

        while (i < width) {
            j = 0;
            while (j < height) {
                int l = i;
                int k = j;
                button = new Rectangle(12, 12);
                if (controller.colorGreen(j, i)) {
                    button.setFill(Paint.valueOf("green"));
                } else {
                    button.setFill(Paint.valueOf("gray"));
                }
                button.setOnMouseClicked(
                        e -> {
                            if (e.getButton() == MouseButton.PRIMARY) {
                                controller.togglePieceGreen(k, l);
                            }
                        });
                gridBlue.add(button, i, j + 13 + 13 + 13);
                j += 1;
            }
            i += 1;
        }


        //----------------------------------------------------------------------------------
        //main blokus block

        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);

        int rowLength = 20;
        int colLength = 20;

        i = 0;

        //color = 6;

        while (i < rowLength) {
            j = 0;
            while (j < colLength) {
                int l = i;
                int k = j;
                button = new Rectangle(25, 25);
                if (controller.isBlue(j, i)) {
                    button.setFill(Paint.valueOf("blue"));
                } else if (controller.isRed(j, i)) {
                    button.setFill(Paint.valueOf("red"));
                } else if (controller.isYellow(j, i)) {
                    button.setFill(Paint.valueOf("yellow"));
                } else if (controller.isGreen(j, i)) {
                    button.setFill(Paint.valueOf("green"));
                } else {
                    button.setFill(Paint.valueOf("gray"));
                }
                button.setOnMouseClicked(
                        e -> {
                            if (e.getButton() == MouseButton.PRIMARY) {
                                controller.toggleShaded(k, l, color);
                            }
                            });
                grid.add(button, i, j);
                j += 1;
            }
            i += 1;
        }



        borderPane.setCenter(grid);
        BorderPane.setAlignment(grid, Pos.CENTER);
        borderPane.setLeft(gridBlue);

        return borderPane;
    }
}
