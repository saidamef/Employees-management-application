package net.codejava.javaee.projetEE;

public class Employee {
    protected int Matricule;
    protected String Nom;
    protected String Pr�nom;
    protected int D�partement;

    public Employee(int matricule, String nom, String pr�nom, int d�partement) {
        Matricule = matricule;
        Nom = nom;
        Pr�nom = pr�nom;
        D�partement = d�partement;
    }

    public Employee(int matricule) {
        Matricule = matricule;
    }

    public Employee(String nom, String pr�nom, int d�partement) {
        Nom = nom;
        Pr�nom = pr�nom;
        D�partement = d�partement;
    }

    public int getMatricule() {
        return Matricule;
    }

    public String getNom() {
        return Nom;
    }

    public String getPr�nom() {
        return Pr�nom;
    }

    public int getD�partement() {
        return D�partement;
    }

    public void setMatricule(int matricule) {
        Matricule = matricule;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPr�nom(String pr�nom) {
        Pr�nom = pr�nom;
    }

    public void setD�partement(int d�partement) {
        D�partement = d�partement;
    }
}
