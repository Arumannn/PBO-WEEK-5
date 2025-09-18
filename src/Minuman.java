public class Minuman extends Produk {

    public Minuman(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public String getJenisProduk() {
        return "Minuman";
    }
}