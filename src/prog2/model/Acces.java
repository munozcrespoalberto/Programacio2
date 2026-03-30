package prog2.model;
import java.io.Serializable;
public abstract class Acces implements InAcces, Serializable{

    // Atributs de tots els tipus d'accesos
    private String nom;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    // Constructor només amb nom
    public Acces(String nom) {
        this.nom = nom;
        this.estat = true; // Esta obert per defecte
        this.llistaAllotjaments = new LlistaAllotjaments();
    }

    // Constructor quan passa per paràmetres nom i estat
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
                ", accessibilitat: " + (isAccessibilitat() ? "Sí" : "No") +
                ", estat: " + (estat ? "Obert" : "Tancat");
    }
}
