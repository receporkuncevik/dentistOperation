
package entity;

public class Envanter {
    private int id;
    private String aciklama;
    private int adet;

    public Envanter() {
    }

    public Envanter(int id, String aciklama, int adet) {
        this.id = id;
        this.aciklama = aciklama;
        this.adet = adet;
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

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Envanter other = (Envanter) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
