package hangMan;

public class category {
	public static String[] words;	//Burada kullanacaðýmýz deðiþkenleri tanýmladýk.
	public static String word;		//Bu word metodunun amacý kategoriye göre listelediðimiz kelimelerden birinin 
	public static String asteriks;	//rastgele seçilmesini saðlamak.
	public static String[] words2;
	public static String word2;
	public static String asteriks2;
	public static String[] words3;
	public static String word3;
	public static String asteriks3;
	public static String[] words4;
	public static String word4;
	public static String asteriks4;

	public static void word(int i) {
		switch (i) {	//Bu word metodunda bir switch metodumuz daha bulunuyor. Oyuncunun seçtiði rakama göre switch döngüsü çalýþýyor.
		case 1:			//Örnek olarak eðer oyuncu þehir seçtiyse bu switch döngüsünden rastgele bir kelime atanýyor.
				String[] words = { "ankara", "istanbul", "bursa", "antalya", "ordu", "nevþehir", "malatya", "aydýn",
					"diyarbakýr", "mersin", "muðla", "giresun", "trabzon", "denizli", "sivas"
					, "bolu", "düzce", "adýyaman", "kocaeli", "kýrklareli", "kýrþehir", "artvin"};
						//Bu words arrayi önceden belirlediðimiz kelimeleri barýndýrýyor.
			word = words[(int) (Math.random() * words.length)];
						//Bu komut ise word deðiþkenine seçilen kelimeyi tanýmlýyor.
			asteriks = new String(new char[word.length()]).replace("\0", "*");
						//Bu komut ise atanan kelimenin uzunluðu kadar yýldýz ekliyor.
			break;
					
			case 2:
			String[] words2 = { "bilgisayar", "telefon", "gardýrop", "kanepe", "ayakkabý", "gözlük", "çanta",
					"sürahi", "bardak", "küpe", "oklava", "yazýcý", "klavye", "projeksiyon", "lamba"
					, "elbise", "yorgan", "termos", "eldiven", "çerçeve", "kulaklýk", "tesbih"};
			word2 = words2[(int) (Math.random() * words2.length)];

			asteriks2 = new String(new char[word2.length()]).replace("\0", "*");
			break;
		case 3:
			String[] words3 = { "zebra", "ornitorenk", "timsah", "köpek", "buzaðý", "kaplumbaða", "kanarya", "sýrtlan"
					, "eþek", "kertenkele", "zürafa", "hipopotam", "çekirge", "kartal", "rakun", "porsuk"
					, "antilop", "jaguar", "fil", "köstebek", "karga", "yýlan", "geyik", "karides"};
			word3 = words3[(int) (Math.random() * words3.length)];
			asteriks3 = new String(new char[word3.length()]).replace("\0", "*");
			break;
		case 4:
			String[] words4 = { "supangle", "armut", "lazanya", "kebap", "ananas", "patlýcan", "kayýsý", "mantý", "marul"
					, "dolma", "kivi", "börek", "brokoli", "patates", "soðan", "sarýmsak", "revani"
					, "puding", "trileçe", "peynir", "zeytin", "sucuk", "yumurta", "omlet", "krep"};
			word4 = words4[(int) (Math.random() * words4.length)];
			asteriks4 = new String(new char[word4.length()]).replace("\0", "*");
			break;
		}
		if (i == 2) {
			asteriks = asteriks2;
			words = words2;
			word = word2;
		} else if (i == 3) {
			asteriks = asteriks3;
			words = words3;
			word = word3;
		} else if (i == 4) {
			asteriks = asteriks4;
			words = words4;
			word = word4;
		}

	}

}
