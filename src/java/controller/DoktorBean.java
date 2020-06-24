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

    public DoktorBean() {
    }

    public String create() {
        this.getDoktorModel().create(entity);
        return "index";
    }

    public List<Doktor> getRead() {
        int start = (page-1)* this.pageSize;
        return this.getDoktorModel().read(start,this.pageSize);
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

    public String doktorHasta() {
        this.getDoktorModel().hastaEkle(entity);
        return "index";
    }

    public String updateHasta(Doktor d) {
        this.entity = d;
        return "doktorHastaGuncelle";
    }

    public void doktorHastasiDelete(Doktor d) {
        this.getDoktorModel().doktorHastasiSil(d);
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
        this.pageCount = (int) Math.ceil(this.getDoktorModel().count() / (double) this.pageSize);
        return this.pageCount;
    }
    
     public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    
    
}
