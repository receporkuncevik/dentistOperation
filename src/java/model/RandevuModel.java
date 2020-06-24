package model;

import entity.Doktor;
import entity.Hasta;
import entity.Randevu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RandevuModel extends DBConnection {

    private DoktorModel dModel;
    private HastaModel hModel;

    public DoktorModel getdModel() {
        if (this.dModel == null) {
            this.dModel = new DoktorModel();
        }
        return dModel;
    }

    public void setdModel(DoktorModel dModel) {
        this.dModel = dModel;
    }

    public HastaModel gethModel() {
        if (this.hModel == null) {
            this.hModel = new HastaModel();
        }
        return hModel;
    }

    public void sethModel(HastaModel hModel) {
        this.hModel = hModel;
    }

    //READ
    public List<Randevu> read(int start,int pageSize) {
        List<Randevu> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM randevu ORDER BY id ASC LIMIT " + start + ", " + pageSize);
            while (rs.next()) {
                Doktor d = this.getdModel().getById(rs.getInt("doktor_id"));
                Hasta h = this.gethModel().getById(rs.getInt("hasta_id"));
                Randevu randevu = new Randevu(rs.getInt("id"), d, h, rs.getDate("tarih_saat"));
                list.add(randevu);
            }

            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Randevu getById(int id) {
        Randevu r = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from randevu where id = " + id);
            rs.next();
            r = new Randevu(rs.getInt("id"), getdModel().getById(rs.getInt("id")), gethModel().getById(rs.getInt("id")), rs.getDate("tarih_saat"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    //CRUD İşlemleri
    //Create
    public void create(Randevu randevu) {
        
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into randevu(doktor_id,hasta_id,tarih_saat) Values(" + randevu.getDoktor().getId() + "," + randevu.getHasta().getId() + ",'" + randevu.getTarihSaat() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //UPDATE
    public void update(Randevu randevu) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("UPDATE randevu SET doktor_id=" + randevu.getDoktor().getId() + ",hasta_id=" + randevu.getHasta().getId() + ",tarih_saat=" + randevu.getTarihSaat() + " WHERE id=" + randevu.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //DELETE
    public void delete(Randevu randevu) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM randevu WHERE id=" + randevu.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as toplam FROM randevu");
            rs.next();
            count = rs.getInt("toplam");
            
        } catch (Exception e) {
           
        }
        return count;
    }

}
