package trabalhoN1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Dijkstra {
    /*
    algoritmo Dijkstra necessita receber uma indiceOrigem e indiceDestino
    primeiro preciso confirmar que são  validos e que esses indices existem
    int validados
    o algoritmo vai chegar no inteiro e percorrer seu vizinho
    vai guardar sua menor distancia
    quando chegar ao indice de destino vai retornar para o usuario o caminho

    necessita ser mostrado na tela todos os caminhos no final
    exemplo:
    caminhos que a distancia são maior até chegar ao destino final

    vou criar uma classe dijkstra
    depois vou chamar o método no meu menu
    o usuário vai inserir os indices

     */
    public static void encontrarMenorCaminho(Grafo grafo, int indiceOrigem, int indiceDestino) {
        //validar [indices de ntrada
        if (indiceOrigem < 0 || indiceOrigem >= grafo.getVertices().size() ||
                indiceDestino < 0 || indiceDestino >= grafo.getVertices().size()) {
            System.out.println("Índices inválidos! Verifique os vértices informados.");
            return;
        }

        int numVertices = grafo.getVertices().size();
        int[] distancias = new int[numVertices];
        boolean[] visitados = new boolean[numVertices];
        int[] anteriores = new int[numVertices];

        //inicializar distâncias e anteriores
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(anteriores, -1);

        distancias[indiceOrigem] = 0;

        //System.out.println("Iniciando Dijkstra com origem em: " + grafo.getVertice(indiceOrigem).getNome());
        //algortimo principal
        for (int i = 0; i < numVertices; i++) {
            int atual = encontrarMenorDistancia(distancias, visitados);
            if (atual == -1) break;//se não há mais vértices para visitar, sair do loop

            //System.out.println("Vértice atual: " + grafo.getVertice(atual).getNome());
            visitados[atual] = true;

            for (int j = 0; j < numVertices; j++) {
                Aresta aresta = grafo.getAresta(atual, j); //obter aresta entre os vértices
                if (aresta != null && !visitados[j]) {
                    int novaDistancia = distancias[atual] + aresta.getDistancia();

                    // Log da tentativa de atualização da distância
                   // System.out.println("Verificando aresta de " + grafo.getVertice(atual).getNome() +
                           // " para " + grafo.getVertice(j).getNome() + " com distância " +
                            //aresta.getDistancia() + ". Distância atual: " + distancias[j] + " -> Nova distância: " + novaDistancia);

                    if (novaDistancia < distancias[j]) {
                        //distancias[j] = novaDistancia;
                        anteriores[j] = atual;
                        //System.out.println("Atualizando distância de " + grafo.getVertice(j).getNome() +
                               // " para " + novaDistancia);
                    }
                }
            }
        }
        //exibir resultados
        mostrarCaminhos(grafo, indiceOrigem, indiceDestino, distancias, anteriores);
    }

    private static int encontrarMenorDistancia(int[] distancias, boolean[] visitados) {
        int menorDistancia = Integer.MAX_VALUE;
        int indice = -1;
        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] < menorDistancia) {
                menorDistancia = distancias[i];
                indice = i;
            }
        }
        return indice;
    }

    private static void mostrarCaminhos(Grafo grafo, int origem, int destino, int[] distancias, int[] anteriores) {
        System.out.println("\nDistâncias finais:");
        for (int i = 0; i < distancias.length; i++) {
            System.out.printf("Do vértice %s até %s: %d\n",
                    grafo.getVertice(origem).getNome(),
                    grafo.getVertice(i).getNome(),
                   // distancias[i]);
                    distancias[i] == Integer.MAX_VALUE ? -1 : distancias[i]); // Mostrar -1 se não houver caminho

        }

        System.out.println("\nCaminho mais curto do vértice " +
                grafo.getVertice(origem).getNome() + " até " +
                grafo.getVertice(destino).getNome() + ":");

        List<Integer> caminho = new ArrayList<>();
        for (int i = destino; i != -1; i = anteriores[i]) {
            caminho.add(0, i);
        }

        if (distancias[destino] == Integer.MAX_VALUE) {
            System.out.println("Não há caminho disponível!");
        } else {
            for (int i = 0; i < caminho.size(); i++) {
                System.out.print(grafo.getVertice(caminho.get(i)).getNome());
                if (i < caminho.size() - 1) System.out.print(" -> ");
            }
            System.out.println("\nDistância total: " + distancias[destino]);
        }
    }


}




