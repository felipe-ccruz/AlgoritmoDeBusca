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
        }
        showVisited();
    }

    // Exibe no console a lista de vértices visitados em ordem
    public void showVisited() {
        System.out.println("\n\nVisited: ");
        System.out.print(ANSI_CYAN + "[ ");
        for(Vertex v : visited){
            System.out.print(v.getName() + "  ");
        }
        System.out.println("]" + ANSI_RESET);
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

            // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
}
