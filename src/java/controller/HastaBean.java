package controller;

import entity.Hasta;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.HastaModel;


@Named
@SessionScoped
public class HastaBean implements Serializable {

    private HastaModel hastaModel;
    private Hasta entity;

    
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
        this.getHastaModel().create(entity);
        return "index";
    }

    public List<Hasta> getRead() {
        int start = (page-1)* this.pageSize;
        return this.getHastaModel().read(start,this.pageSize);
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
        this.pageCount = (int) Math.ceil( this.getHastaModel().count() / (double) this.pageSize);
        return this.pageCount;
    }
    
     public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
