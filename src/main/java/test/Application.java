package test;

import metier.Compte;
import metier.IMetier;
import metier.MetierImpl;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        System.out.println("Demarrage de l'application ...");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Code :");
        Long code=scanner.nextLong();
        System.out.println("Solde");
        double solde=scanner.nextDouble();
        IMetier metier=new MetierImpl();
        metier.addCompte(new Compte(code,solde));

        while(true){
            try {
                System.out.println("--------------------------------");
                System.out.println(metier.getCompte(code).toString());
                System.out.println("Type Operation :");
                String typeOp=scanner.next();
                if(typeOp.equals("quitter")) break;
                System.out.println("Montant:");
                double mt=scanner.nextDouble();
                if(typeOp.toLowerCase().equals("v")) metier.verser(code,mt);
                if(typeOp.toLowerCase().equals("r")) metier.retirer(code,mt);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("Fin de l'application");

    }

}
