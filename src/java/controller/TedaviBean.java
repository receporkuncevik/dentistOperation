package controller;

import entity.Tedavi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.TedaviModel;

/**
 *
 * @author RecepOrkun
 */
@Named
@SessionScoped
public class TedaviBean implements Serializable {

    private TedaviModel tedaviModel;
    private Tedavi entity;

    //CRUD
    public String create() {
        this.getTedaviModel().create(entity);
        return "index";
    }

    public List<Tedavi> getRead() {
        return this.getTedaviModel().read();
    }

    public String updateForm(Tedavi t) {
        this.entity = t;
        return "update";
    }

    public String update() {
        this.getTedaviModel().update(entity);
        return "index";
    }

    public void delete(Tedavi t) {
        this.getTedaviModel().delete(t);
    }

    public TedaviBean() {
    }

    public TedaviModel getTedaviModel() {
        if (this.tedaviModel == null) {
            this.tedaviModel = new TedaviModel();
        }
        return tedaviModel;
    }

    public void setTedaviModel(TedaviModel tedaviModel) {
        this.tedaviModel = tedaviModel;
    }

    public Tedavi getEntity() {
        if (this.entity == null) {
            this.entity = new Tedavi();
        }
        return entity;
    }

    public void setEntity(Tedavi entity) {
        this.entity = entity;
    }

}
