package prog2.model;

import java.io.Serializable;

public abstract class AccesTerra extends Acces implements Serializable {
    float longitud;

    // Constructor amb estat donat
    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    // Constructor sense estat donat
    public AccesTerra(String nom, float longitud) {
        super(nom);
        this.longitud = longitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String toString(){
        return super.toString() + ", longitud: " + longitud + " metres";
    }
}
