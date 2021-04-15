package DefLlistes;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author clara
 */
public class FitxerDiscs {

    final int longExacta = 20;
    FitxerDatCansonsIn fci;
    static int contador = 0;
    File arxiu;
    RandomAccessFile f;
    final long MIDAREG = (longExacta * 2) + (longExacta * 2) + 4;

    public FitxerDiscs() {
        try {
            arxiu = new File("Disc.dat");
            f = new RandomAccessFile(arxiu, "r");
        } catch (Exception e) {

        }

    }

    //comprova si existeix un disc passat per paràmetre dins el fitxer. El recorre fins que acaba o fins que el troba i retorna un bolean
    public boolean existeixDisc(Disc disc) {
        boolean existeix = false;
        final int longExacta = 20;
        String album = "";
        String nom = "";
        int any = 0;

        try {
            arxiu = new File("Disc.dat");
            f = new RandomAccessFile(arxiu, "r");
            String discAlbum = disc.getTitolAlbum();
            String discNom = disc.getNomArtista();

            //talla els atributs del disc passat per paràmetre
            if (discAlbum.length() > longExacta) {
                discAlbum = discAlbum.substring(0, longExacta);
            }

            if (discNom.length() > longExacta) {
                discNom = discNom.substring(0, longExacta);
            }

            long numreg = f.length() / MIDAREG;
            for (int r = 0; r < numreg; r++) {
                for (int i = 0; i < longExacta; ++i) {
                    album += f.readChar();
                }
                for (int i = 0; i < longExacta; ++i) {
                    nom += f.readChar();
                }
                any = f.readInt();

                //fa la comprovació, el trim es per eliminar els espais del final
                if (album.trim().equals(discAlbum) && nom.trim().equals(discNom) && any == disc.getAny()) {
                    return true;
                } else {
                    existeix = false;
                    nom = "";
                    album = "";
                }
            }
            f.close();

        } catch (IOException e) {
        }
        return existeix;
    }

    //borra el contingut del fitxer i el deixa en blanc
    public static void borrarContingut() {
        try {
            File arxiu = new File("Disc.dat");
            RandomAccessFile f = new RandomAccessFile(arxiu, "rw");
            f.setLength(0);
            contador = 0;
            f.close();
        } catch (Exception e) {
        }
    }

    //escriu el disc passat per paràmetre al fitxer
    public void escriuDisc(Disc disc) {
        final int longExacta = 20;
        String album = disc.getTitolAlbum();
        String nom = disc.getNomArtista();

        try {
            arxiu = new File("Disc.dat");
            f = new RandomAccessFile(arxiu, "rw");

            //converteix els strings a la mida exacta
            if (album.length() < longExacta) {
                for (int i = album.length(); i < longExacta; i++) {
                    album = album + " ";
                }
            } else {
                album = album.substring(0, longExacta);
            }

            if (nom.length() < longExacta) {
                for (int i = nom.length(); i < longExacta; i++) {
                    nom = nom + " ";
                }
            } else {
                nom = nom.substring(0, longExacta);
            }

            if (f.length() != 0) {
                f.seek(MIDAREG * contador); //seria igual posar f.seek(0)
                contador++;
            }

            //escriu al fitxer i imprimex
            f.writeChars(album);
            f.writeChars(nom);
            f.writeInt(disc.getAny());
            System.out.println("Album: " + album + " Nom Artista: " + nom + " Any: " + disc.getAny());
            f.close();
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
