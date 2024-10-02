package trabalhoN1;

public class TesteGrafos {
    public static void main(String[] args){

        Grafo grafo = new Grafo(30); //número de capitais


        grafo.cadastrarVertice("Porto_Alegre");
        grafo.cadastrarVertice("Florianópolis");
        grafo.cadastrarVertice("Curitiba");
        grafo.cadastrarVertice("São_Paulo");
        grafo.cadastrarVertice("Rio_de_Janeiro");
        grafo.cadastrarVertice("Belo_Horizonte");
        grafo.cadastrarVertice("Vitória");
        grafo.cadastrarVertice("Salvador");
        grafo.cadastrarVertice("Aracaju");
        grafo.cadastrarVertice("Maceió");
        grafo.cadastrarVertice("Recife");
        grafo.cadastrarVertice("João_Pessoa");
        grafo.cadastrarVertice("Natal");
        grafo.cadastrarVertice("Fortaleza");
        grafo.cadastrarVertice("Teresina");
        grafo.cadastrarVertice("São_Luís");
        grafo.cadastrarVertice("Belém");
        grafo.cadastrarVertice("Macapá");
        grafo.cadastrarVertice("Palmas");
        grafo.cadastrarVertice("Manaus");
        grafo.cadastrarVertice("Boa_Vista");
        grafo.cadastrarVertice("Rio_Branco");
        grafo.cadastrarVertice("Porto_Velho");
        grafo.cadastrarVertice("Cuiabá");
        grafo.cadastrarVertice("Campo_Grande");
        grafo.cadastrarVertice("Goiânia");
        grafo.cadastrarVertice("Brasília");

        grafo.mostrarCapitais();


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


        grafo.listarDadosGrafo();

        System.out.println(" __________________________  ");

        System.out.println(" __________________________  ");

        grafo.mostrarMatrizAdjacencia();


    }
}
