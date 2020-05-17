
package entity;


public class Hasta {
    private int id;
    private String adi;
    private String soyadi;
    private String telefon;
    private String tckimlikno;

    public Hasta() {
    }

    public Hasta(int id, String adi, String soyadi, String telefon, String tckimlikno) {
        this.id = id;
        this.adi = adi;
        this.soyadi = soyadi;
        this.telefon = telefon;
        this.tckimlikno = tckimlikno;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTckimlikno() {
        return tckimlikno;
    }

    public void setTckimlikno(String tckimlikno) {
        this.tckimlikno = tckimlikno;
    }
    
    
    
    
}
