package prog2.model;

public abstract class Allotjament implements InAllotjament{

    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;

    // Constructor de Allotjament
    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa){
        this.nom = nom;
        this.id = id;
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
    }

    // Retorna el nom
    @Override
    public String getNom(){
        return this.nom;
    }

    // Assigna el valor de nom al que entra per paràmetres
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Mètode que retorna l'id
    @Override
    public String getId() {
        return this.id;
    }

    // Assigna el valor de id al que entra per paràmetres
    @Override
    public void setId(String id) {
        this.id = id;
    }
    // Mirem si estem en temporada alta o baixa a partir de l'enum que trobem a InAllotjament
    @Override
    public long getEstadaMinima(Temp temp){
        if (temp == Temp.ALTA){
            return this.estadaMinimaAlta;
        }
        else{
            return this.estadaMinimaBaixa;
        }
    }

    // Assignem el valor de l'estada minima en temporada alta i baixa al que entra per paràmetres
    @Override
    public void setEstadaMinima(long estadaMinimaAlta,long estadaMinimaBaixa){
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
    }

    // Mètode abstracte que també han de tenir els que hereten els mètodes
    // Cada subclasse ho fa seguint la seva pròpia lògica
    @Override
    public abstract boolean correcteFuncionament();

    // Retornem els valors que hem guardat en forma de string
    @Override
    public String toString() {
        return "Nom=" + this.nom + ", Id=" + this.id +
                ", estada mínima en temp ALTA: " + this.estadaMinimaAlta +
                ", estada mínima en temp BAIXA: " + this.estadaMinimaBaixa + ".";
    }
}
