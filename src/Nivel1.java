import javax.swing.*;
import java.io.*;

    public class Nivel1 {
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
}
