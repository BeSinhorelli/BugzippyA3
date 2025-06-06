public class Player {
    private String nome, ranking, acesso, email;

    public Player(String nome, String ranking, String acesso, String email) {
        this.nome = nome;
        this.ranking = ranking;
        this.acesso = acesso;
        this.email = email;
    }

    public Player(String nome, String acesso, String email) {
        this.nome = nome;
        this.acesso = acesso;
        this.email = email;
    }
    public Player(String nome, String email) {
        this.nome = nome;
        this.email = email;
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

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
