import java.util.Date;

public class OduncAlinanKitap {

    private Kitap kitap;
    private Uye uye;
    private Date oduncAlmaTarihi;
    private Date iadeTarihi;

    public OduncAlinanKitap(Kitap kitap, Uye uye) {
        this.kitap = kitap;
        this.uye = uye;
        this.oduncAlmaTarihi = new Date();
        this.iadeTarihi = new Date();
    }

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public Uye getUye() {
        return uye;
    }

    public void setUye(Uye uye) {
        this.uye = uye;
    }

    public Date getOduncAlmaTarihi() {
        return oduncAlmaTarihi;
    }

    public void setOduncAlmaTarihi(Date oduncAlmaTarihi) {
        this.oduncAlmaTarihi = oduncAlmaTarihi;
    }

    public Date getIadeTarihi() {
        return iadeTarihi;
    }

    public void setIadeTarihi(Date iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }
}
