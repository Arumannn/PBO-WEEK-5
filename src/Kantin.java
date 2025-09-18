import java.util.InputMismatchException;
import java.util.Scanner;

public class Kantin {
    private Produk[] daftarProduk;
    private Scanner input; 
    public Kantin(Produk[] daftarProduk) {
        this.daftarProduk = daftarProduk;
        this.input = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("================================ MENU KANTIN ================================");
        System.out.println("No. | Jenis   | Nama Produk          | Harga Normal    | Harga Diskon");
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < daftarProduk.length; i++) {
            Produk produk = daftarProduk[i];
            String namaProduk = produk.getNama();
            String jenisProduk = produk.getJenisProduk();
            double hargaNormal = produk.getHarga();
            String hargaDiskonStr = "-";

            if (produk instanceof IDapatDiskon) {
                IDapatDiskon produkDiskon = (IDapatDiskon) produk;
                double hargaDiskon = produkDiskon.hitungHargaSetelahDiskon();
                hargaDiskonStr = "Rp" + String.format("%.2f", hargaDiskon);
            }
            
            System.out.printf("%-4d| %-8s| %-21s| Rp%-14.2f| %s%n", (i + 1), jenisProduk, namaProduk, hargaNormal, hargaDiskonStr);
        }
        System.out.println("===============================================================================");
    }
    
   
    public void prosesPembelian() {
        try {
            System.out.print("\nSilakan pilih nomor produk yang ingin dibeli: ");
            int nomorProduk = input.nextInt();

            if (nomorProduk < 1 || nomorProduk > daftarProduk.length) {
                System.out.println("Nomor produk tidak valid!");
                return; 
            }

            System.out.print("Beli berapa banyak: ");
            int jumlah = input.nextInt();

            if (jumlah <= 0) {
                System.out.println("Jumlah pembelian harus lebih dari 0!");
                return;
            }

            Produk produkDipesan = daftarProduk[nomorProduk - 1];
            double hargaSatuan = produkDipesan.getHarga();
            

            if (produkDipesan instanceof IDapatDiskon) {
                hargaSatuan = ((IDapatDiskon) produkDipesan).hitungHargaSetelahDiskon();
                System.out.println("Anda mendapatkan harga diskon!");
            }

            double totalHarga = hargaSatuan * jumlah;

            System.out.println("\n--- STRUK PEMBELIAN ---");
            System.out.println("Produk       : " + produkDipesan.getNama());
            System.out.println("Jumlah       : " + jumlah);
            System.out.println("Harga Satuan : Rp" + String.format("%.2f", hargaSatuan));
            System.out.println("-------------------------");
            System.out.println("Total Harga  : Rp" + String.format("%.2f", totalHarga));
            System.out.println("-------------------------");

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Harap masukkan angka.");
            input.next();
        }
    }
    
    public void tutupScanner() {
        this.input.close();
    }
}