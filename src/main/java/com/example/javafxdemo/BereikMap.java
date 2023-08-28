package com.example.javafxdemo;

import javafx.geometry.Point2D;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import static com.example.javafxdemo.Constants.BREEDTE;
import static com.example.javafxdemo.Constants.HOOGTE;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * verplaats een waarde van het ene domein naar het andere
 */
@Accessors
@AllArgsConstructor
public class BereikMap {

    private double xLaag;
    private double xHoog;
    private double yLaag;
    private double yHoog;

    /**
     * vertaal een muisklik-locatie in het Canvas-element, naar het juiste wiskundige punt
     * in een begrensd stuk wiskundig coördinatenstelsel
     * @param punt muisklik-coördinaten
     * @return Point2D wiskundig punt
     */
    public Point2D mapPoint(Point2D punt) {
        double x = ((punt.getX() / BREEDTE) * (xHoog - xLaag)) + xLaag;
        double y = ((HOOGTE - punt.getY()) / HOOGTE) * (yHoog - yLaag) + yLaag;
        return new Point2D(x,y);
    }

    public ComplexGetal mapGetal(Point2D punt) {
        double x = ((punt.getX() / BREEDTE) * (xHoog - xLaag)) + xLaag;
        double y = ((HOOGTE - punt.getY()) / HOOGTE) * (yHoog - yLaag) + yLaag;
        return new ComplexGetal(x, y);
    }
}
