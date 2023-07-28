import java.util.Locale;
import java.util.Scanner;

public class Atletas {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String sexo, nome, maisAlto = "";
		int N, i, totalM = 0, totalF = 0;
		double peso, altura, mediaPeso, pctH, mediaAltF = 0, altM = 0, altF = 0, pesoM = 0, pesoF = 0, maiorAltura = 0;

		System.out.print("Qual a quantidade de atletas? ");
		N = sc.nextInt();

		for (i = 0; i < N; i++) {
			System.out.println("Digite os dados do atleta número " + (i + 1) + ":");
			System.out.print("Nome: ");
			nome = sc.next();
			sc.nextLine();
			System.out.print("Sexo: ");
			sexo = sc.next().toUpperCase();

			while (!sexo.equals("M") && !sexo.equals("F")) {
				System.out.println("Valor inválido! Favor digitar F ou M: ");
				sexo = sc.next().toUpperCase();
			}

			System.out.print("Altura (em metros): ");
			altura = sc.nextDouble();
			while (altura <= 0) {
				System.out.println("Valor inválido! Favor digitar um número positivo: ");
				altura = sc.nextDouble();
			}

			System.out.print("Peso: ");
			peso = sc.nextDouble();
			while (peso <= 0) {
				System.out.println("Valor inválido! Favor digitar um número positivo: ");
				peso = sc.nextDouble();
			}

			if (altura > maiorAltura) {
				maiorAltura = altura;
				maisAlto = nome;
			}

			if (sexo.equals("M")) {
				totalM++;
				altM += altura;
				pesoM += peso;
			} else {
				totalF++;
				altF += altura;
				pesoF += peso;
			}

		}

		mediaPeso = (pesoM + pesoF) / N;
		pctH = (totalM * 100.0) / N;
		if (totalF > 0) {
			mediaAltF = altF / totalF;
		}

		System.out.println("RELATÓRIO: ");
		System.out.printf("Peso médio dos atletas: %.2f%n", mediaPeso);
		System.out.printf("Atleta mais alto: %s%n", maisAlto);
		System.out.printf("Porcentagem de homens: %.1f%%%n", pctH);
		if (altF == 0) {
			System.out.println("Não há mulheres cadastradas");
		} else {
			System.out.printf("Altura média das mulheres: %.2f%n", mediaAltF);
		}

		sc.close();
	}
}
