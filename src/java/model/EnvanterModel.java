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
    public List<Envanter> read(int start,int pageSize) {
        List<Envanter> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM envanter ORDER BY id ASC LIMIT " + start + ", " + pageSize);

            while (rs.next()) {
                Envanter envanter = new Envanter(rs.getInt("id"), rs.getString("aciklama"), rs.getInt("adet"));
                list.add(envanter);
            }
            
            st.close();
            rs.close();

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
    
    public Envanter getById(int id){
        
        Envanter env = null;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from envanter where id = "+id);
            rs.next();
            
            env = new Envanter(rs.getInt("id"), rs.getString("aciklama"),rs.getInt("adet"));
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return env;
    }

    public int count() {
         int count = 0;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as toplam FROM envanter");
            rs.next();
            count = rs.getInt("toplam");
            
        } catch (Exception e) {
           
        }
        return count;
    }

}
