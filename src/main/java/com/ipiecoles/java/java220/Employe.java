package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    private String nom = new String();
    private String prenom = new String();
    private String matricule = new String();
    private String sexe = new String();
    private LocalDate dateEmbauche;
    private Double salaire;
    private boolean tempsPartiel;

    public Employe(){
    }

    public Employe(String nom, String prenom, String matricule, String sexe, LocalDate dateEmbauche, Double salaire, boolean tempsPartiel) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.sexe = sexe;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
        this.tempsPartiel = tempsPartiel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public boolean isTempsPartiel() {
        return tempsPartiel;
    }

    public void setTempsPartiel(boolean tempsPartiel) {
        this.tempsPartiel = tempsPartiel;
    }

    public final Integer getNombreAnneeAnciennete(){
        Integer todayYear = LocalDate.now().getYear();
        Integer nbAnneeAncien;
        Integer anneeEmbauche = this.dateEmbauche.getYear();
        nbAnneeAncien = todayYear - anneeEmbauche;
        return nbAnneeAncien;
    }

    public void augmenterSalaire (Double pourcentage){
        this.salaire += this.salaire*pourcentage;
    }

    public abstract Double getPrimeAnnuelle ();

    public Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", sexe='" + sexe + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                ", tempsPartiel=" + tempsPartiel +
                '}';
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return tempsPartiel == employe.tempsPartiel && Objects.equals(nom, employe.nom) && Objects.equals(prenom, employe.prenom) && Objects.equals(matricule, employe.matricule) && Objects.equals(sexe, employe.sexe) && Objects.equals(dateEmbauche, employe.dateEmbauche) && Objects.equals(salaire, employe.salaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, sexe, dateEmbauche, salaire, tempsPartiel);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if(dateEmbauche == null){
            throw new Exception("La date d'embauche ne peut être nulle");
        }

        if(dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }
}
