package prog2.model;

public abstract class Allotjament implements InAllotjament{

    private String nom;
    private String id;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;

    // Nous atributs de allotjament
    private boolean operatiu;
    private String iluminacio;

    // Constructor de Allotjament
    public Allotjament(String nom, String id, long estadaMinimaAlta, long estadaMinimaBaixa){
        this.nom = nom;
        this.id = id;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.operatiu = true;
        this.iluminacio = "100%";
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

    // Setter de operatiu. Ho posem en protected per a que les classes filles hi puguin accedir, però no es pugui fer desde l'exterior
    protected void setOperatiu(boolean operatiu) { this.operatiu = operatiu; }
    // Getter de operatiu
    public boolean isOperatiu(){
        return operatiu;
    }
    // Setter de iluminacio. Ho posem en protected per a que les classes filles hi puguin accedir, però no es pugui fer desde l'exterior
    protected void setIluminacio(String iluminacio){
        this.iluminacio = iluminacio;
    }
    // Getter de Iluminacio
    public String getIluminacio(){
        return iluminacio;
    }

    @Override
    public void tancarAllotjament(TascaManteniment tasca){
        // Deixa d'estar operatiu
        this.operatiu = false;
        // Iluminacio depen del tipus de tasca
        this.iluminacio = tasca.getIluminacioAllotjament();
    }
    @Override
    public void obrirAllotjament(){
        // Torna a estar operatiu
        this.operatiu = true;
        // Torna la iluminacio al 100%
        this.iluminacio = "100%";
    }

    // Retornem els valors que hem guardat en forma de string
    @Override
    public String toString() {
        return "Nom=" + this.nom + ", Id=" + this.id +
                ", estada mínima en temp ALTA: " + this.estadaMinimaAlta +
                ", estada mínima en temp BAIXA: " + this.estadaMinimaBaixa +
                // Afegim operatiu i iluminacio al toString
                // Si operatiu es true donarà "Sí", en cas contrari serà "No"
                ", Operatiu: " + (this.operatiu ? "Sí" : "No") +
                ", Iluminacio: " + this.iluminacio + ".";

    }
}
