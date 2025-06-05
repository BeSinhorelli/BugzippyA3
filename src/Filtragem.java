public class Filtragem {
    public static ArrayList<Pergunta> sortearPerguntasPorNivel(ArrayList<Pergunta> todas, int nivel) {
        ArrayList<Pergunta> filtradas = new ArrayList<>();
        for (Pergunta p : todas) {
            if (p.getNivel() == nivel) {
                filtradas.add(p);
            }
        }

        Collections.shuffle(filtradas);
        return filtradas.subList(0, Math.min(3, filtradas.size()));
    }

}
