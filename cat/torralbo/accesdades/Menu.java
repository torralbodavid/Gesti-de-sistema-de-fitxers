package cat.torralbo.accesdades;

import java.io.File;
import java.util.Scanner;

/**
 * Creat per davidtorralbo el 21/9/17.
 */
public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Fitxers fitxers = new Fitxers();
    private GestioFitxersDAM gfm = new GestioFitxersDAM();

    public int principal(){
        int seleccio = 0;

        System.out.print("\nMENÚ\n" +
                "————————————————————————————————————————————————\n" +
                "1-Mostra per pantalla la ruta i l'arrel\n" +
                "2-Mostra per pantalla les carpetes i fitxers de l'arrel\n" +
                "3-Comprova si l'arxiu existeix i si és arxiu o directori\n" +
                "4-Crea un nou arxiu o directori\n" +
                "5-Mostra quants arxius i directoris té una ruta\n" +
                "6-Mostra característiques d'un fitxer\n" +
                "7-Mostra arxius PNG\n" +
                "8-Mostra nombre màxim carpetes+fitxers\n" +
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
                crearnouFitxer();
                subMenus(principal());
                break;
            case 5:
                fitxers.retornaNombreFitxers(fitxers.ruta);
                subMenus(principal());
                break;
            case 6:
                mostraPermisosFitxers();
                subMenus(principal());
                break;
            case 7:
                fitxers.llistarPNG();
                subMenus(principal());
                break;
            case 8:
                gfm.actualitzar();
                System.out.println("\nA l'arrel hi han " + gfm.nombreArxiusiFitxers + " arxius+directoris.");
                System.out.println("El file més llarg és: "+gfm.mesllarg);
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

    public void crearnouFitxer(){
        int seleccio = 0;
        String nom;

        try{
            System.out.print("Vols crear un arxiu (1) o un directori (2)? (3) per a tornar al menú: ");

            seleccio = Integer.parseInt(sc.nextLine());
            if(seleccio == 1 || seleccio == 2){
            System.out.print("Quin nom li vols posar al fitxer? ");
            nom = sc.nextLine();



                if(!fitxers.creaFitxeroDirectori(nom, seleccio)){
                    throw new Exception();
                } else {
                    System.out.println("El fitxer s'ha creat correctament.");
                }

            } else if(seleccio == 3){
                subMenus(principal());
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            System.out.println("Hi ha hagut un problema.");
            crearnouFitxer();
        }

    }

    public void mostraPermisosFitxers(){
        String nom;

        System.out.print("Quin és el nom del fitxer?: ");
        nom = sc.nextLine();

        fitxers.permisosFitxers(nom);
    }
}
