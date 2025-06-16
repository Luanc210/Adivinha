package Jogodeadvinhacao;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final Ranking ranking = new Ranking();
    private int numeroSecreto;
    private int tentativas;

    public void iniciar() {
        numeroSecreto = random.nextInt(100) + 1;
        tentativas = 0;

        System.out.println("=== Bem-vindo ao Jogo de Adivinhação ===");
        System.out.println("Tente adivinhar o número entre 1 e 100!");

        while (true) {
            System.out.print("Digite seu palpite: ");
            int palpite = scanner.nextInt();
            tentativas++;

            if (palpite == numeroSecreto) {
                System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas.");
                break;
            } else if (palpite < numeroSecreto) {
                System.out.println("O número é MAIOR.");
            } else {
                System.out.println("O número é MENOR.");
            }
        }

        scanner.nextLine();
        System.out.print("Digite seu nome para o ranking: ");
        String nome = scanner.nextLine();

        ranking.salvar(nome, tentativas);
        ranking.exibir();
    }
}
