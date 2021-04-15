/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DefLlistes;

import java.io.Serializable;

/**
 *
 * @author clara
 */
public class Data implements Serializable {

    private int dia;
    private int mes;
    private int any;
    private int hora;
    private int minut;
    
    public static final Data DATACENTINELLA = new Data(0,0,0,0,0);

    public Data(int dia, int mes, int any, int hora, int minut) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
        this.hora = hora;
        this.minut = minut;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinut() {
        return minut;
    }

    public void setMinut(int minut) {
        this.minut = minut;
    }

    //compara dos numeros: retorne 1 si el primer es més gran
        //retorn -1 si el segon es més gran
        //retorna 0 si son iguals
    private int comparar(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        }
        if (num1 < num2) {
            return -1;
        }
        return 0;
    }

    //compara les dates, en cas que hi hagi dues dates iguals, retorna 0
    public int comparaData(Data data) {
        int resultat = comparar(this.any, data.any);
        if (resultat != 0) {
            return resultat;
        }
        resultat = comparar(this.mes, data.mes);
        if (resultat != 0) {
            return resultat;
        }
        resultat = comparar(this.dia, data.dia);
        if (resultat != 0) {
            return resultat;
        }
        resultat = comparar(this.hora, data.hora);
        if (resultat != 0) {
            return resultat;
        }
        resultat = comparar(this.minut, data.minut);
        if (resultat != 0) {
            return resultat;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Data{" + dia + "/" + mes + "/" + any + " " + hora + ":" + minut + '}';
    }

}
