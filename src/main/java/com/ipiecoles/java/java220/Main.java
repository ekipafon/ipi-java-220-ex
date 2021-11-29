package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cadre cadreTest = new Cadre("Contri", "Matteo", "T456VB", "Homme", LocalDate.now(),1000.0,false, 1.8);
        cadreTest.getNbConges();
        cadreTest.toString();
        System.out.println(cadreTest.toString());
    }
}
