import java.util.ArrayList;

public class Nivel1 {
    public Nivel1(){}
        public void chamaNivel1(){
            ArrayList<Perguntas> perguntas = Arquivo.carregarPerguntas("C:\\Users\\1292510067\\IdeaProjects\\BugzippyA3\\src\\perguntas.txt");

            ArrayList<Perguntas> perguntasNivel1 = Filtragem.sortearPerguntasPorNivel(perguntas, 1);

            for (Perguntas p : perguntasNivel1) {
                System.out.println(p.getEnunciado());
                System.out.println(p.getAlternativa1());
                System.out.println(p.getAlternativa2());
                System.out.println(p.getAlternativa3());
                System.out.println(p.getAlternativa4());
                System.out.println();
            }

        }
}
