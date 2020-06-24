
package controller;

import entity.Rontgen;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import model.RontgenModel;

@Named
@SessionScoped
public class RontgenBean implements Serializable {
    private Rontgen rontgen;
    private RontgenModel rontgenModel;
    
    private Part doc;
    
    private String uploadTo = "/Users/RecepOrkun/upload/";
    
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
    
    public String upload(){
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo+doc.getSubmittedFileName());
            if(f.exists()){
                f.delete();
            }
            Files.copy(input, f.toPath());
            
            rontgen = this.getRontgen();
            rontgen.setFilePath(f.getParent());
            rontgen.setFileName(f.getName());
            rontgen.setFileType(doc.getContentType()); 
            
            this.getRontgenModel().create(rontgen); 
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "create";
    }
    
    public List<Rontgen> getRead() {
        int start = (page-1)* this.pageSize;
        return this.getRontgenModel().read(start,this.pageSize);
    }
    
     public void delete(Rontgen r) {
        this.getRontgenModel().delete(r);
    }

    

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadTo() {
        return uploadTo;
    }
    
    public Rontgen getRontgen() {
        if(this.rontgen ==  null){
            this.rontgen= new Rontgen();
        }
        return rontgen;
    }

    public void setRontgen(Rontgen rontgen) {
        this.rontgen = rontgen;
    }


    public RontgenModel getRontgenModel() {
        if(this.rontgenModel == null){
            this.rontgenModel= new RontgenModel();
        }
        return rontgenModel;
    }

    public void setRontgenModel(RontgenModel rontgenModel) {
        this.rontgenModel = rontgenModel;
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
        this.pageCount = (int) Math.ceil( this.getRontgenModel().count() / (double) this.pageSize);
        return this.pageCount;
    }
    
     public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
}
