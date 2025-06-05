public class Player {
    private String nome, ranking;

    public Player(String nome, String ranking) {
        this.nome = nome;
        this.ranking = ranking;
    }
    public Player(String nome) {
        this.nome = nome;
    }

    public Player() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

}
