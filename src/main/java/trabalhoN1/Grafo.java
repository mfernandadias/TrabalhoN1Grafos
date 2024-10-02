package trabalhoN1;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    //ATRIBUTOS
    //matriz bidimenciona (um array de arrays)
    //cada elemento do tipo Aresta
    private Aresta[][] matrizAdjacencia; // Matriz de adjacência

    // variável vertice de tipo lista
    //cada vertice representa um No dentro do grafo
    private List<Vertice> vertices; // Lista de vértices (capitais)

    //somente retorna o valor true ou false
    private boolean dirigido; // Indica se é dígrafo (dirigido)


    //Contrutor
    public Grafo(int numVertices) {
        matrizAdjacencia = new Aresta[numVertices][numVertices]; //construi uma matriz bidimensional de Aresta
        vertices = new ArrayList<>();
       // this.dirigido = dirigido; //
    }

    // Cadastrar um vértice
    public void cadastrarVertice(String nome) {
        Vertice vertice = new Vertice(nome); //cria uma nova Capital com o nome fornecido
        vertices.add(vertice); //adiciona a lista o nome do vértice
    }

    // Cadastrar uma aresta
    public void cadastrarAresta(int origem, int destino, int distancia, String transporte, int preco) {
        //verifica se existe uma aresta
        if (matrizAdjacencia[origem][destino] == null) {
            Aresta aresta = new Aresta(origem, destino, distancia);  //registra nova aresta
            aresta.adicionarTransporte(transporte, preco); //chama o método adicionar transporte, que esta na Classe Aresta
            matrizAdjacencia[origem][destino] = aresta; //nova aresta é registrada na matriz adjacente
            if (!dirigido) {
                matrizAdjacencia[destino][origem] = aresta; // Para grafos não dirigidos
            } //significa que é uma matriz bidirecional (de origem para destino e de destino para origem)
        } else { //CASO já exista uma aresta (não é null)
            matrizAdjacencia[origem][destino].adicionarTransporte(transporte, preco); //chamado o método trasnporte para adicionar o meio de transporte e o valor
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
        return matrizAdjacencia[origem][destino]; //acessa a matriz adjacênncia e retorna a aresta que conecta os vertices
    }

    // REMOVER VERTICE
    //remove um vértice do grafo e apaga todas as suas arestas associadas
    public void removerVertice(int indice) {
        vertices.remove(indice); //remove
        for (int i = 0; i < matrizAdjacencia.length; i++) { //loop percorre toda a matriz de adjacência
            matrizAdjacencia[indice][i] = null; //remove todas as arestas conectadas ao vértice no índice (linhas)
            matrizAdjacencia[i][indice] = null; //remove todas as arestas que conectam outros vértices  (colunas)
        }
    }

    //REMOVER ARESTA
    public void removerAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = null; //inseri o valor da aresta a matriz como null, apagando a conexão
        if (!dirigido) { //grafo dirigidoo também é apagado
            matrizAdjacencia[destino][origem] = null;
        }
    }

    //ATUALIZAR VÉRTICE
    public void atualizarVertice(int indice, String novoNome) { //atualiza o nome da Capital já existe
        if (indice >= 0 && indice < vertices.size()) {
            vertices.get(indice).setNome(novoNome); // Corrigido
        } else {
            System.out.println("Índice inválido. Vértice não encontrado.");
        }
    }

    // Atualizar uma aresta
    public void atualizarAresta(int origem, int destino, String transporte, int preco) { //
        if (matrizAdjacencia[origem][destino] != null) { //verifica se a aresta existe
            matrizAdjacencia[origem][destino].adicionarTransporte(transporte, preco); //atualiza o transporte e o preco
        }
    }

    //GRAFO
    // Listar dados do grafo
    //imprimi informações do grafo
    //chamando os métodos grafoValorado(), temLaco() e listaGrausVertices()
    public void listarDadosGrafo() {
        System.out.println("O grafo é " + (dirigido ? "dirigido (dígrafo)" : "não dirigido"));
        System.out.println("O grafo é " + (grafoValorado() ? "valorado" : "não valorado"));
        System.out.println("O grafo " + (temLaco() ? "tem laço" : "não tem laço"));
        listarGrausVertices();
    }

    // Verifica se o grafo é valorado
    private boolean grafoValorado() { //verificado se o grafo é valorado, contém aresta com distâncias positivas
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
    private boolean temLaco() { //verifica se o Grafo tem laços(arestas que conectam um vértice a ele mesmo)
        for (int i = 0; i < matrizAdjacencia.length; i++) { //indice a aresta
            if (matrizAdjacencia[i][i] != null) { //percorendo a matriz
                return true; //verdadeiro
            }
        }
        return false; //falso
    }

    // Listar os graus dos vértices
    private void listarGrausVertices() { //para cada vértice, conta quatas arestas estão conectadas  e informa o resultado
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

    public void mostrarMatrizAdjacencia() { //imprimi a matriz de adjaçência
        //explica depois esse método
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
        for (int i = 0; i < vertices.size(); i++) { //lista de vértice (caítais) presente no grafo
            //percorre a lista e imprimi os nomes
            System.out.println(i + ": " + vertices.get(i).getNome());
        }
    }

    //método para mostrar a viagem de avião mais em conta
    public void viagemDeAviaoMaisAcessivel() {
        int menorPreco = Integer.MAX_VALUE; //inicializa o menor preco
        String origem = null, destino = null;

        //percore matriz
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                Aresta aresta = matrizAdjacencia[i][j]; //obtém a aresta entre os vértices i e j
                if (aresta != null && aresta.getTransporte().containsKey("Avião")) { //verifica se a aresta contém transporte aéreo
                    int precoAviao = aresta.getTransporte().get("Avião"); //obtém o preço do transporte
                    // Atualiza o menor preço, origem e destino se o preço atual for menor
                    if (precoAviao < menorPreco) {
                        menorPreco = precoAviao;
                        origem = vertices.get(i).getNome(); //armazena o nome da capital de embarque
                        destino = vertices.get(j).getNome(); //armazena o nome da capital de desembarque
                    }
                }
            }
        }
        // Se foram encontradas origens e destinos válidos, imprime a viagem mais acessível
        if (origem != null && destino != null) {
            System.out.println("Viagem de avião mais acessível:");
            System.out.println(origem + " -> " + destino + " por R$" + menorPreco);
        } else {
            System.out.println("Nenhuma viagem de avião disponível.");
        }
    }


    //Métod para mostrar a viagem de Onibus mais acessivel
    public void viagemOnibusMaisAcessivel() {
        int menorPreco = Integer.MAX_VALUE;
        String origem = null, destino = null;
        //percorre a matriz
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
        if (indiceDestino == -1) { //verifica se a capital foi encontrada
            System.out.println("Cidade não encontrada.");
            return;
        }

        // Imprime a lista de viagens disponíveis para a capital específica
        System.out.println("Viagens disponíveis para " + nomeCapitalDestino + ":");
        boolean encontrouViagem = false;

        // Iterar pelas conexões de outras capitais para o destino
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            Aresta aresta = matrizAdjacencia[i][indiceDestino];
            if (aresta != null) {
                encontrouViagem = true;
                String capitalOrigem = vertices.get(i).getNome();
                System.out.println("Origem: " + capitalOrigem);
                aresta.getTransporte().forEach((transporte, preco) -> {
                    System.out.println("Transporte: " + transporte + " - Preço: R$" + preco);
                });
                System.out.println("----------------------------");
            }
        }

        if (!encontrouViagem) {
            System.out.println("Nenhuma viagem encontrada para " + nomeCapitalDestino);
        }
    }


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