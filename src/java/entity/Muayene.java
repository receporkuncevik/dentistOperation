package entity;

public class Muayene {

    private int id;
    private Doktor doktor;
    private Hasta hasta;
    private Randevu randevu;
    private Tedavi tedavi;
    private Envanter envanter;

    public Muayene() {
    }

    public Muayene(int id, Doktor doktor, Hasta hasta, Randevu randevu) {
        this.id = id;
        this.doktor = doktor;
        this.hasta = hasta;
        this.randevu = randevu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doktor getDoktor() {
         if(this.doktor==null)
            this.doktor=new Doktor();
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Hasta getHasta() {
           if(this.hasta==null)
            this.hasta=new Hasta();
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public Randevu getRandevu() {
        if(this.randevu==null)
            this.randevu=new Randevu();
        return randevu;
    }

    public void setRandevu(Randevu randevu) {
        this.randevu = randevu;
    }

    public Tedavi getTedavi() {
        if(this.tedavi == null){
            this.tedavi = new Tedavi();
        }
        return tedavi;
    }

    public void setTedavi(Tedavi tedavi) {
        this.tedavi = tedavi;
    }

    public Envanter getEnvanter() {
        if(this.envanter == null){
            this.envanter = new Envanter();
        }
        return envanter;
    }

    public void setEnvanter(Envanter envanter) {
        this.envanter = envanter;
    }
    
    

    
}
