package controller;

import entity.Envanter;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.EnvanterModel;


@Named
@SessionScoped
public class EnvanterBean implements Serializable {

    private EnvanterModel envanterModel;
    private Envanter entity;
    
    private int pageCount;
    private int page = 1;
    private int pageSize = 10;

    
    public void nextPage() {
        if (this.getPageCount() == this.page)
            this.page = 1;
        else 
            
            this.page++;
    }
    
    public void previousPage() {
        if (this.page == 1)
            this.page = this.getPageCount();
        else 
            this.page--;
    }

    //CRUD
    public String create() {
        this.getEnvanterModel().create(entity);
        return "index";
    }

    public List<Envanter> getRead() {
        int start = (page-1)* this.pageSize;
        return this.getEnvanterModel().read(start,this.pageSize);
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
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
     public int getPageCount() {
        this.pageCount = (int) Math.ceil( this.getEnvanterModel().count() / (double) this.pageSize);
        return this.pageCount;
    }
    
     public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
