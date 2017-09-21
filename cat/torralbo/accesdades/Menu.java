package cat.torralbo.accesdades;

import java.util.Scanner;

/**
 * Creat per davidtorralbo el 21/9/17.
 */
public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Fitxers fitxers = new Fitxers();

    public int principal(){
        int seleccio = 0;

        System.out.print("\nMENÚ\n" +
                "————————————————————————————————————————————————\n" +
                "1-Mostra per pantalla la ruta i l'arrel\n" +
                "2-Mostra per pantalla les carpetes i fitxers de l'arrel\n" +
                "3-Comprova si l'arxiu existeix i si és arxiu o directori\n" +
                "4-Crea un nou arxiu o directori\n" +
                "\n0-Sortir" +
                "\n————————————————————————————————————————————————\n\n" +
                "Selecció: ");
        try {
            seleccio = Integer.parseInt(sc.nextLine());
        }catch (Exception e){
            System.out.println("Hi ha hagut un problema, seleccioni un nombre.\n");
            subMenus(principal());
        }

        return seleccio;

    }

    public void subMenus(int seleccio){

        switch(seleccio){
            case 1:
                fitxers.mostraRutes();
                subMenus(principal());
                break;
            case 2:
                fitxers.retornaValorRuta(fitxers.arrel);
                subMenus(principal());
                break;
            case 3:
                fitxers.comprovaFitxeroDirectori(fitxers.ruta);
                subMenus(principal());
                break;
            case 4:
                System.out.println(fitxers.creaFitxeroDirectori("provess", 1));
                subMenus(principal());
                break;
            case 0:
                System.out.println("Gràcies per utilitzar el programa!");
                System.exit(0);
                subMenus(principal());
                break;
            default:
                System.out.println("Error! Ha de seleccionar un nombre del menú.\n");
                subMenus(principal());
                break;
        }
    }
}
