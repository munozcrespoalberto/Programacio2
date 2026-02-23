package prog2.model;

public class Client implements InClient{

    // Nom i DNI del client
    private String nom;
    private String dni;

    // Constructor del client
    public Client(String nom, String dni){
        this.nom = nom;
        this.dni = dni;
    }
    // Getter del nom
    @Override
    public String getNom(){
        return this.nom;
    }
    // Getter del dni
    @Override
    public String getDni(){
        return this.dni;
    }

    // Setter nom
    @Override
    public void setNom(String nom){
        this.nom = nom;
    }
    // Setter DNI
    @Override
    public void setDni(String dni){
        this.dni = dni;
    }

    // Representacio en string
    public String toString(){
        return this.nom + " amb DNI: " + this.dni +". ";
    }

}
