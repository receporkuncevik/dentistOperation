package model;

import entity.Hasta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class HastaModel extends DBConnection {

    //CRUD İşlemleri
    //Create
    public void create(Hasta hasta) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into hasta(adi,soyadi,telefon,tckimlikno) Values('" + hasta.getAdi() + "','" + hasta.getSoyadi() + "','" + hasta.getTelefon()+ "','" + hasta.getTckimlikno()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //READ
    public List<Hasta> read(int start,int pageSize) {
        List<Hasta> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM hasta ORDER BY id ASC LIMIT " + start + ", " + pageSize);

            while (rs.next()) {
                Hasta hasta = new Hasta(rs.getInt("id"), rs.getString("adi"), rs.getString("soyadi"),
                        rs.getString("telefon"), rs.getString("tckimlikno"));
                list.add(hasta);
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //UPDATE
    public void update(Hasta hasta) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("UPDATE hasta SET adi='" + hasta.getAdi() + "',soyadi='" + hasta.getSoyadi() + "',telefon='" + hasta.getTelefon()+ "',tckimlikno='" + hasta.getTckimlikno()+ "' WHERE id=" + hasta.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //DELETE
    public void delete(Hasta hasta) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM hasta WHERE id=" + hasta.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
     public Hasta getById(int id){
        Hasta h = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("Select * From hasta where id = "+id);
            rs.next();
            
            h = new Hasta(rs.getInt("id"), rs.getString("adi"), rs.getString("soyadi"), rs.getString("telefon"), rs.getString("tckimlikno"));
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return h;
    }

    public List<Hasta> getDoktorHastalari(int id) {
        List<Hasta> doktorHastalari = new ArrayList<>();
        
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("Select * From doktor_hasta where doktor_id = "+id);
            
            while(rs.next()){
                doktorHastalari.add(this.getById(rs.getInt("hasta_id")));
            }
            
        } catch (Exception e) {
        }
        
        return doktorHastalari;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as toplam FROM hasta");
            rs.next();
            count = rs.getInt("toplam");
            
        } catch (Exception e) {
           
        }
        return count;
    }

}
