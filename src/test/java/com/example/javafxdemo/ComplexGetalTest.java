package com.example.javafxdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexGetalTest {

    @Test
    void telOp() {
        ComplexGetal a = new ComplexGetal(3,-5);
        ComplexGetal b = new ComplexGetal(4, 2);

        ComplexGetal som = a.plus(b);

        assertEquals(7, som.getR());
        assertEquals(-3, som.getI());
    }

    @Test
    void telDoubleBijOp() {
        ComplexGetal a = new ComplexGetal(3,-5);
        double b = 1.35;

        ComplexGetal som = a.plus(b);

        assertEquals(4.35, som.getR());
        assertEquals(-5, som.getI());
    }



    @Test
    void trekAf() {
        ComplexGetal a = new ComplexGetal(5,-3);
        ComplexGetal b = new ComplexGetal(2,4);

        ComplexGetal verschil = a.minus(b);

        assertEquals(3, verschil.getR());
        assertEquals(-7,verschil.getI());
    }

    @Test
    void vermenigvuldig() {
        ComplexGetal a = new ComplexGetal(3,2);
        ComplexGetal b = new ComplexGetal(4,5);

        ComplexGetal product = a.vermenigvuldig(b);

        assertEquals(2, product.getR());
        assertEquals(23,product.getI());
    }

    @Test
    void kwadraat() {
        ComplexGetal a = new ComplexGetal(3,2);

        ComplexGetal kwadraat = a.kwadraat();

        assertEquals(5, kwadraat.getR());
        assertEquals(12, kwadraat.getI());
    }

    @Test
    void delenDoor() {
        ComplexGetal teller = new ComplexGetal(1,2);
        ComplexGetal noemer = new ComplexGetal(3,-4);

        ComplexGetal breuk = teller.gedeeldDoor(noemer);

        assertEquals(-0.2, breuk.getR());
        assertEquals(0.4, breuk.getI());
    }

    @Test
    void vectorLengte() {
        ComplexGetal getal = new ComplexGetal(3,4);
        assertEquals(5, getal.vectorLengte());
    }
}