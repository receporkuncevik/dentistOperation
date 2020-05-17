package model;

import entity.Tedavi;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author RecepOrkun
 */
public class TedaviModel extends DBConnection {

    //CRUD İşlemleri
    //Create
    public void create(Tedavi tedavi) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into tedavi(aciklama) Values('" + tedavi.getAciklama() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //READ
    public List<Tedavi> read() {
        List<Tedavi> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tedavi ORDER BY id ASC");

            while (rs.next()) {
                Tedavi tedavi = new Tedavi(rs.getInt("id"), rs.getString("aciklama"));
                list.add(tedavi);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //UPDATE
    public void update(Tedavi tedavi) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("UPDATE tedavi SET aciklama='" + tedavi.getAciklama() + "' WHERE id=" + tedavi.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //DELETE
    public void delete(Tedavi tedavi) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM tedavi WHERE id=" + tedavi.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
