package metier;

public interface IMetier {
     void addCompte(Compte cp);
     void verser(Long code,double mt) throws InterruptedException;
     void retirer(Long code ,double mt);
     Compte getCompte(Long code);

}