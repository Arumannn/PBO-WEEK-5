// Simpan sebagai src/App.java
public class App {
    public static void main(String[] args) throws Exception {
        Produk[] daftarProduk = {
            new Makanan("Nasi Goreng Spesial", 25000.0),
            new Makanan("Sate Ayam", 20000.0),
            new Makanan("Bakso Urat", 18000.0),
            new Minuman("Es Teh Manis", 5000.0),
            new Minuman("Jus Alpukat", 12000.0)
        };

        Kantin kantinFT = new Kantin(daftarProduk);

        System.out.println("Selamat Datang di Kantin Fakultas Teknik!");
        kantinFT.displayMenu();

        kantinFT.prosesPembelian();
        
        kantinFT.tutupScanner();
    }
}