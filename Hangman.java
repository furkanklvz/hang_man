package hangMan;

import java.util.Scanner;

public class Hangman {

	private static int count = 0;	//Tahmin sayac�

	public static void main(String[] args) { 
		category ctgry = new category();
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir Kategori Se�in");	//Bu k�s�m�m�zda oyuncumuzdan bir kategori se�mesini istiyoruz.
		System.out.println("------------------");	//Kategori se�imimizi 4 kategori olarak " �ehir, nesne, hayvan ve bitki olarak 
		System.out.println("�ehir(1)");				// belirledik.
		System.out.println("------------------");
		System.out.println("Nesne(2)");
		System.out.println("------------------");
		System.out.println("Hayvan(3)");
		System.out.println("------------------");
		System.out.println("Yiyecek(4)");
		System.out.println("------------------");
		int category1 = sc.nextInt();	// Bu k�s�mda ise oyuncudan se�mek istedi�i kategori i�in kar��s�ndaki rakam� girmesini istiyoruz. 
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");	
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		switch (category1) { //Burada ise oyuncunun girmi� oldu�u rakama g�re bir switch d�ng�s� olu�turduk.
		case 1:
			ctgry.word(1);	//Oyuncunun se�ti�i kategoriye g�re o kelimenin belirlenece�i metoda giden bir komut olu�turduk.
			break;			//Bu word metodu category isimli di�er class'�m�zda yer al�yor.
		case 2:
			ctgry.word(2);
			break;
		case 3:
			ctgry.word(3);
			break;
		case 4:
			ctgry.word(4);
			break;
		}

		while (count < 7 && ctgry.asteriks.contains("*")) {

					//Kelime  belirlendikten sonra oyuncudan harf istemek i�in bir while d�ng�su olu�turduk.
			System.out.println("Bir harf tahmin et..");
			System.out.println("------------------");
			System.out.println(ctgry.asteriks);
			System.out.println("------------------");
			String guess = sc.next(); // Burada oyuncudan istedi�imiz kelimeyi gizli bir �ekilde konsola yans�t�yoruz.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			hang(guess); 			// Bu while d�ng�s�n�n sonunda ise hang metodu devreye giriyor. Bu hang metodunun amac�
									// oyuncunun girdi�i harfin do�ru kelimede yer al�p almad���n� kontrol etmek.

		}
		sc.close();
	}

	public static void hang(String guess) {
		category ctgry = new category();
		String newasteriks = "";		//Hang metodumuz buras�. Bu metodda newasterisk ad�nda bo� bir de�i�ken olu�turuyoruz.
		for (int i = 0; i < ctgry.word.length(); i++) {	//Bu for d�ng�s� oyuncunun girdi�i harfi teker teker t�m indekslerle
			if (ctgry.word.charAt(i) == guess.charAt(0)) {	//kar��la�t�r�yor.
				newasteriks += guess.charAt(0);				//E�er i�lemledli indeks oyuncunun girdi�i harfle ayn� ise 
															//newasteriks de�i�keninin  bir sonraki indeksine bulunan harfi ekliyor.
				
			} else if (ctgry.asteriks.charAt(i) != '*') {	//E�er s�radaki ineks y�ld�z de�ilse o harf daha �nce bulunmu� demektir. 
				newasteriks += ctgry.word.charAt(i);		//Ve o harf newasterikse tekrar eklenir. 
			
			} else {										//Son ihtimal ise e�er harf indeksteki harf ile ayn� de�ilse yanl��
				newasteriks += "*";							//tahmindir. Newasteriksin s�radaki indeksine y�ld�z eklenir.
			}
		}

		if (ctgry.asteriks.equals(newasteriks)) {	//Bu if komutlar�n�n amac� ise asteriks ile newasteriksi kar��la�t�r�p 
															//tahminin do�ru ya da yanl�� olup olmad���n� belirleyip e�er yanl��sa
															//as�lan adam�n g�rsellerini �a��r�yor.
														
															//E�er asteriks ile newasteriks ayn� ise yeni harf eklenmemi�tir.
															//Ve bu da yap�lan tahminin yanl�� oldu�unu g�steriyor.
															//Daha sonra tahmin sayac� bir art�yor
			count++;										
			System.out.println("Yanl�� tahmin !! Tekrar dene !!");//Ekrana yanl�� tahmin yaz�s�n� bas�yor
			hangmanImage();											//ve as�lan adam�n g�rselini �a��r�yor
			System.out.println("Kalan Tahmin Say�s�: " + (7 - count));
		} else {										//E�er asteriks ile newasteriks farkl� ise tahmin edilen harf do�rudur ve 
			System.out.println("Do�ru Tahmin !!");			//tahmin sayac� artmaz.
			hangmanImage();
			System.out.println("Kalan Tahmin Say�s�: " + (7 - count));
			ctgry.asteriks = newasteriks;					//ve new asteriksimiz as�l asteriksimize tan�mlan�r.
		}
		if (ctgry.asteriks.equals(ctgry.word)) {
			//Ve e�er asteriks kelimemiz do�ru kelimeyle e�itlenirse do�ru kelime bulunmu�
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//demektir ve oyuncu oyunu kazan�r.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			hangmanImage();
			System.out.println("Do�ru cevap!! Kazand�n!! \nDo�ru cevap:  " + ctgry.word);
		
			
			

		}
	}

	public static void hangmanImage() {		//Buradan hangmanimage metoduna ge�iyoruz. Tahmin sayac� ka� ise ona g�re bir as�lan adam 
		category ctgry = new category();	//g�rseli g�nderiyor.
		if (count == 1) {

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {

			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {

			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {

			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {

			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {

			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {						//E�er tahmin sayac� 7 ye ula�t�ysa oyuncunun tahmin hakk� biter ve oyunu kaybeder.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("OYUN B�TT�! KAYBETT�N..\nDo�ru kelime: " + ctgry.word);//En sonda ise ekrana do�ru kelime yaz�l�r.

		}
	}
}