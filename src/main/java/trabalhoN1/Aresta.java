package trabalhoN1;
import java.util.HashMap;
import java.util.Map;

public class Aresta{
    //atributos
    //pq os atributos são private?
    private int origem; //ponto de embarque
    private int destino; //ponto de desembarque
    private int distancia; //distancia em klm entre as arestas
    private Map<String, Integer> transporte; //aramazena o tipo de transporte e seu preço

    //contrutor
    //Inicializa os atributos origem, destino, distancia
    public Aresta(int origem, int destino, int distancia){ //parametros do construtor
        //atributos da classe
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;

        this.transporte = new HashMap<>();
    }

    //métodos get e set
    //os métodos get e set são usados para acessar e modificar os atributos da classe
    //já que eles são privados, assim conseguimos utilizar eles dentro da classe grafo(exemplo)


    public int getOrigem() {    //exemplo: getOrigem retorna o valor
        return origem;         //int origem = aresta.getOrigem();
    }
    public void setOrigem(int origem) { //permite modificar o valor
        this.origem = origem;           //aresta.setOrigem(5); define a origem como 5
    }

    public int getDistino() {  //
        return destino;
    }

    public void setDistino(int destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;       //exemplo: retorna o valor / int distancia = aresta.getDistancia();
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;           //modifica o valor / aresta.setDistancia(200); //define a distância 300
    }

    public Map<String, Integer> getTransporte() {    //retorna o valor
        return transporte;                           //exemplo: Map<String, Integer> transportes = aresta.getTransporte();
    }

    public void setTransporte(Map<String, Integer> transporte) { //permite modificar o valor
        this.transporte = transporte;
    }


    //adicionar um novo meio de transporte e o preço
    public void adicionarTransporte(String tipo, int preco){
        transporte.put(tipo, preco);
    } //aresta.adicionarTransporte("Ônibus", 20);
}
