package controller;

import entity.Envanter;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.EnvanterModel;

/**
 *
 * @author RecepOrkun
 */
@Named
@SessionScoped
public class EnvanterBean implements Serializable {

    private EnvanterModel envanterModel;
    private Envanter entity;

    //CRUD
    public String create() {
        this.getEnvanterModel().create(entity);
        return "index";
    }

    public List<Envanter> getRead() {
        return this.getEnvanterModel().read();
    }

    public String updateForm(Envanter e) {
        this.entity = e;
        return "update";
    }

    public String update() {
        this.getEnvanterModel().update(entity);
        return "index";
    }

    public void delete(Envanter e) {
        this.getEnvanterModel().delete(e);
    }

    public EnvanterBean() {
    }

    public EnvanterModel getEnvanterModel() {
        if (this.envanterModel == null) {
            this.envanterModel = new EnvanterModel();
        }
        return envanterModel;
    }

    public void setEnvanterModel(EnvanterModel envanterModel) {
        this.envanterModel = envanterModel;
    }

    public Envanter getEntity() {
        if (this.entity == null) {
            this.entity = new Envanter();
        }
        return entity;
    }

    public void setEntity(Envanter entity) {
        this.entity = entity;
    }

}
