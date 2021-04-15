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

    //llegeix tot el fitxer fins que no arribi al centinela
    public void llegirFitxer() {
        try {
            Canso c = llegeixCanso();
            while (!c.esCentinela()) {
                System.out.println(c);
                c = llegeixCanso();
            }

        } catch (Exception ex) {
            System.out.println("ERROR en E/S: " + ex.getMessage());
        }

    }
    

    //llegeix una canso linea a linea amb el bufferedReader
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
                
                //variables auxiliars per llegir la data
                int diai, mesi,anyi,horai,minuti;                

                //primer llegeix la linea de data
                String dataT = br.readLine();
                //separa en array d'strings a través de una barra
                String[] values = dataT.split("/");
                //la primera part es el dia, el primer valor de l'array
                diai = Integer.parseInt(values[0]);
                //el segon es el mes
                mesi = Integer.parseInt(values[1]);
                //el tercer, com que també conté un espai i l'hora completa, el tall amb substring
                String auxi = values[2].substring(0, 2);                
                anyi = Integer.parseInt(auxi);

                String horaT = values[2];
                //el que queda ho torn a separar per dos punt i afegirho a una array
                String[] separar = horaT.split(":");
                //agaf el valor de l'hora mes els :
                String auxi2 = separar[0].substring(3);
                //convertesc a int
                horai = Integer.parseInt(auxi2);
                minuti = Integer.parseInt(separar[1]);
                //crei objecte data amb aquestes variables
                Data data = new Data(diai, mesi, anyi, horai, minuti);
                //crei canso
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
