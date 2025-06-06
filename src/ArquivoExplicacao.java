import java.io.*;
import java.util.*;
public class ArquivoExplicacao {

    public static ArrayList<Explicacao> carregarExplicacao(String arq) {
        ArrayList<Explicacao> explicacao = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 7) {
                    int nivel = Integer.parseInt(partes[0]);
                    Explicacao e = new Explicacao(nivel, partes[1]);
                    explicacao.add(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return explicacao;
    }
}
