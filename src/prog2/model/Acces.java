package prog2.model;

public abstract class Acces implements InAcces{

    // Atributs de tots els tipus d'accesos
    private String nom;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;
    // Constructor
    public Acces(String nom) {
        this.nom = nom;
        this.estat = true; // Esta obert per defecte
        this.llistaAllotjaments = new LlistaAllotjaments();
    }
    // Constructor però posem estat
    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    // Getters i setters
    @Override
    public String getNom(){
        return nom;
    }

    // Mètode abstracte cada subclasse implementa la seva accesssibilitat
    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public boolean getEstat(){
        return estat;
    }
    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return llistaAllotjaments;
    }

    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    @Override
    public void obrirAcces() {
        this.estat = true;
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament){
        this.llistaAllotjaments.afegirAllotjament(allotjament);
    }

    @Override
    public String toString(){
        return "Acces: " + nom  +
                ". Accessibilitat: " + (isAccessibilitat() ? "Sí" : "No") +
                ", Estat: " + (estat ? "Obert" : "Tancat");
    }
}
