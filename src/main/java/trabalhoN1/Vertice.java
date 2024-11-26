package trabalhoN1;

public class Vertice {
    //atributo nome = capital
    private String nome;
    private int distancia = Integer.MAX_VALUE;
    public Vertice anterior; //guardar o vertice anterior no menor caminho

    //construtor
    public Vertice(String nome) {

        this.nome = nome;
    }

    public int getDistancia(){
       return distancia;
    }
    public Vertice getAnterior() {
        return anterior;
    }

    public void setAnterior(Vertice anterior) {
        this.anterior = anterior;
    }

    public String getNome() { //retorna o valor do atributo
        return nome;
    }
    public void setNome(String nome) { //permite a alteração do valor em um segunda classe
        this.nome = nome;
    }
}
