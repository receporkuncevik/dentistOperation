
package entity;

import java.util.Date;


public class Randevu {
   private int id;
   private Doktor doktor;
   private Hasta hasta;
   private Date tarihSaat;

    public Randevu() {
    }

    public Randevu(int id, Doktor doktor, Hasta hasta, Date tarihSaat) {
        this.id = id;
        this.doktor = doktor;
        this.hasta = hasta;
        this.tarihSaat = tarihSaat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doktor getDoktor() {
        if(this.doktor == null){
            this.doktor = new Doktor();
        }
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Hasta getHasta() {
         if(this.hasta == null){
            this.hasta = new Hasta();
        }
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public Date getTarihSaat() {
        return tarihSaat;
    }

    public void setTarihSaat(Date tarihSaat) {
        this.tarihSaat = tarihSaat;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Randevu other = (Randevu) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
   
   
}
