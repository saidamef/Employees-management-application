package net.codejava.javaee.projetEE;


public class Department {
    protected int Matricule;
    protected String Titre;

    public Department(String titre) {
        Titre = titre;
    }

    public Department(int matricule, String titre) {
        Matricule = matricule;
        Titre = titre;
    }

    public int getMatricule() {
        return Matricule;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }
}