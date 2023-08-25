package com.example.javafxdemo;

/**
 * @author Paul Moonen
 * <p>
 * p.c.c.moonen@gmail.com
 * <p>
 * verplaats een waarde van het ene domein naar het andere
 */
public class BereikMap {


    public static double mapWaarde(final double onderGrensOud, final double bovenGrensOud,
                            final double voortgangOud, final double onderGrensNieuw, final double bovenGrensNieuw) {
        double voortgangPercentage = (voortgangOud - onderGrensOud) / (bovenGrensOud - onderGrensOud);
        return ((bovenGrensNieuw - onderGrensNieuw) * voortgangPercentage) + onderGrensNieuw;
    }
}
