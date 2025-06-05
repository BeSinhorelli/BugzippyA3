import javax.swing.*;
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

    // Cadastrar um novo player

    public void cadastraPlayer() {
        // Verifica se o arquivo já existe
        File arq = new File(arquivo);

        if (!arq.exists()) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado. Escolha onde deseja salvá-lo.");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Escolha o diretório para salvar o arquivo");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int escolha = fileChooser.showSaveDialog(null);

            if (escolha == JFileChooser.APPROVE_OPTION) {
                File diretorio = fileChooser.getSelectedFile();
                // Cria o caminho completo com o nome padrão do arquivo
                this.arquivo = diretorio.getAbsolutePath() + File.separator + "players.txt";
                arq = new File(this.arquivo);
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.");
                return;
            }
        }

        // Coleta dados do player
        System.out.print("Digite o nome do player: ");
        String nome = sc.nextLine();
        //ranking será preenchido automaticamente

        Player p = new Player(nome /*ranking*/);

        // Grava no arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arq, true))) {
            bw.write(p.getNome() + " | "/*p.getRanking()*/);
            bw.newLine();
            System.out.println("Player cadastrado com sucesso em: " + arq.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar o player: " + e.getMessage());
        }
    }

    // Editar um player já existente
    public void editaPlayer() {
        System.out.print("Digite o nome do player a editar: ");
        String nomeEditado = sc.nextLine();
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length > 0 && dados[0].equalsIgnoreCase(nomeEditado)) {
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

    // Visualizar todos os players
    public void verPlayers() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            System.out.println("\n==== Lista de Players ====");
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) {
                    System.out.println("Nome: " + dados[0] + " | Ranking: " + dados[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
