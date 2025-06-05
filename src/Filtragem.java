import java.util.ArrayList;
import java.util.*;

public class Filtragem {
    public static ArrayList<Perguntas> sortearPerguntasPorNivel(ArrayList<Perguntas> todas, int nivel) {
        ArrayList<Perguntas> filtradas = new ArrayList<>();
        for (Perguntas p : todas) {
            if (p.getNivel() == nivel) {
                filtradas.add(p);
            }
        }
        ArrayList<Perguntas> tresperg =  new ArrayList<>();
        Collections.shuffle(filtradas);
        for(int i =0; i < filtradas.size(); i++){
            if(i< 3){
                tresperg.add(filtradas.get(i));
            }
        }
        return tresperg;
    }

}
