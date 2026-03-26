package prog2.model;

public class Parcela extends Allotjament{


    private float mida;
    private boolean electricitat;

    public Parcela(String nom, String id, float mida, boolean electricitat){
        super(nom, id, 4, 2);
        this.mida = mida;
        this.electricitat = electricitat;
    }

    // Mètode que retorna la mida de la parcel·la
    public float getMida(){
        return this.mida;
    }

    // Assigna el valor del paràmetre a mida
    public void setMida(float mida){
        this.mida = mida;
    }

    // Mètode que ens diu si te connexió elèctrica
    public boolean isConnexioElectrica(){
        return this.electricitat;
    }

    // Assigna el valor del paràmetre a electricitat
    public void setConnexioElectrica(boolean electricitat){
        this.electricitat = electricitat;
    }

    // Mètode que ens mostra les característiques que te la parcel·la
    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + this.mida + ", connexioElectrica=" + this.electricitat + "}";
    }
}

