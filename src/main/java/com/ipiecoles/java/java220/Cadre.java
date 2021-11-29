package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Cadre extends Employe {

    private Double coefficiant = 1.0;

    public Cadre(String nom, String prenom, String matricule, String sexe, LocalDate dateEmbauche, Double salaire, boolean tempsPartiel, Double coefficiant) {
        super(nom, prenom, matricule, sexe, dateEmbauche, salaire, tempsPartiel);
        this.coefficiant = coefficiant;
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() * coefficiant;
    }

    public Double getCoefficiant() {
        return coefficiant;
    }

    public void setCoefficiant(Double coefficiant) {
        this.coefficiant = coefficiant;
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
                ", coefficiant=" + coefficiant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cadre cadre = (Cadre) o;
        return Objects.equals(coefficiant, cadre.coefficiant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficiant);
    }

    @Override
    public Integer getNbConges(){
        int coeff = coefficiant.intValue();
        return Entreprise.NB_CONGES_BASE+coeff;
    }


}
