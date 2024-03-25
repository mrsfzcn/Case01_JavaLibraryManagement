import java.util.ArrayList;
import java.util.List;

public class Uye implements IUye{
    private String ad;
    private String soyad;
    private List<OduncAlinanKitap> oduncAlinanKitaplar;

    public Uye(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
        this.oduncAlinanKitaplar = new ArrayList<>();
    }
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public String getSoyad() {
        return soyad;
    }
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    public List<OduncAlinanKitap> getOduncAlinanKitaplar() {
        return oduncAlinanKitaplar;
    }
    public void setOduncAlinanKitaplar(List<OduncAlinanKitap> oduncAlinanKitaplar) {
        this.oduncAlinanKitaplar = oduncAlinanKitaplar;
    }
    @Override
    public void kitapOduncAl(Kitap kitap) {
        // status check
        EDurum durum = kitap.getDurum();
        OduncAlinanKitap oduncAlinanKitap;
        switch (durum) {
            case OduncAlabilir:
                // Kitabı ödünç alınan kitaplar listesine ekle
                oduncAlinanKitap = new OduncAlinanKitap(kitap, this);
                oduncAlinanKitaplar.add(oduncAlinanKitap);
                System.out.println(kitap.getBaslik() + " kitabı ödünç alındı.");
                kitap.setDurum(EDurum.OduncVerildi);
                break;
            case OduncVerildi:
                oduncAlinanKitap = new OduncAlinanKitap(kitap, this);
                oduncAlinanKitaplar.remove(oduncAlinanKitap);
                System.out.println("Bu kitap zaten ödünç verilmiş.");
                kitap.setDurum(EDurum.OduncVerildi);
                break;
            case MevcutDegil:
                oduncAlinanKitap = new OduncAlinanKitap(kitap, this);
                oduncAlinanKitaplar.remove(oduncAlinanKitap);
                System.out.println("Bu kitap mevcut değil.");
                kitap.setDurum(EDurum.MevcutDegil);
                break;
            default:
                System.out.println("Bilinmeyen bir durumla karşılaşıldı.");
                break;
        }
    }
    @Override
    public void kitapIadeEt(Kitap kitap) {

        // Kitap kiracıda mı kontrolü.
        for (OduncAlinanKitap oduncAlinanKitap : oduncAlinanKitaplar){
            if (oduncAlinanKitap.getKitap().equals(kitap)){
                // Ödünç alınan listesinden kaldır.
                oduncAlinanKitaplar.remove(oduncAlinanKitap);
                System.out.println(kitap.getBaslik() + " kitabı iade edildi.");
                kitap.setDurum(EDurum.OduncAlabilir);
                return;
            }
        }
        // Listede yoksa bilgi ver.
        System.out.println("Kitap zaten ödünç alınmamış.");
    }

}
