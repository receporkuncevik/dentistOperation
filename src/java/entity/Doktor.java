package entity;

import java.util.List;

/**
 *
 * @author RecepOrkun
 */
public class Doktor {

    private int id;
    private String adi;
    private String soyadi;
    private String ihtisas;
    private String telefon;
    private Hasta hasta;
    
    private List<Hasta> doktorHastalari;

    public Doktor() {
    }

    public Doktor(int id, String adi, String soyadi, String ihtisas, String telefon) {
        this.id = id;
        this.adi = adi;
        this.soyadi = soyadi;
        this.ihtisas = ihtisas;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }
    
    public String getAdiSoyadi(){
        return this.adi + " " + this.soyadi; 
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getIhtisas() {
        return ihtisas;
    }

    public void setIhtisas(String ihtisas) {
        this.ihtisas = ihtisas;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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

    public List<Hasta> getDoktorHastalari() {
        return doktorHastalari;
    }

    public void setDoktorHastalari(List<Hasta> doktorHastalari) {
        this.doktorHastalari = doktorHastalari;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
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
        final Doktor other = (Doktor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

}
