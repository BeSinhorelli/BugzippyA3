import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Nivel1 {
    public Nivel1() {
    }
    public void chamaNivel1() {
        String d = "";
        try {
            String msg = "perguntas";
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Escolha o diretório para salvar o arquivo");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File selectedDir = fileChooser.getSelectedFile();
                d = selectedDir.getAbsolutePath();
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.");
                return;
            }

            // Garante que o caminho termina com separador
            if (!d.endsWith(File.separator)) {
                d += File.separator;
            }

            msg += ".txt";
            File arquivoDestino = new File(d + msg);
            File arquivoOrigem = new File("src/perguntas.txt");
            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOrigem));
                    BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoDestino))
            ) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    bw.write(linha);
                    bw.newLine();
                }

                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso em:\n" + arquivoDestino.getAbsolutePath());

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao copiar o conteúdo: " + e.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro geral: " + e.getMessage());
        }
    }

    public void enunciadoN1() {
        ArrayList<Explicacao> explicacao = ArquivoExplicacao.carregarExplicacao("C:\\Users\\1292510067\\IdeaProjects\\BugzippyA3\\src\\explicacao.txt");

        ArrayList<Explicacao> explicacaoNivel1 = FiltragemExplicacao.sortearExplicacaoPorNivel(explicacao, 1);

        String linha = "";
        String[] partes = linha.split(";");
        int nivel = Integer.parseInt(partes[0]);
        Explicacao ex = new Explicacao(nivel, partes[1]);


        System.out.println(ex.getExplicacao());
        System.out.println();

    }

    public void perguntasNivel1() {
        ArrayList<Perguntas> perguntas = Arquivo.carregarPerguntas("C:\\Users\\1292510067\\IdeaProjects\\BugzippyA3\\src\\perguntas.txt");

        ArrayList<Perguntas> perguntasNivel1 = Filtragem.sortearPerguntasPorNivel(perguntas, 1);

        for (Perguntas p : perguntasNivel1) {
            System.out.println(p.getEnunciado());
            System.out.println(p.getAlternativa1());
            System.out.println(p.getAlternativa2());
            System.out.println(p.getAlternativa3());
            System.out.println(p.getAlternativa4());

            Scanner scanner = new Scanner(System.in);
            int respostaJogador = -1;

            // Validar entrada numérica
            while (true) {
                try {
                    respostaJogador = Integer.parseInt(scanner.nextLine().trim());
                    if (respostaJogador >= 1 && respostaJogador <= 4) {
                        break;
                    } else {
                        System.out.print("Número inválido. Digite 1, 2, 3 ou 4: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Entrada inválida. Digite um número (1 a 4): ");
                }
            }

            // Verificação da resposta
            if (respostaJogador == p.getRespostaCorreta()) {
                System.out.println("✅ Correto!");
            } else {
                System.out.println("❌ Errado. A resposta correta era: " + p.getRespostaCorreta());
            }

        }

    }
}
