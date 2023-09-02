package com.example.javafxdemo;

import javafx.geometry.Point2D;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BereikMapTest {

    private static BereikMap bereikmap;

    /**
     * maak een wiskundig gebied van 60 breed en 40 hoog,
     * met de oorsprong in het midden
     */
    @BeforeAll
    static void init() {
        bereikmap = new BereikMap(-30,30, -20,20);
    }

    @Test
    @DisplayName("Midden van canvas is wiskundig nulpunt")
    void middenCanvasIsNulpunt() {
        Point2D geklikt = new Point2D(450, 300); // midden in canvas
        Point2D wiskundig = bereikmap.mapPoint(geklikt);
        assertEquals(0, wiskundig.getX());
        assertEquals(0, wiskundig.getY());
    }

    @Test
    @DisplayName("punt linksbovenin beeld aangeklikt krijgt de juiste x- en y-waardes")
    void eenTiendeVanLinksboven() {
        Point2D geklikt = new Point2D(90,60);
        Point2D wiskundig = bereikmap.mapPoint(geklikt);
        assertEquals(-24, wiskundig.getX());
        assertEquals(16, wiskundig.getY());
    }
}