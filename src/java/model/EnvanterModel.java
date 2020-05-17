package model;

import entity.Envanter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author RecepOrkun
 */
public class EnvanterModel extends DBConnection {

    //CRUD İşlemleri
    //Create
    public void create(Envanter envanter) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into envanter(aciklama,adet) Values('" + envanter.getAciklama()+ "','" + envanter.getAdet()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //READ
    public List<Envanter> read() {
        List<Envanter> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM envanter ORDER BY id ASC");

            while (rs.next()) {
                Envanter envanter = new Envanter(rs.getInt("id"), rs.getString("aciklama"), rs.getInt("adet"));
                list.add(envanter);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //UPDATE
    public void update(Envanter envanter) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("UPDATE envanter SET aciklama='" + envanter.getAciklama()+ "',adet='" + envanter.getAdet()+"' WHERE id=" + envanter.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //DELETE
    public void delete(Envanter envanter) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM envanter WHERE id=" + envanter.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
