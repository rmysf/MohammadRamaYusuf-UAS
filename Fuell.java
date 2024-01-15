import java.util.ArrayList;
import java.util.Random;

public class Fuell {
    public static void main(String[] args) throws InterruptedException {
        // Inisialisasi stok bahan bakar
        ArrayList<Integer> stok = new ArrayList<>();
        stok.add(2000); // Pertalite
        stok.add(2500); // Pertamax
        stok.add(1700); // Pertamax Turbo
        stok.add(2800); // Pertadex

        // ArrayList untuk menyimpan penjualan
        ArrayList<ArrayList<Integer>> penjualan = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            penjualan.add(new ArrayList<>());
        }

        // Looping random setiap 3 detik
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                int penjualanHariIni = random.nextInt(501); // Misal, maksimal 500 kg/hari
                penjualan.get(j).add(penjualanHariIni);

                // Kurangi stok berdasarkan penjualan
                stok.set(j, stok.get(j) - penjualanHariIni);
            }

            // Tunggu 3 detik sebelum lanjut ke interval waktu berikutnya
            Thread.sleep(3000);
        }

        // Tampilkan total penjualan dan sisa stok
        for (int j = 0; j < 4; j++) {
            System.out.println("Jenis BBM " + (j + 1) + ":");
            System.out.println("Total Penjualan: " + getTotal(penjualan.get(j)) + " kg");
            System.out.println("Sisa Stok: " + stok.get(j) + " kg");
            System.out.println();
        }
    }

    // Method untuk menghitung total penjualan
    private static int getTotal(ArrayList<Integer> list) {
        int total = 0;
        for (int value : list) {
            total += value;
        }
        return total;
    }
}