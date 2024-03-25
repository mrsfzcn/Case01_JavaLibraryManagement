public enum EDurum {

    OduncAlabilir("Kitap ödünç alınabilir"),
    OduncVerildi("Kitap ödünç verildi"),
    MevcutDegil("Kitap mevcut değil");
    private final String label;
    private EDurum(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
