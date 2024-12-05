import Graph.Graph;
import SearchAlgorithms.BFS;
import SearchAlgorithms.DFS;

public class App {
    public static void main(String[] args) throws Exception {
         // Criando um grafo com 4 vértices
         Graph graph = new Graph(5);


        graph.automatic();


        // Imprime a matriz de conexão (matriz de adjacência)
        graph.printConnectMat();

        // // Imprime a conexão de todos os vértices
        // graph.printVertexConnections();

        // // Imprime a conexão de todas as arestas
        // graph.printEdgeConnections();


        // // Lista de Adjacência
        // graph.adjacencyList();

        // // Lista de arestas
        // graph.edgeList();

        BFS bfs = new BFS(graph, "v1", "v2");
        bfs.showResult();

        graph.graphClean();

        DFS dfs = new DFS(graph, "v1", "v2");
        dfs.showResult();

        graph.graphClean();
        }
}
