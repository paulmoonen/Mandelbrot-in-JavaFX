package com.example.javafxdemo;

import javafx.geometry.Point2D;
import lombok.Setter;

import static com.example.javafxdemo.Constanten.BREEDTE;
import static com.example.javafxdemo.Constanten.HOOGTE;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * vertaal een muisklik in het canvas naar een complex getal
 */
@Setter
public class BereikMap {

    public static final double ZOOMFACTOR = 1.1 ;
    private double rLaag;
    private double rHoog;
    private double iLaag;
    private double iHoog;

    public BereikMap(double rLaag, double rHoog, double iLaag, double iHoog) {
        this.rLaag = rLaag;
        this.rHoog = rHoog;
        this.iLaag = iLaag;
        this.iHoog = iHoog;
    }

    /**
     * vertaal een muisklik-locatie in het Canvas-element, naar het juiste wiskundige punt
     * in een begrensd stuk wiskundig coördinatenstelsel
     * @param punt muisklik-coördinaten
     * @return Point2D wiskundig punt
     */
    public Point2D mapPoint(Point2D punt) {
        double x = ((punt.getX() / BREEDTE) * (rHoog - rLaag)) + rLaag;
        double y = ((HOOGTE - punt.getY()) / HOOGTE) * (iHoog - iLaag) + iLaag;
        return new Point2D(x,y);
    }

    public ComplexGetal mapGetal(Point2D punt) {
        double x = ((punt.getX() / BREEDTE) * (rHoog - rLaag)) + rLaag;
        double y = ((HOOGTE - punt.getY()) / HOOGTE) * (iHoog - iLaag) + iLaag;
        return new ComplexGetal(x, y);
    }

    public void zoomKaderInOpPunt(Point2D klik) {
        ComplexGetal p = mapGetal(klik);
        setRLaag(p.getR() - ( (p.getR() - rLaag) / ZOOMFACTOR));
        setRHoog(p.getR() + ( (rHoog - p.getR()) / ZOOMFACTOR));
        setILaag(p.getI() - ( (p.getI() - iLaag) / ZOOMFACTOR));
        setIHoog(p.getI() + ( (iHoog - p.getI()) / ZOOMFACTOR));
    }

    @Override
    public String toString() {
        return String.format("x van %d tot %d\ny van %d tot %d", rLaag, rHoog, iLaag, iHoog);
    }
}
