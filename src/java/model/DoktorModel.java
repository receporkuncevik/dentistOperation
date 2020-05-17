package model;

import entity.Doktor;
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
    public List<Doktor> read() {
        List<Doktor> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM doktor ORDER BY id ASC");

            while (rs.next()) {
                Doktor doktor = new Doktor(rs.getInt("id"), rs.getString("adi"), rs.getString("soyadi"),
                        rs.getString("ihtisas"), rs.getString("telefon"));
                list.add(doktor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
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

}
