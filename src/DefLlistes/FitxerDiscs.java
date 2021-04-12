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

    public Disc llegeixDisc() {
        final int longExacta = 20;
        String album;
        String nom;
        int any;

        Disc disc = new Disc();

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
