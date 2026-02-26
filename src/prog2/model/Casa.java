package prog2.model;

public abstract class Casa extends Allotjament {
    private String mida;
    private int numHabitacions;
    private int persones;
    // Aquí irán los atributos y métodos
    public Casa(String mida, int numHabitacions, int Persones, String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa) {
        super(nom, id, estadaMinimaAlta, estadaMinimaBaixa);
        this.mida = mida;
        this.numHabitacions = numHabitacions;
        this.persones = Persones;
    }
    // Mètode que retorna la mida
    public String getMida(){
        return this.mida;
    }
    // Assigna el valor del paràmetre a mida
    public void setMida(String mida) {
        this.mida = mida;
    }

    // Mètode que retorna el número d'habitacions
    public int getNumHabitacions() {
        return this.numHabitacions;
    }
    // Assigna el valor del paràmetre a numHabitacions
    public void setNumHabitacions(int numHabitacions) { this.numHabitacions = numHabitacions; }

    // Mètode que retorna el número de persones
    public int getPersones() { return this.persones;}
    // Assigna el valor del paràmetre a persones
    public void setPersones(int persones) { this.persones = persones; }
}
