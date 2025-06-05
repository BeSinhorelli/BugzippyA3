public class Explicacao {
    private int nivel;
    private String texto;

    public Explicacao(int nivel, String texto){
        this.nivel = nivel;
        this.texto = texto;
    }

    public int getNivelExp() { return nivel; }
    public String getExplicacao() { return texto; }
}
