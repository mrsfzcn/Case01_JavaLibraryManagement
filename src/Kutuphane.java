import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kutuphane {

    //Kitapları ISBN'e göre tutacak map yapısı
    private Map<String, Kitap> kitaplar;
    // Üyeleri üye numarasına göre tutacak map yapısı
    private Map<String, Uye> uyeler;

    private List<OduncAlinanKitap> oduncAlinanKitaplar;

    public Kutuphane(){
        kitaplar = new HashMap<>();
        uyeler = new HashMap<>();
    }

    public void kitapEkle(Kitap kitap){
        kitaplar.put(kitap.getISBN(), kitap);
    }
    public void uyeEkle(Uye uye){
        uyeler.put(uye.getAd() + " " + uye.getSoyad(), uye);
    }
    public Kitap kitapBul(String ISBN) {
        return kitaplar.get(ISBN);
    }
    public Uye uyeBul(String ad, String soyad) {
        for (Uye uye : uyeler.values()) {
            if (uye.getAd().equalsIgnoreCase(ad) && uye.getSoyad().equalsIgnoreCase(soyad)) {
                return uye;
            }
        }
        return null; // Üye bulunamadı
    }
    public void oduncAlinanKitaplariGoruntule() {
        System.out.println("Ödünç alınan kitaplar:");
        for (Uye uye : uyeler.values()) {
            List<OduncAlinanKitap> oduncAlinanKitaplar = uye.getOduncAlinanKitaplar();
            for (OduncAlinanKitap oduncAlinanKitap : oduncAlinanKitaplar) {
                System.out.println(oduncAlinanKitap.getKitap().getBaslik() + " - Ödünç alan üye: " + uye.getAd() + " " + uye.getSoyad());
            }
        }
    }

    public void kutuphaneDurumunuGoruntule() {

        System.out.println("Kütüphane Durumu:");
        // Mevcut kitapları göster
        System.out.println("Mevcut Kitaplar:");
        for (Kitap kitap : kitaplar.values()) {
            System.out.println(" ISBN: " +kitap.getISBN() + " Kitap Adı: " + kitap.getBaslik() + " - Yazar: " + kitap.getYazar() + " - Durum: " + kitap.getDurum().getLabel());
        }
        // Ödünç alınan kitapları göster
        oduncAlinanKitaplariGoruntule();
        // Üyeleri göster
        System.out.println("\nÜyeler:");
        for (Uye uye : uyeler.values()) {
            System.out.println(uye.getAd() + " " + uye.getSoyad());
        }
    }


}
