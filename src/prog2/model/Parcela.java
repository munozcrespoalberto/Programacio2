package prog2.model;

public class Parcela extends Allotjament{

    private float mida;
    private boolean electricitat;

    public Parcela(String nom, String id, float mida, boolean electricitat){
        super(nom, id, 4, 2);
        this.mida = mida;
        this.electricitat = electricitat;
    }

    public float getMida(){
        return this.mida;
    }

    public void setMida(float mida){
        this.mida = mida;
    }

    public boolean isConnexioElectrica(){
        return this.electricitat;
    }

    public void setConnexioElectrica(boolean electricitat){
        this.electricitat = electricitat;
    }

    @Override
    public boolean correcteFuncionament() {
        // Una parcela funciona correctamente SI tiene conexión eléctrica
        return this.electricitat;
    }

    @Override
    public String toString() {
        return super.toString() + " Parcela{mida=" + this.mida + ", connexioElectrica=" + this.electricitat + "}";
    }
}

