import java.io.*;
import java.util.*;
public class ArquivoPlayer {
   private String arquivo = "players.txt";
   Scanner sc = new Scanner(System.in);
    public ArquivoPlayer(String arquivo) {
        this.arquivo = arquivo;
    }

    public ArquivoPlayer() {
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }



    public void cadastraPlayer() {
        System.out.print("Digite o nome do player: ");
        String nome = sc.nextLine();
        // Ranking será atribuido automaticamente
        Player p = new Player(nome);
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(p.getNome() + "----"/*ranking*/);
            bw.newLine();
            System.out.println("Player cadastrado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o player: " + e.getMessage());
        }
    }

    public void editaPlayer() {
        System.out.print("Digite o nome do player a editar: ");
        String nomeEditado = sc.nextLine();
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                for(int i =0; i < arquivo.length(); i++){
                    if (dados[i].equalsIgnoreCase(nomeEditado)) {
                        System.out.print("Novo nome: ");
                        String novoNome = sc.nextLine();
                        System.out.print("Novo ranking: ");
                        String novoRanking = sc.nextLine();
                        linhas.add(novoNome + ";" + novoRanking);
                        encontrado = true;
                    } else {
                        linhas.add(linha);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        if (encontrado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
                for (String linha : linhas) {
                    bw.write(linha);
                    bw.newLine();
                }
                System.out.println("Player editado com sucesso.");
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Player não encontrado.");
        }
    }

    public void verPlayers() {
        int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha="";
            System.out.println("\n====Lista de Players====");
            do{
                String[] dados = linha.split(";");
                System.out.println("Nome: " + dados[i] + " | Ranking: " + dados[i]);
                System.out.print("\n");
                i++;
            } while ((linha = br.readLine()) != null);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
