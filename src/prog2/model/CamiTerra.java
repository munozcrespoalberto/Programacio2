package prog2.model;

public class CamiTerra extends AccesTerra{
    // Constructor amb estat donat
    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, estat, longitud);
    }

    // Constructor sense estat donat
    public CamiTerra(String nom, float longitud) {
        super(nom, longitud);
    }

    // Sempre camins donen false
    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString(){
        return super.toString() + ", Tipus: Camí de terra";
    }
}
