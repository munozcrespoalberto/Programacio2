package prog2.vista;
import prog2.model.Camping;
import java.util.Scanner;

public class VistaCamping {
    private Camping camping;
    private String nomCamping;

    public VistaCamping(String nomCamping) {
        this.nomCamping = nomCamping;
        this.camping = new Camping(nomCamping);
        this.camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() {
        Scanner sc = new Scanner(System.in);

        // Enum amb els noms interns de cada opció
        enum OpcionsMenu {
            LLISTAR_TOTS, LLISTAR_OPERATIUS, LLISTAR_NO_OPERATIUS,
            LLISTAR_ACCESSOS_OBERTS, LLISTAR_ACCESSOS_TANCATS,
            LLISTAR_TASQUES, AFEGIR_TASCA, COMPLETAR_TASCA,
            CALCULAR_ACCESSOS, CALCULAR_METRES,
            GUARDAR, CARREGAR, SORTIR
        }

        // Text que veu l'usuari per cada opció
        String[] descripcions = {
                "Llistar tots els allotjaments",
                "Llistar allotjaments operatius",
                "Llistar allotjaments no operatius",
                "Llistar accessos oberts",
                "Llistar accessos tancats",
                "Llistar tasques de manteniment actives",
                "Afegir una tasca de manteniment",
                "Completar una tasca de manteniment",
                "Calcular accessos sense accessibilitat amb vehicle",
                "Calcular metres totals d'accessos de terra",
                "Guardar càmping",
                "Carregar càmping",
                "Sortir"
        };

        Menu<OpcionsMenu> menu = new Menu<>("Càmping " + nomCamping, OpcionsMenu.values()); // Creem un objecte menu amb totes les opcions
        menu.setDescripcions(descripcions); // Li posem les descripcions de cada opcio
        OpcionsMenu opcio = null; // L'inicialitzo per poder fer el do while sense problemes
        do {
            menu.mostrarMenu(); //Mostrem menu
            opcio = menu.getOpcio(sc); // Agafem l'opcio de l'usuari com a tipus de l'enum

            switch (opcio) { // Que fem segons l'opcio ecollida
                case LLISTAR_TOTS:
                    try {
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case LLISTAR_OPERATIUS:
                    try{
                        System.out.println(camping.llistarAllotjaments("Operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case LLISTAR_NO_OPERATIUS:
                    try{
                        System.out.println(camping.llistarAllotjaments("No operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ACCESSOS_OBERTS:
                    try{
                        System.out.println(camping.llistarAccessos("Obert"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ACCESSOS_TANCATS   :
                    try{
                        System.out.println(camping.llistarAccessos("Tancat"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_TASQUES  :
                    try{
                        System.out.println(camping.llistarTasquesManteniment());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case AFEGIR_TASCA:
                    try{
                        System.out.print("Número de la tasca: ");
                        int num = sc.nextInt(); sc.nextLine(); // \n de c++
                        System.out.print("ID de l'allotjament: ");
                        String id = sc.nextLine();
                        System.out.print("Tipus de la tasca (Reparacio/Neteja/RevisioTecnica/Desinfeccio): ");
                        String tipus = sc.nextLine();
                        System.out.print("Data: ");
                        String data = sc.nextLine();
                        System.out.print("Dies esperats: ");
                        int dies = sc.nextInt(); sc.nextLine();
                        camping.afegirTascaManteniment(num, tipus, id, data, dies);
                        System.out.println("Tasca afegida correctament. ");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case COMPLETAR_TASCA:
                    try{
                        System.out.println(camping.llistarTasquesManteniment()); // Imprimim totes les tasques actives
                        System.out.println("Número de la tasca a completar: ");
                        int num = sc.nextInt(); sc.nextLine();
                        camping.completarTascaManteniment(num);
                        System.out.println("Tasca completada correctament. ");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case CALCULAR_ACCESSOS: // No fa falta try catch, el try catch es fa en el propi metode a camping
                    System.out.println("Accesos no accesibles: " + camping.calculaAccessosNoAccessibles());
                    break;
                case CALCULAR_METRES: // No fa falta try catch, el try catch es fa en el propi metode a camping
                    System.out.println("Metres de terra: " + camping.calculaMetresTerra());
                    break;
                case GUARDAR:
                    try{
                        System.out.println("A on vols guardar l'arxiu amb totes les dades de camping? ");
                        String camiArxiu = sc.nextLine();
                        camping.save(camiArxiu); // Guardem les dades del nostre camping dins d'un arxiu
                        System.out.println("Arxiu guardat correctament. ");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case CARREGAR:
                    try {
                        System.out.print("Ruta del fitxer: ");
                        String camiCarregar = sc.nextLine();
                        camping = Camping.load(camiCarregar); // Canviem el camping actual pel carregat de l'arxiu
                        System.out.println("Càmping carregat correctament.");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case SORTIR:
                    System.out.println("Sortint del programa...");
                    break;
            }
        } while (opcio != OpcionsMenu.SORTIR);
    }
}
