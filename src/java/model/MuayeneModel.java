package model;

import entity.Doktor;
import entity.Hasta;
import entity.Muayene;
import entity.Randevu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class MuayeneModel extends DBConnection {

    private DoktorModel dModel;
    private HastaModel hModel;
    private RandevuModel rModel;
    private TedaviModel tModel;
    private EnvanterModel eModel;

    public TedaviModel gettModel() {
        if (this.tModel == null) {
            this.tModel = new TedaviModel();
        }
        return tModel;
    }

    public void settModel(TedaviModel tModel) {
        this.tModel = tModel;
    }

    public EnvanterModel geteModel() {
        if (this.eModel == null) {
            this.eModel = new EnvanterModel();
        }
        return eModel;
    }

    public void seteModel(EnvanterModel eModel) {
        this.eModel = eModel;
    }

    public DoktorModel getdModel() {
        if (dModel == null) {
            this.dModel = new DoktorModel();
        }
        return dModel;
    }

    public void setdModel(DoktorModel dModel) {
        this.dModel = dModel;
    }

    public HastaModel gethModel() {
        if (hModel == null) {
            this.hModel = new HastaModel();
        }
        return hModel;
    }

    public void sethModel(HastaModel hModel) {
        this.hModel = hModel;
    }

    public RandevuModel getrModel() {
        if (rModel == null) {
            this.rModel = new RandevuModel();
        }
        return rModel;
    }

    public void setrModel(RandevuModel rModel) {
        this.rModel = rModel;
    }

    //READ
    public List<Muayene> read(int start, int pageSize) {
        List<Muayene> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM muayene ORDER BY id ASC LIMIT " + start + ", " + pageSize);

            while (rs.next()) {
                Doktor d = getdModel().getById(rs.getInt("doktor_id"));
                Hasta h = gethModel().getById(rs.getInt("hasta_id"));
                Randevu r = getrModel().getById(rs.getInt("randevu_id"));
                Muayene muayene = new Muayene(rs.getInt("id"), d, h, r);
                list.add(muayene);
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
    public void create(Muayene muayene) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into muayene(doktor_id,hasta_id,randevu_id) values(" + muayene.getDoktor().getId() + "," + muayene.getHasta().getId() + "," + muayene.getRandevu().getId() + ")");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //UPDATE
    public void update(Muayene muayene) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("UPDATE muayene SET doktor_id=" + muayene.getDoktor().getId() + ",hasta_id=" + muayene.getHasta().getId() + ",randevu_id=" + muayene.getRandevu().getId() + " WHERE id=" + muayene.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //DELETE
    public void delete(Muayene muayene) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM muayene WHERE id=" + muayene.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void muayeneyeTedaviEkle(Muayene muayene) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into muayene_tedavi(muayene_id,tedavi_id) values(" + muayene.getId() + "," + muayene.getTedavi().getId() + ")");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as muayene_sayi FROM muayene");
            rs.next();
            count = rs.getInt("muayene_sayi");
            
        } catch (Exception e) {
           
        }
        return count;
    }

}
