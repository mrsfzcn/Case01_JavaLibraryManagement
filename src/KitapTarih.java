public class KitapTarih extends Kitap{
    private EDurum durum;

    public KitapTarih(String ISBN, String baslik, String yazar, int yayinYili, EDurum durum) {
        super(ISBN, baslik, yazar, yayinYili, durum);
        this.durum = durum;
    }
    @Override
    public EDurum getDurum() {
        return durum;
    }
    @Override
    public void setDurum(EDurum durum) {
        this.durum = durum;
    }
}
