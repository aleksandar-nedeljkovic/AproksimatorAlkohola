package aproksimator;

import java.util.Scanner;

public class AproksimatorAlkohola {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodosli u alko aproksimator 9000!");
		
		System.out.print("Unsesite vasu tezinu (kg): ");
		double kg = sc.nextDouble();
		
		System.out.print("Unesite vas pol (ako ste musko unesite 0, ako ste zensko unesite 1): ");
		int pol = sc.nextInt();
		
		while (pol != 0 && pol != 1) {
			System.err.print("Pogresan unos, molim pokusajte ponovo: ");
			pol = sc.nextInt();
		}
		
		double r = 0;
		if (pol == 0)
			r = 0.68;
		if (pol == 1)
			r = 0.55;
		
		double procenat;
		double suma = 0;

			System.out.print("Unesite id pica koje ste pili ili -1 ako ste vec uneli sva pica koja ste popili: ");
			int id = sc.nextInt();
			while (id != -1) {
			switch(id) {
				case 1: procenat = 0.5; break;
				case 2: procenat = 0.4; break;
				case 3: procenat = 0.047; break;
				case 4: procenat = 0.11; break;
				default: 
					System.out.println("Greska, zeljeni id nije u bazi podataka. Pokusajte ponovo");
					id=sc.nextInt();
					continue;
			}
			System.out.println("Unesite kolicinu popijenog pica (ml): ");
			double kol = sc.nextDouble();
			suma += kol*procenat;
			System.out.print("Unesite id pica koje ste pili ili -1 ako ste vec uneli sva pica koja ste popili: ");
			id = sc.nextInt();
		}
		
		double BAC = suma / (kg * 1000 * r) * 1000;
		
		
		String naziv = "";
		String kazna = "";
		int poeni = 0;
		int zabrana = 0;
		
		if (BAC > 0.00 && BAC <= 0.20) {
			naziv = "Dozvoljena alkoholisanost";
			kazna = "Bez kazne";
			poeni = 0;
			zabrana = 0;
		}
		
		if(BAC > 0.21 && BAC <= 0.5) {
			naziv = "Umerena alkoholisanost";
			kazna = "10.000 din";
			poeni = 0;
			zabrana = 0;
			
		}
		else if(BAC > 0.51 && BAC <= 0.8) {
			naziv = "Srednja alkoholisanost";
			kazna = "10.000 - 20.000 din";
			poeni = 6;
			zabrana = 3;
			
		}
		else if(BAC > 0.81 && BAC <= 1.2) {
			naziv = "Visoka alkoholisanost";
			kazna = "20.000 - 40.000 din";
			poeni = 8;
			zabrana = 4;
			
		}
		else if(BAC>1.21 && BAC<=1.6) {
			naziv = "Teska alkoholisanost";
			kazna = "100.000 - 120.000 din";
			poeni = 9;
			zabrana = 8;
			
		}
		else if(BAC>1.61 && BAC<=2.0) {
			naziv = "Veoma teska alkoholisanost";
			kazna = "100.000 - 120.000 din";
			poeni = 14;
			zabrana = 8;
			
		}
		else if(BAC>2.0) {
			naziv = "Potpuna alkoholisanost";
			kazna = "30 - 60 dana zatvora";
			poeni = 15;
			zabrana = 9;
		}
		
		System.out.println();
		System.out.println("-----------------------------");
		System.out.printf("BAC: " + BAC, naziv);
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("Kazna: " + kazna);
		System.out.println("Kazneni poeni: " + poeni);
		System.out.println("Zabrana vožnje: " + zabrana + " meseci");
		System.out.println("-----------------------------");
	
	}

}
