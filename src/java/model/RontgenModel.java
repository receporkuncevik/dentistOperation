package model;

import entity.Doktor;
import entity.Hasta;
import entity.Rontgen;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RontgenModel extends DBConnection {

    private HastaModel hModel;
  
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
    public List<Rontgen> read(int start,int pageSize) {
        List<Rontgen> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rontgen ORDER BY id ASC LIMIT " + start + ", " + pageSize);
            while (rs.next()) {
                Hasta h = this.gethModel().getById(rs.getInt("hasta_id"));
                Rontgen rontgen = new Rontgen(rs.getInt("id"), h , rs.getString("file_name"),rs.getString("file_type"),rs.getString("file_path"));
                list.add(rontgen);
            }

            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    //CRUD İşlemleri
    //Create
    public void create(Rontgen rontgen) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into rontgen(hasta_id,file_name,file_type,file_path) Values(" + rontgen.getHasta().getId() + ",'" + rontgen.getFileName() + "','" + rontgen.getFileType()+ "','" + rontgen.getFilePath()+ "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    //DELETE
    public void delete(Rontgen rontgen) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM rontgen WHERE id=" + rontgen.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as toplam FROM rontgen");
            rs.next();
            count = rs.getInt("toplam");
            
        } catch (Exception e) {
           
        }
        return count;
    }
    
    
}
