package model;

import entity.Hasta;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author RecepOrkun
 */
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
    public List<Hasta> read() {
        List<Hasta> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM hasta ORDER BY id ASC");

            while (rs.next()) {
                Hasta hasta = new Hasta(rs.getInt("id"), rs.getString("adi"), rs.getString("soyadi"),
                        rs.getString("telefon"), rs.getString("tckimlikno"));
                list.add(hasta);
            }

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

}
