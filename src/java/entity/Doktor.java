package entity;

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
    
    

}
