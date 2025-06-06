import java.io.*;
import java.util.*;

    public class Ranking {
        private static final String ARQUIVO = "ranking.txt";
        private static final int MAX_JOGADORES = 10;

        // Salva o jogador no ranking, mantendo apenas os 10 melhores
        public static void salvarJogador(Player novoJogador) {
            List<Player> ranking = carregarRanking(); // carrega do arquivo
            ranking.add(novoJogador); // adiciona a nova partida

            // Ordena pela pontuação (decrescente)
            ranking.sort((a, b) -> b.getPontuacao() - a.getPontuacao());

            // Garante que só os 10 melhores fiquem na lista
            if (ranking.size() > MAX_JOGADORES) {
                ranking = ranking.subList(0, MAX_JOGADORES);
            }

            // Regrava o arquivo com a lista atualizada
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
                for (Player j : ranking) {
                    bw.write(j.toString());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Carrega os jogadores do arquivo
        public static List<Player> carregarRanking() {
            List<Player> lista = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    lista.add(Player.fromString(linha));
                }
            } catch (IOException e) {
                // Não precisa tratar erro se o arquivo não existir
            }

            return lista;
        }

        // Exibe o ranking no console
        public static void exibirRanking() {
            List<Player> ranking = carregarRanking();
            System.out.println("\n===== RANKING TOP 10 =====");
            int pos = 1;
            for (Player j : ranking) {
                System.out.println(pos + "º " + j.getNome() + " - " + j.getPontuacao() + " pts");
                pos++;
            }
        }
    }

}
