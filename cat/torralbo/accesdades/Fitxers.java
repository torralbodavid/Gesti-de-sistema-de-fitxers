package cat.torralbo.accesdades;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Scanner;

public class Fitxers {

    private Scanner sc = new Scanner(System.in);
    public static File arrel = File.listRoots()[0];
    public static File ruta = new File(arrel+File.separator+"Users"+File.separator+File.separator+"davidtorralbo"+File.separator+"davidtorralbo_dam2");

    public static void mostraRutes(){
        System.out.println("Aquestes són les rutes:");
        System.out.println(ruta);
        System.out.println(arrel);
    }

    public static void retornaValorRuta(File ruta){
        File[] llista = ruta.listFiles();

        for (int i = 0; i < llista.length; i++) {
            if (llista[i].isFile()) {
                System.out.println("Arxiu: " + llista[i].getName());
            } else if (llista[i].isDirectory()) {
                System.out.println("Directori: " + llista[i].getName());
            }
        }
    }

    public static void comprovaFitxeroDirectori(File fitxer){

        try {
            if (fitxer.exists()) {
                System.out.println("\nL'objecte existeix");

                if (fitxer.isDirectory()) {
                    System.out.println("L'objecte és un directori");
                } else if(fitxer.isFile()){
                    System.out.println("L'objecte és un fitxer");
                }

            } else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("L'objecte no existeix");
        }

    }

    public static boolean creaFitxeroDirectori(String nom, int tipus){
        boolean creat;

        File arxiu = new File(ruta+File.separator+nom);

        switch (tipus){

            case 1:
                try {
                    if(!arxiu.exists()) {
                        arxiu.createNewFile();
                        creat = true;
                    } else {
                        throw new IOException();
                    }
                } catch (IOException e) {
                    creat = false;
                }
                break;

            case 2:
                try {
                    if(!arxiu.exists()) {
                        arxiu.mkdir();
                        creat = true;
                    } else {
                        throw new IOException();
                    }
                } catch (IOException e) {
                    creat = false;
                }
                break;

            default:
                creat = false;
                break;
        }

        return creat;

    }

    public static void retornaNombreFitxers(File ruta){
        File[] llista = ruta.listFiles();

        int j = 0, k = 0;

        for (int i = 0; i < llista.length; i++) {
            if (llista[i].isFile()) {
                j++;
            } else if (llista[i].isDirectory()) {
                k++;
            }
        }

        System.out.println("La ruta conté "+j+" arxius i "+k+" directoris");
    }

    public static void permisosFitxers(String nomFitxer){
        File arxiu = new File(ruta + File.separator + nomFitxer);
        if(arxiu.exists()){
            System.out.println("\nCARACTERÍSTIQUES\n" +
                    "###############\n");

            if(arxiu.canRead()){
                System.out.println("- Permisos lectura? Sí");
            } else {
                System.out.println("- Permisos lectura? No");
            }

            if(arxiu.canWrite()){
                System.out.println("- Permisos escriptura? Sí");
            } else {
                System.out.println("- Permisos escriptura? No");
            }

            if(arxiu.canExecute()){
                System.out.println("- Permisos d'execució? Sí");
            } else {
                System.out.println("- Permisos d'execució? No");
            }

            if(arxiu.isHidden()){
                System.out.println("- És un arxiu ocult? Sí");
            } else {
                System.out.println("- És un arxiu ocult? No");
            }

            if(arxiu.isFile()){
                System.out.println("- És un arxiu? Sí");
            } else {
                System.out.println("- És un arxiu? No");
            }

            if(arxiu.isDirectory()){
                System.out.println("- És un directori? Sí");
            } else {
                System.out.println("- És un directori? No");
            }

        }

    }

    public static void llistarPNG(){

        for(File f : ruta.listFiles()){

            String fileName = f.getName();
            String fileExtension = fileName.substring(fileName.indexOf(".") + 1, f.getName().length());

            fileExtension = fileExtension.toLowerCase();

            if(fileExtension.equals("png")){
                System.out.println(f.getName());
            }
        }

    }



}
