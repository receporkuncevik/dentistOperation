
package entity;


public class Kullanici {
    int id;
    String kullaniciAdi;
    String sifre;

    public Kullanici() {
    }

    public Kullanici(int id, String kullaniciAdi, String sifre) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    
}
