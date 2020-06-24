package model;

import entity.Kullanici;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author RecepOrkun
 */
public class KullaniciModel extends DBConnection {

    //CRUD İşlemleri
    //Create
    public void create(Kullanici kullanici) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into kullanici(kullanici_adi,sifre) Values('" + kullanici.getKullaniciAdi()+ "','" + kullanici.getSifre()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //READ
    public List<Kullanici> read(int start,int pageSize) {
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM kullanici ORDER BY id ASC LIMIT " + start + ", " + pageSize);

            while (rs.next()) {
                Kullanici kullanici = new Kullanici(rs.getInt("id"), rs.getString("kullanici_adi"), rs.getString("sifre"));
                list.add(kullanici);
            }
            
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //UPDATE
    public void update(Kullanici kullanici) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("UPDATE kullanici SET aciklama='" + kullanici.getKullaniciAdi()+ "',adet='" + kullanici.getSifre()+"' WHERE id=" + kullanici.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //DELETE
    public void delete(Kullanici kullanici) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("DELETE FROM kullanici WHERE id=" + kullanici.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean kullaniciBul(Kullanici k){
        Kullanici tmp = k;
        boolean login = false;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT kullanici_adi,sifre FROM kullanici");
            
            while(rs.next()){
                if(tmp.getKullaniciAdi().equals(rs.getString("kullanici_adi")) && tmp.getSifre().equals(rs.getString("sifre"))){
                    login = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as toplam FROM kullanici");
            rs.next();
            count = rs.getInt("toplam");
            
        } catch (Exception e) {
           
        }
        return count;
    }

}
