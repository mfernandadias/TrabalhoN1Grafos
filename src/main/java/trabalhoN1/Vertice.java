package trabalhoN1;

public class Vertice {
    //atributo nome = capital
    private String nome;

    //construtor
    public Vertice(String nome) {
        this.nome = nome;
    }


    public String getNome() { //retorna o valor do atributo
        return nome;
    }

    public void setNome(String nome) { //permite a auteração do valor em um segunda classe
        this.nome = nome;
    }
}
