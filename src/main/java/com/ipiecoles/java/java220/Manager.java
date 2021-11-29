package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;

public class Manager extends Employe{

    private HashSet<Technicien> equipe = new HashSet<>();


    public Manager() {

    }

    public Manager(String nom, String prenom, String matricule, String sexe, LocalDate dateEmbauche, Double salaire, boolean tempsPartiel, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, sexe, dateEmbauche, salaire, tempsPartiel);
        this.equipe = equipe;
    }

    @Override
    public Double getPrimeAnnuelle(){
       Double nvllePrime = Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
       return nvllePrime;
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, String sexe, LocalDate dateEmbauche, Double salaire, boolean tempsPartiel, Integer grade){
        this.ajoutTechnicienEquipe(new Technicien(nom, prenom, matricule, sexe, dateEmbauche, salaire, tempsPartiel, grade));
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    @Override
    public void setSalaire(Double salaire) {
        Double nvSalaire = salaire * Entreprise.INDICE_MANAGER + (salaire*10/100) * equipe.size();
        super.setSalaire(nvSalaire);
    }

    @Override
    public void augmenterSalaire(Double pourcentenge){
        super.augmenterSalaire(pourcentenge);
        this.augmenterSalaireEquipe(pourcentenge);
    }

    private void augmenterSalaireEquipe (Double pourcentage){
        for (Technicien t : this.equipe){
            t.augmenterSalaire(pourcentage);
        }
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public void ajoutTechnicienEquipe(Technicien leTechnicien){
        equipe.add(leTechnicien);
    }
}
