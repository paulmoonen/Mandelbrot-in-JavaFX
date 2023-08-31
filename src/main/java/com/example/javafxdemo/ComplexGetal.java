package com.example.javafxdemo;

import lombok.Getter;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * complex getal, met bijbehorende rekenregels
 */

public class ComplexGetal {

    private double r;
    private double i;

    public ComplexGetal(double r, double i) {
        this.r = r;
        this.i = i;
    }

    /**
     * optellen
     * @param g ander getal dat we bij dit getal optellen
     * @return ComplexGetal antwoord
     */
    public ComplexGetal plus(ComplexGetal g) {
        return new ComplexGetal((r + g.getR()), (i + g.getI()));
    }

    /**
     * optellen
     * @param d ander getal dat we bij dit getal optellen
     * @return ComplexGetal antwoord
     */
    public ComplexGetal plus(double d) { return new ComplexGetal(r + d, i);}

    /**
     * aftrekken
     * @param g ander getal dat we van dit getal aftrekken
     * @return ComplexGetal antwoord
     */
    public ComplexGetal minus(ComplexGetal g) {
        return new ComplexGetal((r - g.getR()), (i - g.getI()));
    }

    /**
     * vermenigvuldigen
     * @param g ander getal waarmee we dit getal vermenigvuldigen
     * @return ComplexGetal antwoord
     */
    public ComplexGetal vermenigvuldig( ComplexGetal g) {
        /*
        banaanregel, en i*i = -1
        (a + bi) * (c + di) =
        ac + adi + bci -bd  =
        (ac - bd) , (ad + bc) * i
        */

        return new ComplexGetal((r * g.getR() - i * g.getI()),
                                (r * g.getI() + i * g.r));
    }

    /**
     * kwadrateren
     * @return ComplexGetal antwoord
     */
    public ComplexGetal kwadraat() {
        return this.vermenigvuldig(this);
    }

    /**
     * delen
     * @param g getal waar we het huidige getal door delen
     * @return Complex getal antwoord
     */
    public ComplexGetal gedeeldDoor(ComplexGetal g) {
        /*
        boek Acco deel 1, blz 120, gebruik het complex toegevoegde getal van de deler
        (a + bi) / (c + di)
        boven en onder de breuk vermenigvuldigen met (c - di)
        antwoord:
        reëel: (ac + bd) / (c*c + d*d)
        imaginair: (bc - ad) / (c*c + d*d)
         */

        return new ComplexGetal((r * g.getR() + (i * g.getI() )) / (g.getR() * g.getR() + g.getI() * g.getI()),
                (i * g.getR() - r * g.getI()) / ((g.getR() * g.getR() + g.getI() * g.getI())));
    }

    /**
     * stelling van pythagoras, lengte van de vecorvoorstelling van het complexe getal
     * @return vectorlengte
     */
    public double vectorLengte() {
        return Math.sqrt(r*r + i*i);
    }

    public double getR() { return r;}
    public double getI() { return i;}

    @Override
    public String toString() {
        return String.format("r: %3f, i: %3f", r,i );
    }
}
