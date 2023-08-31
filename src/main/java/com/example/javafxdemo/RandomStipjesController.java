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

import static com.example.javafxdemo.Constants.*;
import static com.example.javafxdemo.KleurFuncties.geefHSB;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * events afhandelen
 */
public class RandomStipjesController implements Initializable {

    private static final int R_LAAG1 = -2;
    private static final int R_HOOG1 = 1;
    private static final int I_LAAG1 = -1;
    private static final int I_HOOG1 = 1;
    private static final double VLUCHTGRENS = 4;
    private static Set<Point2D> pixelMatrix;

    @FXML private Canvas canvas;

    @FXML private GraphicsContext context;

    @FXML private Label tekst;

    private BereikMap bereikMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        context = canvas.getGraphicsContext2D();
        pixelMatrix = new HashSet<>();
        for(int x = 0; x < BREEDTE; x++){
            for(int y = 0; y < HOOGTE; y++){
                pixelMatrix.add(new Point2D(x,y));
            }
        }
        resetBereikmap();
        tekenMandelbrot();
    }

    private void resetBereikmap() {
        bereikMap = new BereikMap(R_LAAG1, R_HOOG1, I_LAAG1, I_HOOG1);
    }

    public void canvasClickHandler(@NotNull MouseEvent mouseEvent) {
        int x = (int)mouseEvent.getX();
        int y = (int)mouseEvent.getY();
        Point2D klik = new Point2D(x, y);
        bereikMap.zoomKaderInOpPunt(klik);
        tekenMandelbrot();
    }

    public void resetKlikHandler(ActionEvent actionEvent) {
        resetBereikmap();
        tekenMandelbrot();
    }

    public void MandelbrotKlikHandler(ActionEvent actionEvent) {
        tekenMandelbrot();
    }

    private void tekenMandelbrot() {
        for (Point2D punt : pixelMatrix) {
            ComplexGetal iter = new ComplexGetal(0,0);
            ComplexGetal c = bereikMap.mapGetal(punt);

            int i;
            for(i = 0; i < 1000; i++) {
                if(iter.vectorLengte() > VLUCHTGRENS) {
                    break;
                }
                iter  = iter.kwadraat().plus(c);
            }
            Color kleur = (i < 1000)? geefHSB(i) : Color.BLACK;
            tekenPunt(punt,kleur);
        }
    }

    private void tekenPunt(Point2D punt, Color kleur) {
        context.setStroke(kleur);
        context.strokeLine(punt.getX(), punt.getY(), punt.getX(), punt.getY());
    }
}
