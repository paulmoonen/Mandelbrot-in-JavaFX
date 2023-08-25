package com.example.javafxdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BereikMapTest {

    @Test
    void percentageBlijftGelijkBijPositieveGelijkeRichting() {
        double onderGrensOud = 0;
        double bovenGrensOud = 10;
        double voortgangOud = 2;
        double onderGrensNieuw = 0;
        double bovenGrensNieuw = 100;

        assertEquals(20, BereikMap.mapWaarde(onderGrensOud, bovenGrensOud,
                voortgangOud, onderGrensNieuw, bovenGrensNieuw) );
    }

    @Test
    void percentageBlijftGelijkRondOorsprongGelijkeRichting() {
        double onderGrensOud = -5;
        double bovenGrensOud = 5;
        double voortgangOud = -3;
        double onderGrensNieuw = 0;
        double bovenGrensNieuw = 100;

        assertEquals(20, BereikMap.mapWaarde(onderGrensOud, bovenGrensOud,
                voortgangOud, onderGrensNieuw, bovenGrensNieuw) );
    }

    @Test
    void yAsTest() {
        // 4oo pixels hoog scherm, linksboven oorsprong
        double onderGrensOud = 400;
        double bovenGrensOud = 0;
        double voortgangOud = 2;
        double onderGrensNieuw = 4;
        double bovenGrensNieuw = 5;

        assertEquals(4.995, BereikMap.mapWaarde(onderGrensOud, bovenGrensOud,
                voortgangOud, onderGrensNieuw, bovenGrensNieuw) );
    }
}