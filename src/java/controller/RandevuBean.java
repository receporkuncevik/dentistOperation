package controller;

import entity.Randevu;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.RandevuModel;


@Named
@SessionScoped
public class RandevuBean implements Serializable {

    private RandevuModel randevuModel;
    private Randevu entity;
    
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
        this.getRandevuModel().create(entity);
        return "index";
    }

    public List<Randevu> getRead() {
        int start = (page-1)* this.pageSize;
        return this.getRandevuModel().read(start,this.pageSize);
    }

    public String updateForm(Randevu t) {
        this.entity = t;
        return "update";
    }

    public String update() {
        this.getRandevuModel().update(entity);
        return "index";
    }

    public void delete(Randevu t) {
        this.getRandevuModel().delete(t);
    }

    public RandevuBean() {
    }

    public RandevuModel getRandevuModel() {
        if (this.randevuModel == null) {
            this.randevuModel = new RandevuModel();
        }
        return randevuModel;
    }

    public void setRandevuModel(RandevuModel randevuModel) {
        this.randevuModel = randevuModel;
    }

    public Randevu getEntity() {
        if (this.entity == null) {
            this.entity = new Randevu();
        }
        return entity;
    }

    public void setEntity(Randevu entity) {
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
        this.pageCount = (int) Math.ceil( this.getRandevuModel().count() / (double) this.pageSize);
        return this.pageCount;
    }
    
     public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
