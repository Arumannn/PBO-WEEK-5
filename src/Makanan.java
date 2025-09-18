public class Makanan extends Produk implements IDapatDiskon {

    public Makanan(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public String getJenisProduk() {
        return "Makanan";
    }

    @Override
    public double hitungHargaSetelahDiskon() {
        return harga - (harga * HITUNGAN_DISKON);
    }
}