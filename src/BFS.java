import java.util.ArrayList;
import java.util.Random;

public class BFS {
    Graph graph;
    ArrayList<Vertex> visitLine = new ArrayList<>();
    ArrayList<Vertex> visited = new ArrayList<>();
    public BFS(Graph graph) {
        this.graph = graph;
    }

    // Determina de forma aleatória qual será o vértice inicial a ser visitado
    public Vertex firstVisit() {
        Random random = new Random();
        int first = random.nextInt(graph.getVertices().size());

        return graph.getVertices().get(first);
    }

    // Adiciona o vértice atual à lista de visitados e enfileira seus adjacentes ainda não visitados
    public void visit(Vertex vertex) {
        for(Vertex v : vertex.getLeaving()){
            if(!visited.contains(v) && !visitLine.contains(v)){
                visitLine.add(v);
            }
        }
        visited.add(vertex);
    }

    // Executa o algoritmo de BFS começando por um vértice inicial escolhido aleatoriamente
    public void run() {
        Vertex first = firstVisit();
        visitLine.add(first);
        while(!visitLine.isEmpty()){
            Vertex v = visitLine.get(0);
            visit(v);
            visitLine.remove(0);
            showVisited();
        }
    }

    // Exibe no console a lista de vértices visitados em ordem
    public void showVisited() {
        System.out.println("\n\nVISITED: ");
        System.out.print("[ ");
        for(Vertex v : visited){
            System.out.print(v.getName() + "  ");
        }
        System.out.println("]");
    }

    public Graph getGraph() {
        return graph;
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    public ArrayList<Vertex> getVisitLine() {
        return visitLine;
    }
    public ArrayList<Vertex> getVisited() {
        return visited;
    }   
}
