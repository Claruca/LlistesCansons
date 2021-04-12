package DefLlistes;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author clara
 */
public class FitxerCansonsOut {

    FileOutputStream sortida;
    ObjectOutputStream oos;

    public FitxerCansonsOut(String nom) {
        try {
            sortida = new FileOutputStream(nom);
            oos = new ObjectOutputStream(sortida);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void escriureCanso(Canso c) {
        try {
            oos.writeObject(c);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void tancarFitxer() {
        try {
            escriureCanso(Canso.CENTINELA);
            oos.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
