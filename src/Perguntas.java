public class Perguntas {
    private int nivel;
    private String enunciado;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String alternativa4;
    private String respostaCorreta;

    public Perguntas(int nivel, String enunciado, String a1, String a2, String a3,
                     String a4, String correta){
        this.nivel = nivel;
        this.enunciado = enunciado;
        this.alternativa1 = a1;
        this.alternativa2 = a2;
        this.alternativa3 = a3;
        this.alternativa4 = a4;
        this.respostaCorreta = correta;
    }
    public int getNivel() { return nivel; }
    public String getEnunciado() { return enunciado; }
    public String getAlternativa1() { return alternativa1; }
    public String getAlternativa2() { return alternativa2; }
    public String getAlternativa3() { return alternativa3; }
    public String getAlternativa4() { return alternativa4; }
    public String getRespostaCorreta() { return respostaCorreta; }

}
