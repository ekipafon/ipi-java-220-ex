package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe implements Comparable<Technicien>{
    private Integer grade;

    public Technicien() {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        Double augmentation = (double) (this.grade*10)/100;
        Double nvSalaire = salaire * (1+augmentation);
        super.setSalaire(nvSalaire);
    }

    @Override
    public Integer getNbConges(){
        return (super.getNbConges()+getNombreAnneeAnciennete());
    }

    public Double getPrimeAnnuelle(){
        Double augmentation = (double) (this.grade*10)/100;
        Double nvllePrime = Entreprise.primeAnnuelleBase() * (1+augmentation) + Entreprise.PRIME_ANCIENNETE*this.getNombreAnneeAnciennete();
        return nvllePrime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public int compareTo(Technicien t){
        if(this.getGrade() < t.getGrade()){
            return -1;
        }
        else if (this.getGrade()>t.getGrade()){
            return 1;
        }
        return 0;
    }


}
