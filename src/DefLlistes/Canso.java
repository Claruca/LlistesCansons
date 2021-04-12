package DefLlistes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author clara
 */
public class Canso implements Serializable {

    private String titol;
    private String nom;
    private String album;
    private String genere;
    private int any;
    private Data data;
   
    public static final Canso CENTINELA = new Canso("zzz","zzz","zzz","zzz",00,Data.DATACENTINELLA);   

    public Canso() {
    }
       
   

    public Canso(String titol, String nom, String album, String genere, int any, Data data) {
        this.titol = titol;
        this.nom = nom;
        this.album = album;
        this.genere = genere;
        this.any = any;
        this.data = data;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    
     public boolean esCentinela(){
        return titol.equals(CENTINELA.titol);
    }
        

    @Override
    public String toString() {
        return "Canso{" + "titol=" + titol + ", nom=" + nom + ", album=" + album + ", genere=" + genere + ", any=" + any + ", data=" + data + '}';
    }

}
