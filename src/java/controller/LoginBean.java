package controller;

import entity.Kullanici;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.KullaniciModel;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    private KullaniciModel kModel;
    private Kullanici kullanici;

    public LoginBean() {
    }
    
    
    
    public KullaniciModel getkModel() {
        if(this.kModel == null){
            this.kModel = new KullaniciModel();
        }
        return kModel;
    }

    public void setkModel(KullaniciModel kModel) {
        this.kModel = kModel;
    }

    public Kullanici getKullanici() {
        if(this.kullanici == null){
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
    
    public String girisYap(){
        if(getkModel().kullaniciBul(kullanici)){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.kullanici);
            return "/index.xhtml";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı Kullanıcı Adı veya Şifre"));
            return "/giris/login.xhtml";
        }
         
    }
    
    

    
    
    
}
