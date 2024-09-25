package trabalhoN1;

import java.util.Scanner;

public class MenuGrafo {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(10); //número de capitais

        //adicinando capitais (vértices)
        grafo.cadastrarVertice("Porto Alegre ");
        grafo.cadastrarVertice("Florianópolis");
        grafo.cadastrarVertice("Curitiba");
        grafo.cadastrarVertice("São Paulo");

        Scanner scan = new Scanner(System.in);
        //Grafo grafo = new Grafo(10);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Deseja consultar todas as capitais do Brasil: ");
            System.out.println("2. Cadastrar Vértice (Capital)");
            System.out.println("3. Cadastrar Aresta( )");

            System.out.println("4. Consultar Vértice");
            System.out.println("5. Consultar Aresta");

            System.out.println("6. Remover Vértice");
            System.out.println("7. Remover Aresta");

            System.out.println("8. Atualizar Vértice");
            System.out.println("9. Atualizar Aresta");
            System.out.println("10. Listar Dados do Grafo");

            System.out.println("11. Mostrar a viagem de avião mais acessível");
            System.out.println("12. Mostrar a viagem de ônibus mais acessível");
            System.out.println("13. Deseja saber as opções de viagem para o destino: ");
            System.out.println("14. Todas as viagens disponivéis  para uma Capital especifica ");
            System.out.println("15. Percorrer todas as capitais e verificar conexões com o destino especificado");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Capitais do Brasil");
                    grafo.mostrarCapitais();
                    break;
                case 2:
                    System.out.println("Digite o nome do vértice: ");
                    String nomeVertice = scan.next();
                    grafo.cadastrarVertice(nomeVertice);
                    break;
                case 3:
                    grafo.mostrarCapitais();
                    System.out.print("Digite o índice do vértice de origem: ");
                    int origem = scan.nextInt();
                    System.out.print("Digite o índice do vértice de destino: ");
                    int destino = scan.nextInt();
                    System.out.print("Digite a distância entre as capitais: ");
                    int distancia = scan.nextInt();
                    System.out.print("Digite o tipo de transporte (Ônibus, Avião): ");
                    String transporte = scan.next();
                    System.out.print("Digite o preço do transporte: ");
                    int preco = scan.nextInt();
                    grafo.cadastrarAresta(origem, destino, distancia, transporte, preco);
                    int Origem = scan.nextInt();
                    System.out.println("Digite o índice do vértice de destino: ");
                    int Destino = scan.nextInt();
                    System.out.println("Digite o peso da aresta: ");
                    int peso = scan.nextInt();
                    //grafo.adicionarAresta;
                    break;
                case 4:
                    System.out.print("Digite o índice do vértice a consultar: ");
                    int indiceConsultaVertice = scan.nextInt();
                    Vertice vertice = grafo.consultarVertice(indiceConsultaVertice);
                    if (vertice != null) {
                        System.out.println("Vértice: " + vertice.getNome());
                    } else {
                        System.out.println("Vértice não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o índice do vértice de origem: ");
                    int origemAresta = scan.nextInt();
                    System.out.print("Digite o índice do vértice de destino: ");
                    int destinoAresta = scan.nextInt();
                    Aresta aresta = grafo.consultarAresta(origemAresta, destinoAresta);
                    if (aresta != null) {
                        System.out.println("Distância: " + aresta.getDistancia() + " km");
                        aresta.getTransporte().forEach((tipo, valor) -> {
                            System.out.println(tipo + ": R$" + valor);
                        });
                    } else {
                        System.out.println("Aresta não encontrada.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o índice do vértice a remover: ");
                    int indiceRemoverVertice = scan.nextInt();
                    grafo.removerVertice(indiceRemoverVertice);
                    System.out.println("Vértice removido.");
                    break;
                case 7:
                    System.out.print("Digite o índice do vértice de origem: ");
                    int origemRemoverAresta = scan.nextInt();
                    System.out.print("Digite o índice do vértice de destino: ");
                    int destinoRemoverAresta = scan.nextInt();
                    grafo.removerAresta(origemRemoverAresta, destinoRemoverAresta);
                    System.out.println("Aresta removida.");
                    break;
                case 8:
                    //Atualiazar VERTICE
                    System.out.print("Digite o índice do vértice a atualizar: ");
                    int indiceAtualizarVertice = scan.nextInt();
                    System.out.print("Digite o novo nome do vértice: ");
                    String novoNome = scan.next();
                    grafo.atualizarVertice(indiceAtualizarVertice, novoNome);
                    System.out.println("Vértice atualizado.");
                    break;
                case 9:
                    //Atualizar Aresta
                    System.out.println("Digite o indice do vertice de Embarque: ");
                    int origemAtualizarAresta = scan.nextInt();
                    System.out.print("Digite o índice do vértice de destino: ");
                    int destinoAtualizarAresta = scan.nextInt();
                    System.out.print("Digite o novo tipo de transporte: ");
                    String novoTransporte = scan.next();
                    System.out.print("Digite o novo preço do transporte: ");
                    int novoPreco = scan.nextInt();
                    grafo.atualizarAresta(origemAtualizarAresta, destinoAtualizarAresta, novoTransporte, novoPreco);
                    System.out.println("Aresta atualizada.");
                    break;
                case 10:
                    grafo.listarDadosGrafo();
                    break;
                case 11:
                    //viagem de Avião mais acessivel
                    grafo.viagemDeAviaoMaisAcessivel();
                case 12:
                    //viagem de ônibus mais acessivel
                    grafo.viagemOnibusMaisAcessivel();
                case 13:
                    //Método que mostrar as opções de conexões entre duas capitais
                    System.out.print("Digite o nome da cidade de origem: ");
                    String origemNome = scan.next();
                    System.out.print("Digite o nome da cidade de destino: ");
                    String destinoNome = scan.next();
                    grafo.mostrarOpcoesViagem(origemNome, destinoNome);
                    break;
                case 14:
                    //
                    System.out.println("Digite o nome da cidade de destino: ");
                    String nomeCidadeDestino = scan.next();
                    grafo.mostrarViagensParaCapital(nomeCidadeDestino);
                    break;
                case 15:
                    //Percorrer todas as capitais e verificar conexões com o destino especificado
                    System.out.println("Digite a capital da cidade de embarque: ");





            }
        } while(opcao != 0);

        scan.close(); //fechar o Scanner no final

    }
}


