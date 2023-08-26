package com.example.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import static com.example.javafxdemo.Constants.BREEDTE;
import static com.example.javafxdemo.Constants.HOOGTE;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * events afhandelen
 */
public class RandomStipjesController implements Initializable {

    private static Set<Point2D> pixelMatrix;

    @FXML private Canvas canvas;

    @FXML private GraphicsContext context;

    @FXML private Label tekst;

    private BereikMap bereikMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        context = canvas.getGraphicsContext2D();
        leegKlikHandler(new ActionEvent());
        pixelMatrix = new HashSet<>();
        for(int x = 0; x < BREEDTE; x++){
            for(int y = 0; y < HOOGTE; y++){
                pixelMatrix.add(new Point2D(x,y));
            }
        }
        bereikMap = new BereikMap(-30,30,-20,20);
    }

    public void canvasClickHandler(@NotNull MouseEvent mouseEvent) {
        int x = (int)mouseEvent.getX();
        int y = (int)mouseEvent.getY();
        Point2D klik = new Point2D(x, y);
        Point2D wiskundig = bereikMap.mapPoint(klik);
        tekst.setText(String.format("Klik x: %d y: %d\nwiskundig x: %f y: %f\n",
                x,y, wiskundig.getX(), wiskundig.getY() ));
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

    public void randomKlikHandler(ActionEvent actionEvent) {
        plaatsStipjes();
    }

    public void leegKlikHandler(ActionEvent actionEvent) {
        context.clearRect(0,0,canvas.getWidth(), canvas.getHeight());
        context.setFill(Color.BLACK);
        context.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
    }

    public void vloedKlikHandler(ActionEvent actionEvent) {

        for (Point2D punt : pixelMatrix) {
            double grijswaarde = geefGrijswaarde(punt);
            context.setStroke(new Color(grijswaarde, grijswaarde, grijswaarde,1 ));
            context.strokeLine(punt.getX(), punt.getY(), punt.getX(), punt.getY());
        }
    }

    static double geefGrijswaarde(Point2D punt) {
        return (punt.getX() + punt.getY()) / 1000;
    }
}
