package cat.torralbo.accesdades;
import java.io.File;
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

}
