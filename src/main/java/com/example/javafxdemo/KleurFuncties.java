package com.example.javafxdemo;

import javafx.scene.paint.Color;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * vertaal integers tussen 1 en 1000 in een kleur
 */
public class KleurFuncties {

    static Color geefHSB( int i) {
        // hue gaat de klok rond
        // 0 = rood, 120 = groen, 240 = blauw
        double hued = Math.log10(i); // [1 - 999] 0 -> 3
        int hue = (int) (120 * hued);
        return Color.hsb(hue, 1,1);
    }

    static Color gebruikSinus( int i) {
        double golf = Math.sin(i) + 1; // uitkomst tussen 0 en 2
        return Color.hsb((180 * golf), 1,1);
    }

    static Color zwartWit() {
        // krijgt alleen 0 - 999 binnen, 1000 is zwart
        return Color.WHITE;
    }
}
