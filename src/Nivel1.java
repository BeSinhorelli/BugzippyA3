import javax.swing.*;
import java.io.*;

public class Nivel1 {

    public static void chamaNivel1() {
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

            if (!d.endsWith(File.separator)) {
                d += File.separator;
            }

            msg += ".txt";
            File arquivo = new File(d + msg);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
                bw.write("Exemplo de conteúdo salvo no arquivo.");
                bw.newLine();
                bw.write("Linha 2 de exemplo.");
                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso em:\n" + arquivo.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro geral: " + e.getMessage());
        }
    }
}
