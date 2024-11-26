public class App {
    public static void main(String[] args) throws Exception {
         // Criando um grafo com 4 vértices
         Graph graph = new Graph(5);


        graph.automatic();


        // Imprime a matriz de conexão (matriz de adjacência)
        graph.printConnectMat();

        // Imprime a conexão de todos os vértices
        graph.printVertexConnections();

        // Imprime a conexão de todas as arestas
        // graph.printEdgeConnections();


        // Lista de Adjacência
        graph.adjacencyList();

        // Lista de arestas
        graph.edgeList();

        BFS bfs = new BFS(graph);
        bfs.run();
    }
}
