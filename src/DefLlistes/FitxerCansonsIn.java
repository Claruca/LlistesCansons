package DefLlistes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author clara
 */
public class FitxerCansonsIn {

    private FileReader f;
    private BufferedReader br;

    public FitxerCansonsIn(String fitxer) {
        try {
            f = new FileReader(fitxer);
            br = new BufferedReader(f);
        } catch (FileNotFoundException e) {
        }
    }

    public void llegirFitxer() {
        try {
            Canso c = llegeixCanso();
            while (c.getNom() != null) {
                System.out.println(c);
                c = llegeixCanso();
            }

        } catch (Exception ex) {
            System.out.println("ERROR en E/S: " + ex.getMessage());
        }

    }

    public void mostraFitxer() {
        try {
            Canso c = llegeixCanso();
            while (c.getNom() != null) {
                System.out.println(c);
                c = llegeixCanso();
            }

        } catch (Exception ex) {
            System.out.println("ERROR en E/S: " + ex.getMessage());
        }

    }

    public Canso llegeixCanso() {
        Canso canso = new Canso();
        try {
            String primeraLinea;
            if ((primeraLinea = br.readLine()) != null) {
                String titol = primeraLinea;
                String nom = br.readLine();
                String album = br.readLine();
                String genere = br.readLine();
                int any = Integer.valueOf(br.readLine());
                int diai = 0;
                int mesi = 0;
                int anyi = 0;
                int horai = 0;
                int minuti = 0;

                String dataT = br.readLine();
                String[] values = dataT.split("/");
                diai = Integer.parseInt(values[0]);
                mesi = Integer.parseInt(values[1]);
                String auxi = values[2].substring(0, 2);
                anyi = Integer.parseInt(auxi);

                String horaT = values[2];
                String[] separar = horaT.split(":");

                String auxi2 = separar[0].substring(3);
                horai = Integer.parseInt(auxi2);
                minuti = Integer.parseInt(separar[1]);
                Data data = new Data(diai, mesi, anyi, horai, minuti);
                canso = new Canso(titol, nom, album, genere, any, data);

            } else {
                canso = Canso.CENTINELA;
            }

        } catch (IOException ex) {
            System.out.println("ERROR en E/S: " + ex.getMessage());
        }
        return canso;
    }

    public void tancarFitxer() {
        try {
            br.close();
            f.close();
        } catch (IOException ex) {
            System.out.println("ERROR en E/S: " + ex.getMessage());
        }
    }

}
