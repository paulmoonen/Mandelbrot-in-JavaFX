package com.example.javafxdemo;

import javafx.scene.paint.Color;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * beschrijving van het programma
 */
public class KleurFuncties {
    static Color geefGrijswaarde(int i) {
        double eenduizendste = i / 1000;
        return Color.gray(eenduizendste,1);
    }

    static Color geefRGB(int i) {
      /*
      0 tot 999 delen we op in drie delen
      r: 0 -> 333
      g: 334 -> 666
      b: 667 -> 999
       */
        if(i <= 333) {
            return new Color( (i / 333), 0, 0, 1); // rood
        }
        else if ( i <= 666 ) {
            return new Color (1, ((i - 333)/333),0,1); // groen
        }
        return new Color(1,1, ((i - 666)/333), 1); // blauw
    }

    static Color geefHSB( int i) {
        // hue gaat de klok rond
        // 0 = rood, 120 = groen, 240 = blauw
        int hue = (int) (i / 1000)* 360;
        return Color.hsb(hue, 1,1);
    }
}
