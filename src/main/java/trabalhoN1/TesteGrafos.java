package trabalhoN1;

public class TesteGrafos {
    public static void main(String[] args){

        Grafo grafo = new Grafo(10); //número de capitais


        grafo.cadastrarVertice("Porto Alegre ");
        grafo.cadastrarVertice("Florianópolis");
        grafo.cadastrarVertice("Curitiba");
        grafo.cadastrarVertice("São Paulo");

        grafo.mostrarCapitais();


        // Adicionando distâncias e opções de transporte
        grafo.cadastrarAresta(0, 1, 376, "Ônibus", 150); // Porto Alegre -> Florianópolis
        grafo.cadastrarAresta(0, 3, 1115, "Avião", 600); // Porto Alegre -> São Paulo (Avião)
        grafo.cadastrarAresta(0, 3, 1115, "Ônibus", 300); // Porto Alegre -> São Paulo (Ônibus)
        grafo.cadastrarAresta(1, 2, 300, "Ônibus", 120);  // Florianópolis -> Curitiba
        grafo.cadastrarAresta(2, 3, 408, "Avião", 400);   // Curitiba -> São Paulo (Avião)
        grafo.cadastrarAresta(2, 3, 408, "Ônibus", 180);  // Curitiba -> São Paulo (Ônibus)


    }
}
