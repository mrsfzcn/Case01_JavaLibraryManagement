
public abstract class Kitap {

    private String ISBN;
    private String baslik;
    private String yazar;
    private int yayinYili;
    private EDurum durum;

    // Constructor
    public Kitap(String ISBN, String baslik, String yazar, int yayinYili, EDurum durum) {
        this.ISBN = ISBN;
        this.baslik = baslik;
        this.yazar = yazar;
        this.yayinYili = yayinYili;
        this.durum = durum;
    }
    // Getter
    public String getISBN() {
        return ISBN;
    }
    public String getBaslik() {
        return baslik;
    }
    public String getYazar() {
        return yazar;
    }
    public int getYayinYili() {
        return yayinYili;
    }

    // Abstract metot
    public abstract EDurum getDurum();
    public abstract void setDurum(EDurum durum);
}
