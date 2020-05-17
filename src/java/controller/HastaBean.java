package controller;

import entity.Hasta;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.HastaModel;

/**
 *
 * @author RecepOrkun
 */
@Named
@SessionScoped
public class HastaBean implements Serializable {

    private HastaModel hastaModel;
    private Hasta entity;

    //CRUD
    public String create() {
        this.getHastaModel().create(entity);
        return "index";
    }

    public List<Hasta> getRead() {
        return this.getHastaModel().read();
    }

    public String updateForm(Hasta h) {
        this.entity = h;
        return "update";
    }

    public String update() {
        this.getHastaModel().update(entity);
        return "index";
    }

    public void delete(Hasta h) {
        this.getHastaModel().delete(h);
    }

    public HastaBean() {
    }

    public HastaModel getHastaModel() {
        if (this.hastaModel == null) {
            this.hastaModel = new HastaModel();
        }
        return hastaModel;
    }

    public void setHastaModel(HastaModel hastaModel) {
        this.hastaModel = hastaModel;
    }

    public Hasta getEntity() {
        if (this.entity == null) {
            this.entity = new Hasta();
        }
        return entity;
    }

    public void setEntity(Hasta entity) {
        this.entity = entity;
    }

}
