import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        int satir, sutun, puan = 0;
        boolean kontrol = true; //While döngüsü ile oyunun bitip bitmediğini kontrol etmek için bir boolean kontrol ifadesi tanımladım
        Scanner sayiGiris = new Scanner(System.in);
        Random rnd = new Random();
        System.out.print("Lütfen satır sayısını giriniz: ");
        satir = sayiGiris.nextInt();
        System.out.print("Lütfen sütun sayısını giriniz: ");
        sutun = sayiGiris.nextInt();
        int[][] dharita = new int[satir][sutun];
        //Zorluk seviyesi ayarlama kısmı
        System.out.println("Lütfen 20 ile 80 arasında bir zorluk derecesi giriniz.");
        int zorlukDerecesi;
        zorlukDerecesi=sayiGiris.nextInt();
        int zorluk=((satir*sutun)*zorlukDerecesi)/100;//Toplam blok sayısını zorluk derecesine oranladım ve zorluk değişkenine atadım.

        //O dizisi oluşturma kısmı. Tamamını 0'lardan oluşturuyorum ki içine zorluk kadar içine 1 atayabileyim.
        for (int q = 0; q < satir; q++) {
            for (int w = 0; w < sutun; w++) {//tüm diziyi sıfırlardan oluşturuyorum
                dharita[q][w]=0;
            }
        }
        //diziye kullanıcıdan gelen zorluk kadar 1 atıyorum
        //satırları ve sütunları tek tek gezerek içine zorluk değeri kaç hesaplandıysa o kadar döngüye sokup 1 atıyorum
            for (int i = 0; i < satir; i++) {
                int c = rnd.nextInt(0, satir);
                for (int j = 0; j < sutun; j++) {
                    int v = rnd.nextInt(0, sutun);
                    for (int m = 0; m <= zorluk; m++) {
                        dharita[c][v] = 1;
                    }
                }
            }

        String[][] yildiz = new String[satir][sutun]; //Kullanıcıya yıldız gösterimini çıkarmak için string dizi açtım
                                                     //String olduğundan ötürü mayın olmayan yere sıfır yazdıramadığım için O harfini yazdırdım.

        //Yıldız haritası için kullanıcıdan gelen sütun ve satır sayısına eş yeni bir yıldız dizisi oluşturuyorum.
        for (int g = 0; satir > g; g++) {
            for (int h = 0; sutun > h; h++) {
                yildiz[g][h] = " * ";
            }
        }
        //Oyun ekranı kısmı:oyunda oluşturulan diziyi kullanıcıya gösteriyorum
        for (int q = 0; q < satir; q++) {
            for (int w = 0; w < sutun; w++) {
                System.out.print(yildiz[q][w]);
            }
            System.out.println();
        }
        System.out.println("OYUN BAŞLASIN");

        //Oyun mekanizması buradaki kod kısmında çalışıyor
        while (kontrol) {
            System.out.println("Lütfen oyun içinde istediğiniz satır numarasını giriniz");
            int secilensatır = sayiGiris.nextInt();
            System.out.println("Lütfen oyun içinde istediğiniz sutün numarasını giriniz");
            int secilensutun = sayiGiris.nextInt();


            //Eğer mayına denk gelirse burası çalışıyor
            if (dharita[secilensatır][secilensutun] == 1) {
                kontrol = false;//oyunu bitirmek ve while döngüsüne tekrar sokmamak için kontrol ifadesini 0 yapıyorum.
                for (int q = 0; q < satir; q++) {
                    for (int w = 0; w < sutun; w++) {
                        System.out.print(dharita[q][w]+"  ");//oyun bittiği için kullanıcıya oyun haritasının tamamını gösteriyorum 0 ve 1'lerin yerlerini görsün diye.
                    }
                    System.out.println();
                }
                System.out.println("Oyunu kaybettiniz...... Puanınınız=" + puan);

            } else {
                //Eğer mayına denk gelmezse burası çalışıyor
                //Oyundaki seçtiği kısmda mayın olmadığından ötürü ekrana yaptığı hamlelerin yerine O yazdırıyorum
                yildiz[secilensatır][secilensutun] = " 0 ";
                puan = puan + 1;//her bir mayın olmayan bölgeyi bulduğunda puanına 1 ekliyorum.
                System.out.println("Tebrikler 1 puan şimdi sıradaki hamleni yap");
                for (int q = 0; q < satir; q++) {
                    for (int w = 0; w < sutun; w++) {
                        System.out.print(yildiz[q][w]+"  ");//oyun ekranını kullanıcıya tekrar gösteriyorum
                    }
                    System.out.println();
                }
            }
        }
    }
}

//Ademcan İyik 203908069 Algoritma II Mayın Tarlası Projesi





