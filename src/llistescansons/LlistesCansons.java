/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llistescansons;

import DefLlistes.Canso;
import DefLlistes.Disc;
import DefLlistes.FitxerCansonsIn;
import DefLlistes.FitxerCansonsOut;
import DefLlistes.FitxerDatCansonsIn;
import DefLlistes.FitxerDiscs;
import java.io.IOException;

/**
 *
 * @author clara
 */
public class LlistesCansons {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        fusiona();
        //llegeix fitxer fusionat i el mostra
        FitxerDatCansonsIn musica = new FitxerDatCansonsIn("Musica.dat");
        musica.llegirCansons();
        
        //llegir un canso, i crear un disc
        //Si el disc no existeix dins fitxerDiscs, escriure. Métode boolea que retorna true si el disc ja existeix
        //

        Canso canso = musica.llegirCanso();
        Disc newDisc = new Disc(canso.getParametres);
        
        
        //Escrius discs a Disc.Dat
        FitxerDiscs fitxercd = new FitxerDiscs();
        Disc discAux = fitxercd.llegeixDisc();
        //Disc discAux2 = fitxercd.llegeixDisc();
        while (!discAux.esCentinela()) {
            //if (!discAux2.getTitolAlbum().equals(discAux.getTitolAlbum())) {
                fitxercd.escriuDisc(discAux);
                //discAux2 = discAux;
                //discAux2 = fitxercd.llegeixDisc();
                System.out.println(discAux);
            }            
            //discAux2 = fitxercd.llegeixDisc();

        }

    }

    private static void fusiona() {
        try {
            FitxerCansonsIn fN = new FitxerCansonsIn("Nacional.txt");
            FitxerCansonsIn fA = new FitxerCansonsIn("Americana.txt");
            FitxerCansonsIn fD = new FitxerCansonsIn("Darrers.txt");
            FitxerCansonsOut fco = new FitxerCansonsOut("Musica.dat");

            Canso c1 = fN.llegeixCanso();
            Canso c2 = fA.llegeixCanso();
            Canso c3 = fD.llegeixCanso();
            Canso mesGran;

            while (!c1.esCentinela() || !c2.esCentinela() || !c3.esCentinela()) {
                if ((c1.getData().comparaData(c2.getData()) == 1 || c1.getData().comparaData(c2.getData()) == 0)) {
                    mesGran = c1;
                } else {
                    mesGran = c2;
                }
                if (c3.getData().comparaData(mesGran.getData()) == 1 || (c1.getData().comparaData(c2.getData()) == 0) && c3.getNom() != null) {
                    mesGran = c3;
                }
                fco.escriureCanso(mesGran);
                if (mesGran == c1) {
                    c1 = fN.llegeixCanso();
                }
                if (mesGran == c2) {
                    c2 = fA.llegeixCanso();
                }
                if (mesGran == c3) {
                    c3 = fD.llegeixCanso();
                }
            }
            fco.tancarFitxer();

            System.out.println("Fusió realitzada amb èxit");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
