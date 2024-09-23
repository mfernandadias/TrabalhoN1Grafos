package trabalhoN1;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    //atributos
    //por que os atributos são private
    private Aresta[][] matrizAdjacencia; // Matriz de adjacência

    private List<Vertice> vertices; // Lista de vértices (capitais)

    //private boolean dirigido; // Indica se é dígrafo (dirigido)
    //por que utilizar o atributos boolean dirigido

    //contrutor
    public Grafo(int numVertices) {
        matrizAdjacencia = new Aresta[numVertices][numVertices];
        vertices = new ArrayList<>();
        //this.dirigido = dirigido;
    }

    // Adicionar um vértice
    public void adicionarVertice(String nome) {
        Vertice vertice = new Vertice(nome);
        vertices.add(vertice);
    }

    // Remover um vértice
    public void removerVertice(int indice) {
        vertices.remove(indice);
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            matrizAdjacencia[indice][i] = null;
            matrizAdjacencia[i][indice] = null;
        }
    }

    // Atualizar uma aresta
    public void atualizarAresta(int origem, int destino, String transporte, int preco) {
        if (matrizAdjacencia[origem][destino] != null) {
            matrizAdjacencia[origem][destino].adicionarTransporte(transporte, preco);
        }
    }

    // Consultar vértice
    public Vertice consultarVertice(int indice) {
        if (indice >= 0 && indice < vertices.size()) {
            return vertices.get(indice);
        }
        return null;
    }

    // Consultar aresta
    public Aresta consultarAresta(int origem, int destino) {
        return matrizAdjacencia[origem][destino];
    }

    // Listar dados do grafo
    public void listarDadosGrafo() {
        //System.out.println("O grafo é " + (dirigido ? "dirigido (dígrafo)" : "não dirigido"));
        System.out.println("O grafo é " + (grafoValorado() ? "valorado" : "não valorado"));
        System.out.println("O grafo " + (temLaco() ? "tem laço" : "não tem laço"));
        listarGrausVertices();
    }

    // Verifica se o grafo é valorado
    private boolean grafoValorado() {
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                if (matrizAdjacencia[i][j] != null && matrizAdjacencia[i][j].getDistancia() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // Verifica se o grafo tem laço
    private boolean temLaco() {
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (matrizAdjacencia[i][i] != null) {
                return true;
            }
        }
        return false;
    }

    // Listar os graus dos vértices
    private void listarGrausVertices() {
        for (int i = 0; i < vertices.size(); i++) {
            int grau = 0;
            for (int j = 0; j < matrizAdjacencia.length; j++) {
                if (matrizAdjacencia[i][j] != null) {
                    grau++;
                }
            }
            System.out.println("O vértice " + vertices.get(i).getNome() + " tem grau: " + grau);
        }
    }
    public void mostrarMatrizAdjacencia() {
        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                if (matrizAdjacencia[i][j] != null) {
                    System.out.print(matrizAdjacencia[i][j].getDistancia() + "\t");
                } else {
                    System.out.print("0\t");
                }
            }
            System.out.println();
        }
    }

    public void mostrarCapitais() {
        System.out.println("Capitais:");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(i + ": " + vertices.get(i).getNome());
        }
    }

    //mostrar a viagem de avião mais acessível
   /* public void viagemAviaMaisAcessível(){

    } */
    public class Viagem {
        private String origem;
        private String destino;
        private int preco;
        // ... outros atributos se necessário
    }

    public Viagem viagemAviaoMaisAcessivel() {
        Viagem viagemMaisBarata = null;

        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                Aresta aresta = matrizAdjacencia[i][j];
                if (aresta != null && aresta.getTransporte().containsKey("Avião")) {
                    int precoAviao = aresta.getTransporte().get("Avião");
                    Viagem viagem = new Viagem(vertices.get(i).getNome(), vertices.get(j).getNome(), precoAviao);
                    if (viagemMaisBarata == null || viagem.getPreco() < viagemMaisBarata.getPreco()) {
                        viagemMaisBarata = viagem;
                    }
                }
            }
        }
        return viagemMaisBarata;
    }

    // Adicionar uma aresta com meios de transporte e preços
    public void adicionarAresta(int origem, int destino, int distancia, String transporte, int preco) {
        if (matrizAdjacencia[origem][destino] == null) {
            Aresta aresta = new Aresta(origem, destino, distancia);
            aresta.adicionarTransporte(transporte, preco);
            matrizAdjacencia[origem][destino] = aresta;
            matrizAdjacencia[destino][origem] = aresta; // Grafo não-direcionado
        } else {
            matrizAdjacencia[origem][destino].adicionarTransporte(transporte, preco);
            matrizAdjacencia[destino][origem].adicionarTransporte(transporte, preco);
        }
    }
}
