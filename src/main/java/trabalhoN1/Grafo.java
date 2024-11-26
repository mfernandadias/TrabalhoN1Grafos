package trabalhoN1;

import java.util.*;

public class Grafo {

    //ATRIBUTOS
    //matriz bidimenciona (um array de arrays)
    //cada elemento do tipo Aresta
    private Aresta[][] matrizAdjacencia; // Matriz de adjacência

    // variável vertice de tipo lista
    //cada vertice representa um No dentro do grafo
    private  List<Vertice> vertices; // Lista de vértices (capitais)

    //somente retorna o valor true ou false
    private boolean dirigido; // Indica se é dígrafo (dirigido)

    private List<Aresta> listaArestas;

    private Map<Integer, List<Aresta>> adjacencias;

    //__________________________________________________________________________________________________________________
    //Contrutor
    public Grafo(int numVertices) {
        matrizAdjacencia = new Aresta[numVertices][numVertices]; //construi uma matriz bidimensional de Aresta
        vertices = new ArrayList<>();
        this.dirigido = true; //
        this.vertices = new ArrayList<>();//(numVertices);
        this.listaArestas = new ArrayList<>();
        this.dirigido = dirigido;
        this.adjacencias = new HashMap<>();

    }

    // Método para retornar a lista de vértices
    public List<Vertice> getVertices() {
        return vertices;
    }

    // Método para adicionar um vértice ao grafo
    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }



    //__________________________________________________________________________________________________________________
    // Cadastrar um vértice
    public void cadastrarVertice(String nome) {
        Vertice vertice = new Vertice(nome); //cria uma nova Capital com o nome fornecido
        vertices.add(vertice); //adiciona a lista o nome do vértice
    }

    //__________________________________________________________________________________________________________________
    // Cadastrar uma aresta

    public void cadastrarAresta(int origem, int destino, int distancia, String transporte, int preco) {
        //verifica se existe uma aresta
        if (matrizAdjacencia[origem][destino] == null) {
            //registrar novo aresta
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

    //__________________________________________________________________________________________________________________

    // Consultar vértice
    public Vertice consultarVertice(int indice) {
        if (indice >= 0 && indice < vertices.size()) {
            return vertices.get(indice);
        }
        return null;
    }

    //__________________________________________________________________________________________________________________
    // Consultar aresta
    public Aresta consultarAresta(int origem, int destino) {
        return matrizAdjacencia[origem][destino]; //acessa a matriz adjacênncia e retorna a aresta que conecta os vertices
    }

    //__________________________________________________________________________________________________________________
    // REMOVER VERTICE
    //remove um vértice do grafo e apaga todas as suas arestas associadas
    public void removerVertice(int indice) {
        vertices.remove(indice); //remove
        for (int i = 0; i < matrizAdjacencia.length; i++) { //loop percorre toda a matriz de adjacência
            matrizAdjacencia[indice][i] = null; //remove todas as arestas conectadas ao vértice no índice (linhas)
            matrizAdjacencia[i][indice] = null; //remove todas as arestas que conectam outros vértices  (colunas)
        }
    }
 //__________________________________________________________________________________________________________________
    //REMOVER ARESTA
    public void removerAresta(int origem, int destino) {
        matrizAdjacencia[origem][destino] = null; //inseri o valor da aresta a matriz como null, apagando a conexão
        if (!dirigido) { //grafo dirigidoo também é apagado
            matrizAdjacencia[destino][origem] = null;
        }
    }

    //__________________________________________________________________________________________________________________
    //ATUALIZAR VÉRTICE
    public void atualizarVertice(int indice, String novoNome) { //atualiza o nome da Capital já existe
        if (indice >= 0 && indice < vertices.size()) {
            vertices.get(indice).setNome(novoNome); // Corrigido
        } else {
            System.out.println("Índice inválido. Vértice não encontrado.");
        }
    }

    //__________________________________________________________________________________________________________________
    // Atualizar uma aresta
    public void atualizarAresta(int origem, int destino, String transporte, int preco) { //
        if (matrizAdjacencia[origem][destino] != null) { //verifica se a aresta existe
            matrizAdjacencia[origem][destino].adicionarTransporte(transporte, preco); //atualiza o transporte e o preco
        }
    }

    //__________________________________________________________________________________________________________________
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

    //__________________________________________________________________________________________________________________
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

    //__________________________________________________________________________________________________________________

    public void mostrarMatrizAdjacencia() { //imprimi a matriz de adjaçência
        System.out.println("_________________________________________________");
        //explica depois esse método
        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                //verifique se existe uma aresta entre os vértice i e j
                if (matrizAdjacencia[i][j] != null) {
                    System.out.print(matrizAdjacencia[i][j].getDistancia() + "1\t");
                    System.out.print("1\t");
                } else {
                    System.out.print("0\t");
                }
            }
            System.out.println();
        }
    }
    //__________________________________________________________________________________________________________________
    public void adicionarAresta(int origem, int destino, int distancia) {
        Aresta aresta = new Aresta(origem, destino, distancia);
        matrizAdjacencia[origem][destino] = aresta; // Adiciona à matriz de adjacência
        listaArestas.add(aresta); // Adiciona à lista de arestas

        // Adicionar à lista de adjacências
        adjacencias.putIfAbsent(origem, new ArrayList<>());
        adjacencias.get(origem).add(aresta);

        if (!dirigido) { // Se o grafo for não-dirigido
            Aresta arestaReversa = new Aresta(destino, origem, distancia);
            matrizAdjacencia[destino][origem] = arestaReversa;
            adjacencias.putIfAbsent(destino, new ArrayList<>());
            adjacencias.get(destino).add(arestaReversa);
        }
    }

    public ArrayList<Aresta> arestas() {
        ArrayList<Aresta> lista = new ArrayList<>();

        // Verifique se a matriz de adjacência está corretamente inicializada
        if (matrizAdjacencia == null) {
            System.out.println("A matriz de adjacência não foi inicializada.");
            return lista;
        }

        // Percorra a matriz de adjacência para coletar todas as arestas
        for (int i = 0; i < matrizAdjacencia.length; i++) {
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                // Verifique se existe uma aresta entre os vértices i e j
                Aresta a = matrizAdjacencia[i][j];
                if (a != null) {
                    lista.add(a); // Adicione a aresta à lista
                }
            }
        }
        return lista;
    }
    //método retorna o índice de um vértice
    public int getIndiceVertice(String nome) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNome().equals(nome)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Vértice não encontrado: " + nome);
    }
    //método retorna o objeto vertice pelo indice
    public Vertice getVertice(int indice) {
        if (indice >= 0 && indice < vertices.size()) {
            return vertices.get(indice);
        }
        throw new IndexOutOfBoundsException("Índice inválido: " + indice);
    }

    //getVertices (string nome)
    public Vertice getVertice(String nome) {
        for (Vertice v : vertices) {
            if (v.getNome().equals(nome)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Vértice não encontrado: " + nome);
    }

    //
    // Método dentro da classe Grafo
    /*public Aresta getAresta(int origem, int destino) {
        for (Aresta aresta : listaArestas) {
            if ((aresta.getOrigem() == origem && aresta.getDestino() == destino) ||
                    (aresta.getOrigem() == destino && aresta.getDestino() == origem)) {
                return aresta;
            }
        }
        return null;
    } */
    /*public Aresta getAresta(int origem, int destino) {
        if (adjacencias.containsKey(origem)) {
            for (Aresta aresta : adjacencias.get(origem)) {
                if (aresta.getDestino() == destino) {
                    return aresta;
                }
            }
        }
       // return null; // Retorna null se não encontrar a aresta
        return matrizAdjacencia[origem][destino];
    } */
    public Aresta getAresta(int origem, int destino) {
        if (adjacencias.containsKey(origem)) {
            for (Aresta aresta : adjacencias.get(origem)) {
                if (aresta.getDestino() == destino) {
                    System.out.println("Aresta encontrada: " + origem + " -> " + destino + ", distância: " + aresta.getDistancia());
                    return aresta;
                }
            }
        }
        System.out.println("Aresta não encontrada: " + origem + " -> " + destino);
        return null;
    }



    //__________________________________________________________________________________________________________________
    //método para mostrar as Capitais
    public void mostrarCapitais() {
        System.out.println("Capitais:");
        for (int i = 0; i < vertices.size(); i++) { //lista de vértice (caítais) presente no grafo
            //percorre a lista e imprimi os nomes
            System.out.println(i + ": " + vertices.get(i).getNome());
        }
    }

    //__________________________________________________________________________________________________________________
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

    //_________________________________________________________________________________________________________________________
    //Método para mostrar a viagem de Onibus mais acessivel
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

    //__________________________________________________________________________________________________________________


    //Método que mostraViagensParaUmaCapital espeficia
    //Vou inserir São Paulo e o código vai retornar todas as viagens que São Paulo recebe
    public boolean mostrarViagensParaCapital(String nomeCapitalDestino) {
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
            return false; //cidade não encontrada
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

        /*if (!encontrouViagem) {
            System.out.println("Nenhuma viagem encontrada para " + nomeCapitalDestino);
        } */
        return encontrouViagem; //retorna true se encontrou viagens
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
        public int buscarIndiceVertice(String nome) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getNome().equalsIgnoreCase(nome)) {
                return i; // Retorna o índice do vértice
            }
        }
        return -1; // Se não encontrar, retorna -1
    }
   //_____________________________________________________________________________________________________________
    //BUSCA EM PROFUNDIDADES (DFS -  DEPTH FIRST SEARCH)
    public void dfs(int origem, int destino){
        boolean[] visitados = new boolean[vertices.size()];
        List<Integer> caminho = new ArrayList<>();


        /*//verificação de os índices fornacidos são validos
        if (origem < 0 || origem >= vertices.size() || destino < 0 || destino >= vertices.size()) {
        System.out.println("Índices inválidos. Certifique-se de que estejam entre 0 e " + (vertices.size() - 1));
        //break;
        } */


        if(dfsRecursivo(origem, destino, visitados, caminho)){
            System.out.println("Caminho encontrado " + caminho);
        } else {
            System.out.println("Não há caminho entre os vértives " + origem + " e " + destino);
        }
    }

    private boolean dfsRecursivo(int atual, int destino, boolean[] visitados, List<Integer> caminho){
        visitados[atual] = true;
        caminho.add(atual);

        if (atual == destino) {
            return true;
        }

        for (int i = 0; i < matrizAdjacencia.length; i++) {
            if (matrizAdjacencia[atual][i] != null && !visitados[i]) {
                if (dfsRecursivo(i, destino, visitados, caminho)) {
                    return true;
                }
            }
        }
        caminho.remove(caminho.size() - 1);
        return false;
    }

    //BUSCA EM LARGURA
    //método paar realizar a busca em largura
    public void buscaEmLargura(int origem, int destino){
        boolean[] visitados = new boolean[vertices.size()];
        Queue<List<Integer>> fila = new LinkedList<>();

        //adiciona o caminho inicial contendo apenas o vértice de origem
        List<Integer> caminhoInicial = new ArrayList<>();
        caminhoInicial.add(origem);
        fila.add(caminhoInicial);

        while(!fila.isEmpty()){
            //remove o próximo caminho da fila
            List<Integer> caminhoAtual = fila.poll();
            int ultimoVertice = caminhoAtual.get(caminhoAtual.size() - 1);

            //se o destifno foi alcançado imprime o caminho e retorna
            if(ultimoVertice == destino){
                System.out.println("Caminho encontrado " +  caminhoAtual);
                return;
            }

            //marca o vértice atual como visitado
            visitados[ultimoVertice] = true;

            //adiciona todos os vertices adjacentes não visitados a matriz
            for(int i = 0; i < matrizAdjacencia.length; i++){
                if(matrizAdjacencia[ultimoVertice][i] != null && !visitados[i]){
                    List<Integer> novoCaminho = new ArrayList<>(caminhoAtual);
                    novoCaminho.add(i);
                    fila.add(novoCaminho);
                }
            }

        }

    }


    //ALGORTIMO DE DIJKSTRA __________________________________________________________________


    //ALGORITMO DE FLOYD______________________________________________________________________




}

