package Jogodeadvinhacao;

import java.io.*;

public class Ranking {
    private static final String RANKING_FILE = "ranking.txt";

    public void salvar(String nome, int tentativas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RANKING_FILE, true))) {
            writer.write(nome + " - " + tentativas + " tentativas");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o ranking.");
        }
    }

    public void exibir() {
        System.out.println("\n=== Ranking de Jogadores ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(RANKING_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Ranking vazio ou erro ao ler o arquivo.");
        }
    }
}
