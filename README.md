# dentistOperation
Diş Hekimlerinin, Hasta Kayıtlarının ve Randevuların tutulduğu envanter takibi yapılabilecek bir yönetim otomasyonu

Projede Kullanılan Kaynaklar

Glassfish 5.0.1
MariaDb 10.4
Java EE 8
Oracle Java JDK 8

-----------------------------------------------

Ajax istekleri sil butonlarına eklendi.

Her tabloya pagination yapıldı.

Dosya Ekleme işlemi Rontgen Ekle ile sağlandı.

Ayrıca Dosya ekleme işlemi hastaya bağlandı.hasta seçilerekden dosya ekleme işlemi yapıldı.

Src -> Validation klasörü içine boş alan uyarısı verdiren CustomValidator yazıldı.

Veritabanındaki kullanıcıya bağlı olarak LoginFilter eklendi. (Register olmadığı için ilk kullanıcı elle girilmek zorunda kalınabilir.)

Veritabanı Dosyası Src-> util içine eklendi dump'lanırken data+structure şeklinde dumplandı ancak eksik data olabilir o yüzden kullanıcı boş olabilir.

One-to-Many ilişkili tablolar listelendi ekleme ve düzenlemesi yapıldı.

Many-to-Many ilişkili tablolarda ise doktor_hasta tablosunda listeleme ve bu tabloya ekleme yapılabiliyor ancak düzenle ve sili yok birde muayene_tedavi tablosuna ekleme yapılabiliyor.

Xhtml validator login işleminde kullanıldı.

Anasayfaya Toplam Hasta,Randevu,Muayene ve Doktor eklendi. 

Anasayfaya Muayene listesi ile randevu listesi eklendi bunların önceki sayfa ve sonraki sayfa butonlarına ajax eklendi.

Randevuda Date tipinde veri gönderemedigimiz için veritabanına kayıt işlemi gerçekleşmiyor ancak veritabanında eklenen bir kayıt listelenebiliyor. Date'i <f:dateTimeConverter ile denedik ancak bir türlü veriyi istenilen şekilde veritabanına gönderemedik oyüzden kayıt eklemede ve düzenlemede sıkıntımız var sil çalışıyor.

Muayenede ise randevusuz muayene gelebilir diye randevu null olabilir yaptık oyüzden randevulu veya randevusuz her türlü ekleme yapıyor.


