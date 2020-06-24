package controller;

import entity.Muayene;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.MuayeneModel;

/**
 *
 * @author RecepOrkun
 */
@Named
@SessionScoped
public class MuayeneBean implements Serializable {

    private MuayeneModel muayeneModel;
    private Muayene entity;

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

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getMuayeneModel().count() / (double) this.pageSize);
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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
    
    
    //CRUD
    public String create() {
        this.getMuayeneModel().create(entity);
        return "index";
    }

    public List<Muayene> getRead() {
        int start = (page-1)* pageSize;
        return this.getMuayeneModel().read(start, this.pageSize);
    }

    public String updateForm(Muayene t) {
        this.entity = t;
        return "update";
    }

    public String update() {
        this.getMuayeneModel().update(entity);
        return "index";
    }

    public String tedaviEkle(){
        this.getMuayeneModel().muayeneyeTedaviEkle(entity);
        return "index";
    }

    public void delete(Muayene t) {
        this.getMuayeneModel().delete(t);
    }

    public MuayeneBean() {
    }

    public MuayeneModel getMuayeneModel() {
        if (this.muayeneModel == null) {
            this.muayeneModel = new MuayeneModel();
        }
        return muayeneModel;
    }

    public void setMuayeneModel(MuayeneModel muayeneModel) {
        this.muayeneModel = muayeneModel;
    }

    public Muayene getEntity() {
        if (this.entity == null) {
            this.entity = new Muayene();
        }
        return entity;
    }

    public void setEntity(Muayene entity) {
        this.entity = entity;
    }

}
