
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
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
        final Tedavi other = (Tedavi) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
