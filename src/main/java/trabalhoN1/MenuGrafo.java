package trabalhoN1;

import java.util.Scanner;

public class MenuGrafo {
    public static void main(String[] args) {

        Grafo grafo = new Grafo(30); //número de capitais

        //adicinando capitais (vértices)
        grafo.cadastrarVertice("Porto Alegre");
        grafo.cadastrarVertice("Florianópolis");
        grafo.cadastrarVertice("Curitiba");
        grafo.cadastrarVertice("São Paulo");
        grafo.cadastrarVertice("Rio de Janeiro");
        grafo.cadastrarVertice("Belo Horizonte");
        grafo.cadastrarVertice("Vitória");
        grafo.cadastrarVertice("Salvador");
        grafo.cadastrarVertice("Aracaju");
        grafo.cadastrarVertice("Maceió");
        grafo.cadastrarVertice("Recife");
        grafo.cadastrarVertice("João Pessoa");
        grafo.cadastrarVertice("Natal");
        grafo.cadastrarVertice("Fortaleza");
        grafo.cadastrarVertice("Teresina");
        grafo.cadastrarVertice("São Luís");
        grafo.cadastrarVertice("Belém");
        grafo.cadastrarVertice("Macapá");
        grafo.cadastrarVertice("Palmas");
        grafo.cadastrarVertice("Manaus");
        grafo.cadastrarVertice("Boa Vista");
        grafo.cadastrarVertice("Rio Branco");
        grafo.cadastrarVertice("Porto Velho");
        grafo.cadastrarVertice("Cuiabá");
        grafo.cadastrarVertice("Campo Grande");
        grafo.cadastrarVertice("Goiânia");
        grafo.cadastrarVertice("Brasília");



        // Adicionando distâncias e opções de transporte
        grafo.cadastrarAresta(0, 1, 376, "Ônibus", 150); // Porto Alegre -> Florianópolis
        grafo.cadastrarAresta(0, 3, 1115, "Avião", 600); // Porto Alegre -> São Paulo (Avião)
        grafo.cadastrarAresta(0, 3, 1115, "Ônibus", 300); // Porto Alegre -> São Paulo (Ônibus)
        grafo.cadastrarAresta(1, 2, 300, "Ônibus", 120);  // Florianópolis -> Curitiba
        grafo.cadastrarAresta(2, 3, 408, "Avião", 400);   // Curitiba -> São Paulo (Avião)
        grafo.cadastrarAresta(2, 3, 408, "Ônibus", 180);  // Curitiba -> São Paulo (Ônibus)
        // Porto Alegre
        grafo.cadastrarAresta(0, 1, 376, "Ônibus", 150);  // Porto Alegre -> Florianópolis (Ônibus)
        grafo.cadastrarAresta(0, 1, 376, "Avião", 250);   // Porto Alegre -> Florianópolis (Avião)
        grafo.cadastrarAresta(0, 3, 1100, "Avião", 400);  // Porto Alegre -> São Paulo (Avião)
        grafo.cadastrarAresta(0, 4, 1146, "Avião", 500);  // Porto Alegre -> Rio de Janeiro (Avião)
        grafo.cadastrarAresta(0, 2, 680, "Avião", 300);   // Porto Alegre -> Curitiba (Avião)

        // Florianópolis
        grafo.cadastrarAresta(1, 0, 376, "Ônibus", 150);   // Florianópolis -> Porto Alegre (Ônibus)
        grafo.cadastrarAresta(1, 2, 300, "Avião", 200);    // Florianópolis -> Curitiba (Avião)
        grafo.cadastrarAresta(1, 3, 704, "Avião", 350);    // Florianópolis -> São Paulo (Avião)

        // Curitiba
        grafo.cadastrarAresta(2, 1, 300, "Ônibus", 120);    // Curitiba -> Florianópolis (Ônibus)
        grafo.cadastrarAresta(2, 0, 680, "Avião", 300);     // Curitiba -> Porto Alegre (Avião)
        grafo.cadastrarAresta(2, 3, 700, "Avião", 350);     // Curitiba -> São Paulo (Avião)
        grafo.cadastrarAresta(2, 4, 800, "Avião", 400);     // Curitiba -> Rio de Janeiro (Avião)

        // São Paulo
        grafo.cadastrarAresta(3, 0, 1100, "Avião", 400);    // São Paulo -> Porto Alegre (Avião)
        grafo.cadastrarAresta(3, 1, 704, "Avião", 350);     // São Paulo -> Florianópolis (Avião)
        grafo.cadastrarAresta(3, 2, 700, "Avião", 350);     // São Paulo -> Curitiba (Avião)
        grafo.cadastrarAresta(3, 4, 450, "Avião", 250);     // São Paulo -> Rio de Janeiro (Avião)
        grafo.cadastrarAresta(3, 5, 4000, "Avião", 800);    // São Paulo -> Rio Branco (Avião)

        // Rio de Janeiro
        grafo.cadastrarAresta(4, 3, 450, "Ônibus", 200);     // Rio de Janeiro -> São Paulo (Ônibus)
        grafo.cadastrarAresta(4, 1, 1146, "Avião", 500);     // Rio de Janeiro -> Florianópolis (Avião)
        grafo.cadastrarAresta(4, 2, 800, "Avião", 400);      // Rio de Janeiro -> Curitiba (Avião)

        // Brasília
        grafo.cadastrarAresta(5, 3, 1000, "Avião", 500);     // Brasília -> São Paulo (Avião)
        grafo.cadastrarAresta(5, 4, 1000, "Avião", 500);     // Brasília -> Rio de Janeiro (Avião)
        grafo.cadastrarAresta(5, 6, 1200, "Avião", 600);     // Brasília -> Goiânia (Avião)

        // Goiânia
        grafo.cadastrarAresta(6, 5, 1200, "Ônibus", 350);     // Goiânia -> Brasília (Ônibus)
        grafo.cadastrarAresta(6, 7, 500, "Avião", 250);       // Goiânia -> Belo Horizonte (Avião)

        // Belo Horizonte
        grafo.cadastrarAresta(7, 6, 500, "Ônibus", 200);     // Belo Horizonte -> Goiânia (Ônibus)
        grafo.cadastrarAresta(7, 3, 600, "Avião", 300);      // Belo Horizonte -> São Paulo (Avião)

       // Outros destinos (exemplo)
        grafo.cadastrarAresta(5, 8, 2000, "Avião", 700);     // Brasília -> Manaus (Avião)
        grafo.cadastrarAresta(8, 7, 3000, "Avião", 900);     // Manaus -> Belo Horizonte (Avião)

        Scanner scan = new Scanner(System.in);
        //Grafo grafo = new Grafo(10);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.print("Escolha uma opção: ");
            System.out.println("   ");

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
            System.out.println("13. Método que mostrar as opções de conexões entre duas capitais");
            System.out.println("14. Todas as viagens disponivéis  para uma Capital especifica ");
            System.out.println("15. Todas as viagens disponiveis na Capital de embarque");
            System.out.println("0. Sair");
            System.out.println("  ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Capitais do Brasil");
                    grafo.mostrarCapitais();
                    break;
                case 2:
                    System.out.println("Digite o nome do vértice: ");
                    scan.nextLine();
                    String nomeVertice = scan.nextLine();
                    grafo.cadastrarVertice(nomeVertice);
                    break;
                case 3:
                    grafo.mostrarCapitais();
                    System.out.print("Digite o índice do vértice de origem: ");
                    int origem = scan.nextInt();
                    scan.nextLine(); // Limpa o buffer de entrada
                    System.out.print("Digite o índice do vértice de destino: ");
                    int destino = scan.nextInt();
                    scan.nextLine(); // Limpa o buffer de entrada
                    System.out.print("Digite a distância entre as capitais: ");
                    int distancia = scan.nextInt();
                    scan.nextLine(); // Limpa o buffer de entrada
                    System.out.print("Digite o tipo de transporte (Ônibus, Avião): ");
                    String transporte = scan.nextLine(); // Captura o tipo de transporte
                    System.out.print("Digite o preço do transporte: ");
                    int preco = scan.nextInt();
                    scan.nextLine(); // Limpa o buffer de entrada

                    grafo.cadastrarAresta(origem, destino, distancia, transporte, preco);
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
                    System.out.println("Digite a capital da cidade de embarque: ");


            }
        } while(opcao != 0);

        scan.close(); //fechar o Scanner no final

    }
}


