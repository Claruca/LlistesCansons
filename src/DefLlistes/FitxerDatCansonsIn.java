package DefLlistes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author clara
 */
public class FitxerDatCansonsIn {

    FileInputStream entrada;
    ObjectInputStream ois;

    public FitxerDatCansonsIn(String nom) {
        try {
            entrada = new FileInputStream(nom);
            ois = new ObjectInputStream(entrada);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Canso llegirCanso() {
        Canso canso = new Canso();
        try {
            canso = (Canso) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return canso;
    }

    public void llegirCansons() {
        try {
            Canso canso = (Canso) ois.readObject();
            while (!canso.esCentinela()) {
                System.out.println(canso);
                canso = (Canso) ois.readObject();
            }
            ois.close();
            System.out.println("Final de fitxer");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tancarFitxer() {
        try {
            ois.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
