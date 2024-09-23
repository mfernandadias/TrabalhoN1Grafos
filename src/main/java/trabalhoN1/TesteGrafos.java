package trabalhoN1;

public class TesteGrafos {
    public static void main(String[] args){

        Grafo grafo = new Grafo(10); //número de capitais

        //adicinando capitais (vértices)
        grafo.adicionarVertice("Porto Alegre ");
        grafo.adicionarVertice("Florianópolis");
        grafo.adicionarVertice("Curitiba");
        grafo.adicionarVertice("São Paulo");

        // Adicionando distâncias e opções de transporte
        grafo.adicionarAresta(0, 1, 376, "Ônibus", 150); // Porto Alegre -> Florianópolis
        grafo.adicionarAresta(0, 3, 1115, "Avião", 600); // Porto Alegre -> São Paulo (Avião)
        grafo.adicionarAresta(0, 3, 1115, "Ônibus", 300); // Porto Alegre -> São Paulo (Ônibus)
        grafo.adicionarAresta(1, 2, 300, "Ônibus", 120);  // Florianópolis -> Curitiba
        grafo.adicionarAresta(2, 3, 408, "Avião", 400);   // Curitiba -> São Paulo (Avião)
        grafo.adicionarAresta(2, 3, 408, "Ônibus", 180);  // Curitiba -> São Paulo (Ônibus)


    }
}
