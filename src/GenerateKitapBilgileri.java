import java.util.*;

public class GenerateKitapBilgileri {

    // Önceden tanımlı kitap isimleri
    private static final String[] KITAP_ISIMLERI = {
            "Beyaz Zambaklar Ülkesinde",
            "Sineklerin Tanrısı",
            "Simyacı",
            "1984",
            "Kürk Mantolu Madonna",
            "Suç ve Ceza",
            "Satranç",
            "Bülbülü Öldürmek",
            "Yabancı",
            "Şeker Portakalı",
            "Kırmızı Pazartesi",
            "Küçük Prens",
            "Bir İdam Mahkumunun Son Günü",
            "İnsan Ne İle Yaşar"
    };

    // Önceden tanımlı yazarlar
    private static final String[] YAZARLAR = {
            "Albert Einstein",
            "Marie Curie",
            "Charles Darwin",
            "William Shakespeare",
            "Jane Austen",
            "Leo Tolstoy",
            "Emily Dickinson",
            "Ernest Hemingway",
            "Virginia Woolf",
            "Fyodor Dostoevsky",
            "J.K. Rowling",
            "Mark Twain",
            "Agatha Christie",
            "Oscar Wilde",
    };

    // Önceden tanımlı yayın yılları aralığı
    private static final int MIN_YAYIN_YILI = 1800;
    private static final int MAX_YAYIN_YILI = 2022;
    private static final Map<String, String> ISBN_KITAP_MAP = new HashMap<>();
    public static String generateRandomIsbn() {
        StringBuilder isbnBuilder = new StringBuilder();
        // 13 rakamlı ISBN üretme
        for (int i = 0; i < 13; i++) {
            int digit = (int) (Math.random() * 10);
            isbnBuilder.append(digit);
        }
        return isbnBuilder.toString();
    }
    // Her bir kitaba unique bir ISBN oluştur
    public static String generateUniqueIsbn(String kitapIsmi) {
        if (ISBN_KITAP_MAP.containsKey(kitapIsmi)) {
            return ISBN_KITAP_MAP.get(kitapIsmi);
        } else {
            String isbn = generateRandomIsbn();
            ISBN_KITAP_MAP.put(kitapIsmi, isbn);
            return isbn;
        }
    }
    private static final Random random = new Random();
    // Rastgele bir kitap ismi seçen metod
    public static String rastgeleKitapIsmi() {
        return KITAP_ISIMLERI[random.nextInt(KITAP_ISIMLERI.length)];
    }
    // Rastgele bir yazar seçen metod
    public static String rastgeleYazar(String kitapAdi) {
        int hash = kitapAdi.hashCode();
        int index = Math.abs(hash % YAZARLAR.length);
        return YAZARLAR[index];
    }
    // Rastgele bir yayın yılı seçen metod
    public static int rastgeleYayinYili() {
        return random.nextInt(MAX_YAYIN_YILI - MIN_YAYIN_YILI + 1) + MIN_YAYIN_YILI;
    }
    // Rastgele Durum
    public static EDurum rastgeleKitapDurumu(){
        EDurum[] durumlar = EDurum.values();
        return durumlar[random.nextInt(durumlar.length)];
    }

}
