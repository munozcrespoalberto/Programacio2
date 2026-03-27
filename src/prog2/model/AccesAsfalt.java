package prog2.model;

public abstract class AccesAsfalt extends Acces {
    private float metresQuadratsAsfalt;

    // Constructor amb estat donat
    public AccesAsfalt(String nom, boolean estat, float metresQuadratsAsfalt) {
        super(nom, estat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    // Constructor sense estat donat
    public AccesAsfalt(String nom, float metresQuadratsAsfalt) {
        super(nom);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    public float getMetresQuadratsAsfalt() {
        return metresQuadratsAsfalt;
    }

    public void setMetresQuadratsAsfalt(float metresQuadratsAsfalt) {
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    // L'implementem a les seves subclasses
    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String toString(){
        return super.toString() + ", metres Quadrats d'asfalt: " + metresQuadratsAsfalt + " metres quadrats";
    }
}
