package controller;

import entity.Doktor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.DoktorModel;

/**
 *
 * @author RecepOrkun
 */
@Named
@SessionScoped
public class DoktorBean implements Serializable {

    private DoktorModel doktorModel;
    private Doktor entity;

    //CRUD
    public String create() {
        this.getDoktorModel().create(entity);
        return "index";
    }

    public List<Doktor> getRead() {
        return this.getDoktorModel().read();
    }

    public String updateForm(Doktor d) {
        this.entity = d;
        return "update";
    }

    public String update() {
        this.getDoktorModel().update(entity);
        return "index";
    }

    public void delete(Doktor d) {
        this.getDoktorModel().delete(d);
    }

    public DoktorBean() {
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

}
