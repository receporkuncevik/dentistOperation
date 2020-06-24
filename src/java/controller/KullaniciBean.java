package controller;

import entity.Kullanici;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.KullaniciModel;

@Named
@SessionScoped
public class KullaniciBean implements Serializable {

    private KullaniciModel kullaniciModel;
    private Kullanici entity;
    
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
        this.getKullaniciModel().create(entity);
        return "index";
    }

    public List<Kullanici> getRead() {
        int start = (page-1)* this.pageSize;
        return this.getKullaniciModel().read(start,this.pageSize);
    }

    public String updateForm(Kullanici t) {
        this.entity = t;
        return "update";
    }

    public String update() {
        this.getKullaniciModel().update(entity);
        return "index";
    }

    public void delete(Kullanici t) {
        this.getKullaniciModel().delete(t);
    }

    public KullaniciBean() {
    }

    public KullaniciModel getKullaniciModel() {
        if (this.kullaniciModel == null) {
            this.kullaniciModel = new KullaniciModel();
        }
        return kullaniciModel;
    }

    public void setKullaniciModel(KullaniciModel kullaniciModel) {
        this.kullaniciModel = kullaniciModel;
    }

    public Kullanici getEntity() {
        if (this.entity == null) {
            this.entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
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
        this.pageCount = (int) Math.ceil( this.getKullaniciModel().count() / (double) this.pageSize);
        return this.pageCount;
    }
    
     public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
