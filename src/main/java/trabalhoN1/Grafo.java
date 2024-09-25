package trabalhoN1;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    //atributos
    //por que os atributos são private
    private Aresta[][] matrizAdjacencia; // Matriz de adjacência

    private List<Vertice> vertices; // Lista de vértices (capitais)
    private boolean dirigido; // Indica se é dígrafo (dirigido)
    //por que utilizar o atributos boolean dirigido

    //contrutor
    public Grafo(int numVertices) {
        matrizAdjacencia = new Aresta[numVertices][numVertices];
        vertices = new ArrayList<>();
        //this.dirigido = dirigido;
    }

    // Cadastrar um vértice
    public void cadastrarVertice(String nome) {
        Vertice vertice = new Vertice(nome);
        vertices.add(vertice);
    }

    // Cadastrar uma aresta
    public void cadastrarAresta(int origem, int destino, int distancia, String transporte, int preco) {
        if (matrizAdjacencia[origem][destino] == null) {
            Aresta aresta = new Aresta(origem, destino, distancia);
            aresta.adicionarTransporte(transporte, preco);
            matrizAdjacencia[origem][destino] = aresta;
            if (!dirigido) {
                matrizAdjacencia[destino][origem] = aresta; // Para grafos não dirigidos
            }
        } else {
            matrizAdjacencia[origem][destino].adicionarTransporte(transporte, preco);
            if (!dirigido) {
                matrizAdjacencia[destino][origem].adicionarTransporte(transporte, preco);
            }
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

    // REMOVER VERTICE
    public void removerVertice(int indice) {
        vertices.remove(indice);
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            matrizAdjacencia[indice][i] = null;
            matrizAdjacencia[i][indice] = null;
        }
    }

    //REMOVER ARESTA
    public void removerAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = null;
        if (!dirigido) {
            matrizAdjacencia[destino][origem] = null;
        }
    }

    //ATUALIZAR VÉRTICE
    public void atualizarVertice(int indice, String novoNome) {
        if (indice >= 0 && indice < vertices.size()) {
            vertices.get(indice).setNome(novoNome); // Corrigido
        } else {
            System.out.println("Índice inválido. Vértice não encontrado.");
        }
    }

    // Atualizar uma aresta
    public void atualizarAresta(int origem, int destino, String transporte, int preco) {
        if (matrizAdjacencia[origem][destino] != null) {
            matrizAdjacencia[origem][destino].adicionarTransporte(transporte, preco);
        }
    }

    //GRAFO
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

    //método para mostrar as Capitais
    public void mostrarCapitais() {
        System.out.println("Capitais:");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(i + ": " + vertices.get(i).getNome());
        }
    }

    //método para mostrar a viagem de avião mais em conta
    public void viagemDeAviaoMaisAcessivel() {
        int menorPreco = Integer.MAX_VALUE;
        String origem = null, destino = null;

        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                Aresta aresta = matrizAdjacencia[i][j];
                if (aresta != null && aresta.getTransporte().containsKey("Avião")) {
                    int precoAviao = aresta.getTransporte().get("Avião");
                    if (precoAviao < menorPreco) {
                        menorPreco = precoAviao;
                        origem = vertices.get(i).getNome();
                        destino = vertices.get(j).getNome();
                    }
                }
            }
        }
        if (origem != null && destino != null) {
            System.out.println("Viagem de avião mais acessível:");
            System.out.println(origem + " -> " + destino + " por R$" + menorPreco);
        } else {
            System.out.println("Nenhuma viagem de avião disponível.");
        }
    }


    //Métod para mostrar a viagem de avião mais acessivel
    public void viagemOnibusMaisAcessivel() {
        int menorPreco = Integer.MAX_VALUE;
        String origem = null, destino = null;

        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                Aresta aresta = matrizAdjacencia[i][j];
                if (aresta != null && aresta.getTransporte().containsKey("Ônibus")) {
                    int precoOnibus = aresta.getTransporte().get("Ônibus");
                    if (precoOnibus < menorPreco) {
                        menorPreco = precoOnibus;
                        origem = vertices.get(i).getNome();
                        destino = vertices.get(j).getNome();
                    }
                }
            }
        }
        if (origem != null && destino != null) {
            System.out.println("Viagem de ônibus mais acessível:");
            System.out.println(origem + " -> " + destino + " por R$" + menorPreco);
        } else {
            System.out.println("Nenhuma viagem de ônibus disponível.");
        }
    }

    //método que mostra as opções de viagem entre duas capitais (Viagem direta)
    public void mostrarOpcoesViagem(int origem, int destino) {
        Aresta aresta = matrizAdjacencia[origem][destino];
        if (aresta != null) {
            System.out.println("Opções de viagem de " + vertices.get(origem).getNome() + " para " + vertices.get(destino).getNome() + ":");
            aresta.getTransporte().forEach((transporte, preco) -> {
                System.out.println(transporte + ": R$" + preco + ", Distância: " + aresta.getDistancia() + " km");
            });
        } else {
            System.out.println("Não há opções de viagem disponíveis entre esses destinos.");
        }
    }

    //Método que mostrar as opções de conexões entre duas capitais

    public void mostrarOpcoesViagem(String origemNome, String destinoNome) {
        int origem = -1;
        int destino = -1;

        // Encontrar o índice da cidade de origem
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNome().equalsIgnoreCase(origemNome)) {
                origem = i;
                break;
            }
        }

        // Encontrar o índice da cidade de destino
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNome().equalsIgnoreCase(destinoNome)) {
                destino = i;
                break;
            }
        }

        // Verificar se ambos os vértices foram encontrados
        if (origem == -1) {
            System.out.println("Cidade de origem não encontrada.");
            return;
        }

        if (destino == -1) {
            System.out.println("Cidade de destino não encontrada.");
            return;
        }

        // Buscar a aresta e mostrar as opções de viagem
        Aresta aresta = matrizAdjacencia[origem][destino];
        if (aresta != null) {
            System.out.println("Opções de viagem de " + vertices.get(origem).getNome() + " para " + vertices.get(destino).getNome() + ":");
            aresta.getTransporte().forEach((transporte, preco) -> {
                System.out.println(transporte + ": R$" + preco + ", Distância: " + aresta.getDistancia() + " km");
            });
        } else {
            System.out.println("Não há opções de viagem disponíveis entre esses destinos.");
        }
    }


    //Método que mostraViagensParaUmaCapital espeficia
    //Vou inserir São Paulo e o código vai retornar todas as viagens que São Paulo recebe
    public void mostrarViagensParaCapital(String nomeCapitalDestino) {
        int indiceDestino = -1;

        // Encontrar o índice da cidade de destino
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNome().equalsIgnoreCase(nomeCapitalDestino)) {
                indiceDestino = i;
                break;
            }
        }

        if (indiceDestino == -1) {
            System.out.println("Cidade não encontrada.");
            return;
        }
        System.out.println("Viagens disponíveis para " + nomeCapitalDestino + ":");
        boolean encontrouViagem = false;


        //CASE 15
        //listar as viagens dispoveis de uma capital
       public void listarViagensDisponiveis(int indiceVertice) {
           //o vértice fornecidado é válido ?
            if(indiceVertice < 0 || indiceVertice >= vertices.size()){
                System.out.println("Índicee de vértice Inválido");
                return;
            }

            //exibir todas as opções conforme o vértice de embarque
            String capitalEmbarque = vertices.get(indiceVertice).getNome();
            System.out.println("Viagens disponíveis para embarque na capital: " + capitalEmbarque + " :");

            boolean conexaoDisponivel = false;

            //Iterar sobre as conexões de vértice fornecido
            for(int j = 0; j < matrizAdjacencia[indiceVertice].length; j++){
                Aresta aresta = matrizAdjacencia[indiceVertice][j];

                if(aresta != null){
                    conexaoDisponivel = true;
                    String capitalDesembarque = vertices.get(j).getNome();
                    System.out.println("Destino: " + capitalDesembarque);
                    aresta.getTransporte().forEach((tipoTransporte, preco) -> {
                        System.out.println("Transporte: " + tipoTransporte + " - Preço: R$" + preco);
                    });
                    System.out.println("----------------------------");
                }
            }
            // Se não houver conexões encontradas
            if (!conexaoDisponivel) {
                System.out.println("Não há viagens disponíveis a partir da capital " + capitalEmbarque  + ".");
            }
        }

    }
}