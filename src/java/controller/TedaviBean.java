package controller;

import entity.Tedavi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.TedaviModel;


@Named
@SessionScoped
public class TedaviBean implements Serializable {

    private TedaviModel tedaviModel;
    private Tedavi entity;
    
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
        this.getTedaviModel().create(entity);
        return "index";
    }

    public List<Tedavi> getRead() {
        int start = (page-1)* this.pageSize;
        return this.getTedaviModel().read(start,this.pageSize);
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
        this.pageCount = (int) Math.ceil( this.getTedaviModel().count() / (double) this.pageSize);
        return this.pageCount;
    }
    
     public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


}
