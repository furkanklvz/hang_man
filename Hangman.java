package hangMan;

import java.util.Scanner;

public class Hangman {

	private static int count = 0;	//Tahmin sayacý

	public static void main(String[] args) { 
		category ctgry = new category();
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir Kategori Seçin");	//Bu kýsýmýmýzda oyuncumuzdan bir kategori seçmesini istiyoruz.
		System.out.println("------------------");	//Kategori seçimimizi 4 kategori olarak " þehir, nesne, hayvan ve bitki olarak 
		System.out.println("Þehir(1)");				// belirledik.
		System.out.println("------------------");
		System.out.println("Nesne(2)");
		System.out.println("------------------");
		System.out.println("Hayvan(3)");
		System.out.println("------------------");
		System.out.println("Yiyecek(4)");
		System.out.println("------------------");
		int category1 = sc.nextInt();	// Bu kýsýmda ise oyuncudan seçmek istediði kategori için karþýsýndaki rakamý girmesini istiyoruz. 
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");	
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		switch (category1) { //Burada ise oyuncunun girmiþ olduðu rakama göre bir switch döngüsü oluþturduk.
		case 1:
			ctgry.word(1);	//Oyuncunun seçtiði kategoriye göre o kelimenin belirleneceði metoda giden bir komut oluþturduk.
			break;			//Bu word metodu category isimli diðer class'ýmýzda yer alýyor.
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

					//Kelime  belirlendikten sonra oyuncudan harf istemek için bir while döngüsu oluþturduk.
			System.out.println("Bir harf tahmin et..");
			System.out.println("------------------");
			System.out.println(ctgry.asteriks);
			System.out.println("------------------");
			String guess = sc.next(); // Burada oyuncudan istediðimiz kelimeyi gizli bir þekilde konsola yansýtýyoruz.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			hang(guess); 			// Bu while döngüsünün sonunda ise hang metodu devreye giriyor. Bu hang metodunun amacý
									// oyuncunun girdiði harfin doðru kelimede yer alýp almadýðýný kontrol etmek.

		}
		sc.close();
	}

	public static void hang(String guess) {
		category ctgry = new category();
		String newasteriks = "";		//Hang metodumuz burasý. Bu metodda newasterisk adýnda boþ bir deðiþken oluþturuyoruz.
		for (int i = 0; i < ctgry.word.length(); i++) {	//Bu for döngüsü oyuncunun girdiði harfi teker teker tüm indekslerle
			if (ctgry.word.charAt(i) == guess.charAt(0)) {	//karþýlaþtýrýyor.
				newasteriks += guess.charAt(0);				//Eðer iþlemledli indeks oyuncunun girdiði harfle ayný ise 
															//newasteriks deðiþkeninin  bir sonraki indeksine bulunan harfi ekliyor.
				
			} else if (ctgry.asteriks.charAt(i) != '*') {	//Eðer sýradaki ineks yýldýz deðilse o harf daha önce bulunmuþ demektir. 
				newasteriks += ctgry.word.charAt(i);		//Ve o harf newasterikse tekrar eklenir. 
			
			} else {										//Son ihtimal ise eðer harf indeksteki harf ile ayný deðilse yanlýþ
				newasteriks += "*";							//tahmindir. Newasteriksin sýradaki indeksine yýldýz eklenir.
			}
		}

		if (ctgry.asteriks.equals(newasteriks)) {	//Bu if komutlarýnýn amacý ise asteriks ile newasteriksi karþýlaþtýrýp 
															//tahminin doðru ya da yanlýþ olup olmadýðýný belirleyip eðer yanlýþsa
															//asýlan adamýn görsellerini çaðýrýyor.
														
															//Eðer asteriks ile newasteriks ayný ise yeni harf eklenmemiþtir.
															//Ve bu da yapýlan tahminin yanlýþ olduðunu gösteriyor.
															//Daha sonra tahmin sayacý bir artýyor
			count++;										
			System.out.println("Yanlýþ tahmin !! Tekrar dene !!");//Ekrana yanlýþ tahmin yazýsýný basýyor
			hangmanImage();											//ve asýlan adamýn görselini çaðýrýyor
			System.out.println("Kalan Tahmin Sayýsý: " + (7 - count));
		} else {										//Eðer asteriks ile newasteriks farklý ise tahmin edilen harf doðrudur ve 
			System.out.println("Doðru Tahmin !!");			//tahmin sayacý artmaz.
			hangmanImage();
			System.out.println("Kalan Tahmin Sayýsý: " + (7 - count));
			ctgry.asteriks = newasteriks;					//ve new asteriksimiz asýl asteriksimize tanýmlanýr.
		}
		if (ctgry.asteriks.equals(ctgry.word)) {
			//Ve eðer asteriks kelimemiz doðru kelimeyle eþitlenirse doðru kelime bulunmuþ
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//demektir ve oyuncu oyunu kazanýr.
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			hangmanImage();
			System.out.println("Doðru cevap!! Kazandýn!! \nDoðru cevap:  " + ctgry.word);
		
			
			

		}
	}

	public static void hangmanImage() {		//Buradan hangmanimage metoduna geçiyoruz. Tahmin sayacý kaç ise ona göre bir asýlan adam 
		category ctgry = new category();	//görseli gönderiyor.
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
		if (count == 7) {						//Eðer tahmin sayacý 7 ye ulaþtýysa oyuncunun tahmin hakký biter ve oyunu kaybeder.
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
			System.out.println("OYUN BÝTTÝ! KAYBETTÝN..\nDoðru kelime: " + ctgry.word);//En sonda ise ekrana doðru kelime yazýlýr.

		}
	}
}