package controller;

import entity.Doktor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.DoktorModel;
import model.HastaModel;
import model.MuayeneModel;
import model.RandevuModel;

/**
 *
 * @author RecepOrkun
 */
@Named
@SessionScoped
public class HomeBean implements Serializable {

    private DoktorModel doktorModel;
    private HastaModel hastaModel;
    private RandevuModel randevuModel;
    private MuayeneModel muayeneModel;
    
    private Doktor entity;
    

    public HomeBean() {
    }


    public DoktorModel getDoktorModel() {
        if (this.doktorModel == null) {
            this.doktorModel = new DoktorModel();
        }
        return doktorModel;
    }

    public void setDoktorModel(DoktorModel doktorModel) {
        this.doktorModel = doktorModel;
    }

    public Doktor getEntity() {
        if (this.entity == null) {
            this.entity = new Doktor();
        }
        return entity;
    }

    public void setEntity(Doktor entity) {
        this.entity = entity;
    }

    public HastaModel getHastaModel() {
        if(this.hastaModel == null){
            this.hastaModel = new HastaModel();
        }
        return hastaModel;
    }

    public void setHastaModel(HastaModel hastaModel) {
        this.hastaModel = hastaModel;
    }

    public RandevuModel getRandevuModel() {
        if(this.randevuModel == null){
            this.randevuModel = new RandevuModel();
        }
        return randevuModel;
    }

    public void setRandevuModel(RandevuModel randevuModel) {
        this.randevuModel = randevuModel;
    }

    public MuayeneModel getMuayeneModel() {
         if(this.muayeneModel == null){
            this.muayeneModel = new MuayeneModel();
        }
        return muayeneModel;
    }

    public void setMuayeneModel(MuayeneModel muayeneModel) {
        this.muayeneModel = muayeneModel;
    }
    
    
    
    
    
    
}
