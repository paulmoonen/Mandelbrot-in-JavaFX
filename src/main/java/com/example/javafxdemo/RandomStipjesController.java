package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * beschrijving van het programma
 */
public class RandomStipjesController implements Initializable {
    public static final int HOOGTE = 400;
    public static final int BREEDTE = 600;

    @FXML
    private Canvas canvas;

    @FXML
    private GraphicsContext context;

    @FXML
    private Label coordinatenTekst;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        context = canvas.getGraphicsContext2D();
        leegKlikHandler(new ActionEvent());
    }

    public void canvasClickHandler(@NotNull MouseEvent mouseEvent) {
        int x = (int)mouseEvent.getX();
        int y = (int)mouseEvent.getY();
        coordinatenTekst.setText(String.format("x: %d y: %d", x,y));
    }

    private void plaatsStipjes() {
        for(int i = 0; i < 100; i++){
            int pointX = getRandom(BREEDTE);
            int pointY = getRandom(HOOGTE);
            context.setStroke(new Color(Math.random(), Math.random(), Math.random(),1 ));
            context.strokeLine(pointX, pointY, pointX, pointY);
        }
    }

    public int getRandom(int maxIncl){
        int spreidingBreedte = maxIncl + 1;
        double randomVanafNul = Math.random() * spreidingBreedte;
        return (int)randomVanafNul;
    }

    public void vulKlikHandler(ActionEvent actionEvent) {
        plaatsStipjes();
    }

    public void leegKlikHandler(ActionEvent actionEvent) {
        context.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
        context.setFill(Color.BLACK);
        context.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
    }
}
