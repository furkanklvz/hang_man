package hangMan;

public class category {
	public static String[] words;	//Burada kullanaca��m�z de�i�kenleri tan�mlad�k.
	public static String word;		//Bu word metodunun amac� kategoriye g�re listeledi�imiz kelimelerden birinin 
	public static String asteriks;	//rastgele se�ilmesini sa�lamak.
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
		switch (i) {	//Bu word metodunda bir switch metodumuz daha bulunuyor. Oyuncunun se�ti�i rakama g�re switch d�ng�s� �al���yor.
		case 1:			//�rnek olarak e�er oyuncu �ehir se�tiyse bu switch d�ng�s�nden rastgele bir kelime atan�yor.
				String[] words = { "ankara", "istanbul", "bursa", "antalya", "ordu", "nev�ehir", "malatya", "ayd�n",
					"diyarbak�r", "mersin", "mu�la", "giresun", "trabzon", "denizli", "sivas"
					, "bolu", "d�zce", "ad�yaman", "kocaeli", "k�rklareli", "k�r�ehir", "artvin"};
						//Bu words arrayi �nceden belirledi�imiz kelimeleri bar�nd�r�yor.
			word = words[(int) (Math.random() * words.length)];
						//Bu komut ise word de�i�kenine se�ilen kelimeyi tan�ml�yor.
			asteriks = new String(new char[word.length()]).replace("\0", "*");
						//Bu komut ise atanan kelimenin uzunlu�u kadar y�ld�z ekliyor.
			break;
					
			case 2:
			String[] words2 = { "bilgisayar", "telefon", "gard�rop", "kanepe", "ayakkab�", "g�zl�k", "�anta",
					"s�rahi", "bardak", "k�pe", "oklava", "yaz�c�", "klavye", "projeksiyon", "lamba"
					, "elbise", "yorgan", "termos", "eldiven", "�er�eve", "kulakl�k", "tesbih"};
			word2 = words2[(int) (Math.random() * words2.length)];

			asteriks2 = new String(new char[word2.length()]).replace("\0", "*");
			break;
		case 3:
			String[] words3 = { "zebra", "ornitorenk", "timsah", "k�pek", "buza��", "kaplumba�a", "kanarya", "s�rtlan"
					, "e�ek", "kertenkele", "z�rafa", "hipopotam", "�ekirge", "kartal", "rakun", "porsuk"
					, "antilop", "jaguar", "fil", "k�stebek", "karga", "y�lan", "geyik", "karides"};
			word3 = words3[(int) (Math.random() * words3.length)];
			asteriks3 = new String(new char[word3.length()]).replace("\0", "*");
			break;
		case 4:
			String[] words4 = { "supangle", "armut", "lazanya", "kebap", "ananas", "patl�can", "kay�s�", "mant�", "marul"
					, "dolma", "kivi", "b�rek", "brokoli", "patates", "so�an", "sar�msak", "revani"
					, "puding", "trile�e", "peynir", "zeytin", "sucuk", "yumurta", "omlet", "krep"};
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
