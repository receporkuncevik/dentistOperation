
package entity;


public class Tedavi {
    private int id;
    private String aciklama;

    public Tedavi() {
    }
    
    public Tedavi(int id, String aciklama) {
        this.id = id;
        this.aciklama = aciklama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
    
}
