package metier;

public class Compte {
    private Long code;
    private double sole;

    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", sole=" + sole +
                '}';
    }

    public Compte(Long code, double sole) {
        this.code = code;
        this.sole = sole;
    }

    public Compte() {
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setSole(double sole) {
        this.sole = sole;
    }

    public Long getCode() {
        return code;
    }

    public double getSole() {
        return sole;
    }
}
