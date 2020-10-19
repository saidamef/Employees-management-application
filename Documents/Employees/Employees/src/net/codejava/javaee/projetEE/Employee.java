package net.codejava.javaee.projetEE;

public class Employee {
    protected int Matricule;
    protected String Nom;
    protected String Prénom;
    protected int Département;

    public Employee(int matricule, String nom, String prénom, int département) {
        Matricule = matricule;
        Nom = nom;
        Prénom = prénom;
        Département = département;
    }

    public Employee(int matricule) {
        Matricule = matricule;
    }

    public Employee(String nom, String prénom, int département) {
        Nom = nom;
        Prénom = prénom;
        Département = département;
    }

    public int getMatricule() {
        return Matricule;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrénom() {
        return Prénom;
    }

    public int getDépartement() {
        return Département;
    }

    public void setMatricule(int matricule) {
        Matricule = matricule;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrénom(String prénom) {
        Prénom = prénom;
    }

    public void setDépartement(int département) {
        Département = département;
    }
}
