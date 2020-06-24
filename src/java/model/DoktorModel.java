package model;

import entity.Doktor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author RecepOrkun
 */
public class DoktorModel extends DBConnection {
    
    private HastaModel hastaModel;

    public HastaModel getHastaModel() {
        if(this.hastaModel == null){
            this.hastaModel = new HastaModel();
        }
        return hastaModel;
    }
    
    
     public Doktor getById(int id){
        Doktor d = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from doktor where id = "+id);
            rs.next();
            
            d = new Doktor(rs.getInt("id"), rs.getString("adi"), rs.getString("soyadi"), rs.getString("ihtisas"), rs.getString("telefon"));
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return d;
    }
   

    //CRUD İşlemleri
    //Create
    public void create(Doktor doktor) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into doktor(adi,soyadi,ihtisas,telefon) Values('" + doktor.getAdi() + "','" + doktor.getSoyadi() + "','" + doktor.getIhtisas() + "','" + doktor.getTelefon() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //READ
    public List<Doktor> read(int start,int pageSize) {
        List<Doktor> dlist = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM doktor ORDER BY id ASC LIMIT " + start + ", " + pageSize);
            while (rs.next()) {
                Doktor doktor = new Doktor(rs.getInt("id"), rs.getString("adi"), rs.getString("soyadi"),
                        rs.getString("ihtisas"), rs.getString("telefon"));
                dlist.add(doktor);
                
                doktor.setDoktorHastalari(this.getHastaModel().getDoktorHastalari(doktor.getId()));
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return dlist;
       
    }

    //UPDATE
    public void update(Doktor doktor) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("UPDATE doktor SET adi='" + doktor.getAdi() + "',soyadi='" + doktor.getSoyadi() + "',ihtisas='" + doktor.getIhtisas() + "',telefon='" + doktor.getTelefon() + "' WHERE id=" + doktor.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //DELETE
    public void delete(Doktor doktor) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM doktor WHERE id=" + doktor.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hastaEkle(Doktor entity) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into doktor_hasta(doktor_id,hasta_id) Values("+ entity.getId() +","+entity.getHasta().getId()+")");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void doktorHastasiSil(Doktor d) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM doktor_hasta WHERE id=" + d.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as toplam FROM doktor");
            rs.next();
            count = rs.getInt("toplam");
            
        } catch (Exception e) {
           
        }
        return count;
    }

   

}
