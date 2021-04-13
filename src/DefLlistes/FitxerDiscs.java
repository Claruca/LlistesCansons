package DefLlistes;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author clara
 */
public class FitxerDiscs {

    public File arxiu;
    public RandomAccessFile f;
    final int longExacta = 20;
    final long MIDAREG = (longExacta * 2) ^ 2 + 4;
    FitxerDatCansonsIn fci;

    public FitxerDiscs() {
        fci = new FitxerDatCansonsIn("Musica.dat");

    }
    //enlloc de Musica.dat ha de llegir fitxer discs.dat, per sabre si ja hi es o no

    public Disc llegeixDisc() {
        final int longExacta = 20;
        String album;
        String nom;
        int any;

        Disc disc = new Disc();
        
        //NO CREAR DISC EN AQUEST METODE, crear disc al principal a partir de llegir canso
        //aquest metode ha de recorrer el fitxer de discs i despres a un metode apart mirar si existeix o no un disc concret

        album = fci.llegirCanso().getAlbum();
        nom = fci.llegirCanso().getNom();

        if (album.length() < longExacta) {
            for (int i = album.length(); i < longExacta; i++) {
                album = album + " ";
            }
        } else {
            album = album.substring(0, longExacta - 1);
        }

        if (nom.length() < longExacta) {
            for (int i = nom.length(); i < longExacta; i++) {
                nom = nom + " ";
            }
        } else {
            nom = nom.substring(0, longExacta - 1);
        }

        any = fci.llegirCanso().getAny();

        disc.setTitolAlbum(album);
        disc.setNomArtista(nom);
        disc.setAny(any);
        return disc;
    }

    public void escriuDisc(Disc disc) {
        try {
            arxiu = new File("Disc.dat");
            f = new RandomAccessFile(arxiu, "rw");
            
            if (f.length() != 0) {
                f.seek(f.length());
            }

            f.writeChars(disc.getTitolAlbum());
            f.writeChars(disc.getNomArtista());
            f.writeInt(disc.getAny());
            f.close();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    //arxiu = new File("Musica.dat");
    //f= new RandomAccessFile(arxiu,"rw");
}
