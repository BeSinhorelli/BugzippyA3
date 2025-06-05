import java.io.*;
import java.util.*;
public class Arquivo {

        public static ArrayList<Pergunta> carregarPerguntas(String arq) {
            ArrayList<Pergunta> perguntas = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] partes = linha.split(";");
                    if (partes.length == 6) {
                        int nivel = Integer.parseInt(partes[0]);
                        Pergunta p = new Pergunta(nivel, partes[1], partes[2], partes[3], partes[4], partes[5]);
                        perguntas.add(p);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return perguntas;
        }
    }
