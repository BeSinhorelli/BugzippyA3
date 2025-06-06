import java.util.ArrayList;
import java.util.*;

public class FiltragemExplicacao {
    public static ArrayList<Explicacao> sortearExplicacaoPorNivel(ArrayList<Explicacao> todas, int nivel) {
        ArrayList<Explicacao> filtradasEx = new ArrayList<>();
        for (Explicacao ex : todas) {
            if (ex.getNivelExp() == nivel) {
                filtradasEx.add(ex);
            }
        }
        ArrayList<Explicacao> expli =  new ArrayList<>();

        return expli;
    }

}
