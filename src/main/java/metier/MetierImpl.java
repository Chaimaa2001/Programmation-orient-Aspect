package metier;

import java.util.HashMap;
import java.util.Map;

public class MetierImpl implements IMetier {
    private Map<Long,Compte> comptes=new HashMap<Long,Compte>();
    @Override
    public void addCompte(Compte cp) {
        comptes.put(cp.getCode(), cp);
    }


    @Override
    public void verser(Long code, double mt) throws InterruptedException {
        Compte cp=comptes.get(code);
        cp.setSole(cp.getSole()+mt);
        Thread.sleep(3000);

    }

    @Override
    public void retirer(Long code, double mt) {
        Compte cp=comptes.get(code);
        cp.setSole(cp.getSole()-mt);

    }

    @Override
    public Compte getCompte(Long code) {

        return comptes.get(code);
    }
}
