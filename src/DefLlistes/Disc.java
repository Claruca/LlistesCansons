
package DefLlistes;

/**
 *
 * @author clara
 */
public class Disc {
    private String titolAlbum;
    private String nomArtista;
    private int any;
    
    public static final Disc CENTINELA = new Disc("ZZZ","ZZZ",000);

    public Disc() {
    }

    public Disc(String titolAlbum, String nomArtista, int any) {
        this.titolAlbum = titolAlbum;
        this.nomArtista = nomArtista;
        this.any = any;
    }

    public String getTitolAlbum() {
        return titolAlbum;
    }

    public void setTitolAlbum(String titolAlbum) {
        this.titolAlbum = titolAlbum;
    }

    

    public String getNomArtista() {
        return nomArtista;
    }

    public void setNomArtista(String nomArtista) {
        this.nomArtista = nomArtista;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

     public boolean esCentinela(){
        return titolAlbum.equals(CENTINELA.titolAlbum);
    }
     
    @Override
    public String toString() {
        return "Disc{" + "titol=" + titolAlbum + ", nomArtista=" + nomArtista + ", any=" + any + '}';
    }
    
    
    
}
