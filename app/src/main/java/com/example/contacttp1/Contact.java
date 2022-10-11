package com.example.contacttp1;

public class Contact {
    public String nom;
    public String prenom;
    public String numero;

    public Contact() {
    }

    public Contact(String nom, String prenom, String numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return  nom + ' ' +
                prenom +
                ", numero=" + numero
                ;
    }
}
