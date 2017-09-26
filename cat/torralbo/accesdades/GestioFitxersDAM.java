package cat.torralbo.accesdades;

import java.io.File;

/**
 * Creat per davidtorralbo el 25/9/17.
 */
public class GestioFitxersDAM {

    public static File arrel = File.listRoots()[0];
    public static File mesllarg = new File("");
    public static int nombreArxiusiFitxers = 0;

    public static void actualitzar() {

        long llargada = 0;

        for ( File f : arrel.listFiles()) {

            if(f.length()>=llargada){
                llargada=f.length();
                mesllarg = new File(arrel+File.separator+f.getName());

            }

            nombreArxiusiFitxers++;
        }

    }

}
