import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Kütüphaneye Rastgele Kitap Ekle
        Kutuphane kutuphane = new Kutuphane();
        int kitapSayisi = 36;

        for (int i = 0; i < kitapSayisi; i++) {
            String randomBaslik = GenerateKitapBilgileri.rastgeleKitapIsmi();
            String randomYazar = GenerateKitapBilgileri.rastgeleYazar(randomBaslik);
            int randomYayinYili = GenerateKitapBilgileri.rastgeleYayinYili();
            String isbn = GenerateKitapBilgileri.generateUniqueIsbn(randomBaslik);

            Kitap kitap = new KitapBilim(isbn, randomBaslik, randomYazar, randomYayinYili, EDurum.OduncAlabilir);
            Kitap kitap2 = new KitapTarih(isbn, randomBaslik, randomYazar, randomYayinYili, EDurum.OduncAlabilir);
            Kitap kitap3 = new KitapRoman(isbn, randomBaslik, randomYazar, randomYayinYili, EDurum.OduncAlabilir);
            kutuphane.kitapEkle(kitap);
            kutuphane.kitapEkle(kitap2);
            kutuphane.kitapEkle(kitap3);
        }

        // Uye Ekle
        Uye uye1 = new Uye("Ahmet", "Yol");
        Uye uye2 = new Uye("Selim", "Aslan");
        Uye uye3 = new Uye("Bera", "Bal");
        Uye uye4 = new Uye("Mert", "Bakır");
        Uye uye5 = new Uye("Sena", "Soydan");
        kutuphane.uyeEkle(uye1);
        kutuphane.uyeEkle(uye2);
        kutuphane.uyeEkle(uye3);
        kutuphane.uyeEkle(uye4);
        kutuphane.uyeEkle(uye5);

        Scanner scanner = new Scanner(System.in);

        int secim;
        do {
            // Menüyü yazdır
            System.out.println("******* KÜTÜPHANE *******");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
            System.out.println("1. Kitap ödünç al");
            System.out.println("2. Kitap iade et");
            System.out.println("3. Kitabın durumunu güncelle");
            System.out.println("4. Ödünç alınan kitapları görüntüle");
            System.out.println("5. Kütüphane durumunu görüntüle");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminiz: ");

            // Kullanıcının seçimini al
            secim = scanner.nextInt();
            scanner.nextLine();
            // Kullanıcının seçimine göre işlem yap
                String ISBN;
                String ad;
                String soyad;
                Kitap kitap;
                Uye uye;
            switch (secim) {
                case 1:
                    // Kitap ödünç alma işlemi
                    System.out.println("Kitap Ödünç Alma İşlemi");

                    // Kitap ve üye bilgilerini al
                    System.out.print("ISBN: ");
                    ISBN = scanner.next();
                    kitap = kutuphane.kitapBul(ISBN);
                    if (kitap == null){
                        System.out.println("Böyle bir kitap bulunamadı");
                        break;
                    }
                    if (kitap.getDurum() == EDurum.OduncAlabilir){
                        System.out.print("Ad: ");
                        ad = scanner.next();
                        System.out.print("Soyad: ");
                        soyad = scanner.next();
                        uye = kutuphane.uyeBul(ad, soyad);
                        if (uye == null){
                            System.out.println("Üye bulunamadı.");
                            break;
                        }
                        System.out.println("Uye bulundu. " + uye.getAd());
                        uye.kitapOduncAl(kitap);
                        break;
                    } else if (kitap.getDurum() == EDurum.OduncVerildi){
                        System.out.println("Bu kitap başka bir üyeye kiralandı. " + kitap.getBaslik());
                        break;
                    } else {
                        System.out.println("Bu kitap şu anda mevcut değildir. " + kitap.getBaslik());
                    }
                    break;
                case 2:
                    // Kitap iade etme işlemi
                    System.out.println("Kitap iade etme İşlemi");

                    // Kitap ve üye bilgilerini al
                    System.out.print("ISBN: ");
                    ISBN = scanner.next();
                    System.out.print("Ad: ");
                    ad = scanner.next();
                    System.out.print("Soyad: ");
                    soyad = scanner.next();

                    kitap = kutuphane.kitapBul(ISBN);
                    System.out.println("Kitap bulundu " + kitap.getBaslik());
                    uye = kutuphane.uyeBul(ad, soyad);
                    System.out.println("Uye bulundu " + uye.getAd());
                    uye.kitapIadeEt(kitap);
                    break;
                case 3:
                    // Kitabın durumunu güncelleme işlemi
                    System.out.println("Kitabın durumunu güncelleme işlemi");
                    System.out.print("ISBN: ");
                    ISBN = scanner.next();
                    kitap = kutuphane.kitapBul(ISBN);

                    if (kitap != null) {
                        System.out.println("Kitabın mevcut durumu: " + kitap.getDurum().getLabel());
                        System.out.println("Yeni durumu seçin:");
                        System.out.println("1. Ödünç alınabilir");
                        System.out.println("2. Ödünç verildi");
                        System.out.println("3. Mevcut değil");
                        int yeniDurumSecim = scanner.nextInt();

                        EDurum yeniDurum;
                        switch (yeniDurumSecim) {
                            case 1:
                                yeniDurum = EDurum.OduncAlabilir;
                                break;
                            case 2:
                                yeniDurum = EDurum.OduncVerildi;
                                break;
                            case 3:
                                yeniDurum = EDurum.MevcutDegil;
                                break;
                            default:
                                System.out.println("Geçersiz seçim! Durum güncellenemedi.");
                                continue;
                        }
                        // Kitabın durumunu güncelle
                        kitap.setDurum(yeniDurum);
                        System.out.println("Kitabın yeni durumu: " + yeniDurum.getLabel());
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;
                case 4:
                    // Ödünç alınan kitapları görüntüleme işlemi
                    System.out.println("Ödünç alınan kitapları görüntüle");
                    kutuphane.oduncAlinanKitaplariGoruntule();
                    break;
                case 5:
                    // Kütüphane durumunu görüntüleme işlemi
                    kutuphane.kutuphaneDurumunuGoruntule();
                    break;
                case 6:
                    System.out.println("Programdan çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        } while (secim != 6);

        scanner.close();

    }
}