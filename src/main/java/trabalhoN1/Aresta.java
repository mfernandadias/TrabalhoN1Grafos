package trabalhoN1;
import java.util.HashMap;
import java.util.Map;

public class Aresta{
    //atributos
    //pq os atributos são private?
    private int origem;
    private int destino;
    private int distancia;
    private Map<String, Integer> transporte; //aramazena o tipo de transporte e seu preço

    //contrutor
    public Aresta(int origem, int destino, int distancia){
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.transporte = new HashMap<>();
    }

    //métodos get e set 
    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Map<String, Integer> getTransporte() {
        return transporte;
    }

    public void setTransporte(Map<String, Integer> transporte) {
        this.transporte = transporte;
    }

    //adionar um meio de transporte e o preço
    public void adicionarTransporte(String tipo, int preco){
        transporte.put(tipo, preco);
    }
}
