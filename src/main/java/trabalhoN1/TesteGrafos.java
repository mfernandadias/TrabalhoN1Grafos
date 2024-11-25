package trabalhoN1;

public class TesteGrafos {
    public static void main(String[] args){

        Grafo grafo = new Grafo(30); //número de capitais


        grafo.cadastrarVertice("Porto Alegre");
        grafo.cadastrarVertice("Florianópolis");
        grafo.cadastrarVertice("Curitiba");
        grafo.cadastrarVertice("São Paulo");
        grafo.cadastrarVertice("Rio deJaneiro");
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

        grafo.mostrarCapitais();


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
        grafo.cadastrarAresta(1, 4, 1140, "Avião", 450);  // Florianópolis -> Rio de Janeiro (Avião)

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
        grafo.cadastrarAresta(3, 6, 1008, "Avião", 450);   // São Paulo -> Vitória (Avião)
        grafo.cadastrarAresta(3, 7, 1968, "Avião", 800);   // São Paulo -> Salvador (Avião)
        grafo.cadastrarAresta(3, 8, 2178, "Avião", 850);   // São Paulo -> Aracaju (Avião)
        grafo.cadastrarAresta(3, 9, 2311, "Avião", 900);   // São Paulo -> Maceió (Avião)
        grafo.cadastrarAresta(3, 10, 2484, "Avião", 950);  // São Paulo -> Recife (Avião)
        grafo.cadastrarAresta(3, 11, 2604, "Avião", 1000); // São Paulo -> João Pessoa (Avião)
        grafo.cadastrarAresta(3, 12, 2736, "Avião", 1050); // São Paulo -> Natal (Avião)
        grafo.cadastrarAresta(3, 13, 3113, "Avião", 1200); // São Paulo -> Fortaleza (Avião)
        grafo.cadastrarAresta(3, 14, 2960, "Avião", 1150); // São Paulo -> Teresina (Avião)
        grafo.cadastrarAresta(3, 15, 2910, "Avião", 1100); // São Paulo -> São Luís (Avião)
        grafo.cadastrarAresta(3, 16, 3238, "Avião", 1250); // São Paulo -> Belém (Avião)
        grafo.cadastrarAresta(3, 17, 3513, "Avião", 1300); // São Paulo -> Macapá (Avião)
        grafo.cadastrarAresta(3, 18, 1550, "Avião", 600);  // São Paulo -> Palmas (Avião)
        grafo.cadastrarAresta(3, 19, 2700, "Avião", 1000); // São Paulo -> Manaus (Avião)
        grafo.cadastrarAresta(3, 20, 2992, "Avião", 1100); // São Paulo -> Boa Vista (Avião)
        grafo.cadastrarAresta(3, 21, 3205, "Avião", 1150); // São Paulo -> Rio Branco (Avião)
        grafo.cadastrarAresta(3, 22, 3030, "Avião", 1150); // São Paulo -> Porto Velho (Avião)
        grafo.cadastrarAresta(3, 23, 1327, "Avião", 500);  // São Paulo -> Cuiabá (Avião)
        grafo.cadastrarAresta(3, 24, 1014, "Avião", 400);  // São Paulo -> Campo Grande (Avião)
        grafo.cadastrarAresta(3, 25, 874, "Avião", 350);   // São Paulo -> Goiânia (Avião)
        grafo.cadastrarAresta(3, 26, 874, "Avião", 350);   // São Paulo -> Brasília (Avião)

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

        // Salvador
        grafo.cadastrarAresta(7, 8, 356, "Ônibus", 120);  // Salvador -> Aracaju (Ônibus)
        grafo.cadastrarAresta(7, 9, 531, "Avião", 200);   // Salvador -> Maceió (Avião)
        grafo.cadastrarAresta(7, 10, 805, "Avião", 300);  // Salvador -> Recife (Avião)

        // Aracaju
        grafo.cadastrarAresta(8, 9, 294, "Ônibus", 100);  // Aracaju -> Maceió (Ônibus)
        grafo.cadastrarAresta(8, 10, 501, "Avião", 250);  // Aracaju -> Recife (Avião)

        // Maceió
        grafo.cadastrarAresta(9, 10, 285, "Ônibus", 90);  // Maceió -> Recife (Ônibus)
        grafo.cadastrarAresta(9, 11, 564, "Avião", 200);  // Maceió -> João Pessoa (Avião)

        // Recife
        grafo.cadastrarAresta(10, 11, 120, "Ônibus", 50);  // Recife -> João Pessoa (Ônibus)
        grafo.cadastrarAresta(10, 12, 297, "Avião", 150);  // Recife -> Natal (Avião)

        // João Pessoa
        grafo.cadastrarAresta(11, 12, 185, "Ônibus", 60);  // João Pessoa -> Natal (Ônibus)
        grafo.cadastrarAresta(11, 13, 718, "Avião", 250);  // João Pessoa -> Fortaleza (Avião)

        // Natal
        grafo.cadastrarAresta(12, 13, 520, "Ônibus", 180); // Natal -> Fortaleza (Ônibus)

        // Fortaleza
        grafo.cadastrarAresta(13, 14, 902, "Avião", 300);  // Fortaleza -> Teresina (Avião)

        // Teresina
        grafo.cadastrarAresta(14, 15, 828, "Avião", 250);  // Teresina -> São Luís (Avião)


        grafo.listarDadosGrafo();

        System.out.println(" __________________________  ");

        System.out.println(" __________________________  ");

        grafo.mostrarMatrizAdjacencia();


    }
}
