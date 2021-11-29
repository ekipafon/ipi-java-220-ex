package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Cadre extends Employe {

    private Double coefficient = 1.0;

    public Cadre(String nom, String prenom, String matricule, String sexe, LocalDate dateEmbauche, Double salaire, boolean tempsPartiel, Double coefficient) {
        super(nom, prenom, matricule, sexe, dateEmbauche, salaire, tempsPartiel);
        this.coefficient = coefficient;
    }

    public Cadre(){

    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() * this.coefficient;
    }

    public Double getCoefficient() {
        return this.coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Cadre{" +
                "nom='" + this.getNom() + '\'' +
                ", prenom='" + this.getPrenom() + '\'' +
                ", matricule='" + this.getMatricule() + '\'' +
                ", sexe='" + this.getSexe() + '\'' +
                ", dateEmbauche=" + this.getDateEmbauche() +
                ", salaire=" + this.getSalaire() +
                ", coefficient=" + this.coefficient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cadre cadre = (Cadre) o;
        return Objects.equals(coefficient, cadre.coefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }

    @Override
    public Integer getNbConges(){
        int coeff = this.coefficient.intValue();
        return Entreprise.NB_CONGES_BASE+coeff;
    }


}
