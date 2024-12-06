package SearchAlgorithms;

import Graph.Graph;
import Graph.Vertex;
import java.util.ArrayList;

public  class DFS {
    private Graph graph;
    private ArrayList<Vertex> visited = new ArrayList<>();
    private ArrayList<Vertex> visitLine = new ArrayList<>();
    private ArrayList<Vertex> altWay = new ArrayList<>();
    public DFS(Graph graph, String initialVertex, String finalVertex) {
        System.out.println("\n\n\n---------------DFS---------------");
        this.graph = graph;
        runDFS(initialVertex, finalVertex);
        altWay(finalVertex);
    }

    //Procura o VERTEX no grafo a pertir do nome.
    public Vertex searchFor(String vertex) throws VertexNotFoundException {
        for (Vertex v : getGraph().getVertices()) {
            if (v.getName().equals(vertex)) {
                return v; 
            }
        }
        throw new VertexNotFoundException("Vértice '" + vertex + "' não encontrado.");
    }

    //Visita o VERTEX.
    public void visiting(){
        Vertex v = visitLine.get(visitLine.size() - 1); //ultimo elemento da lista
        System.out.println("\nVisiting: " + v.getName());
        
        

        investigate(v);

        visitLine.remove(v);
        visited.add(v);
    }

    //Investiga os filhos do VERTEX
    public void investigate(Vertex vistingVertex){
        for(Vertex v : vistingVertex.getLeaving()){
            if(!visited.contains(v) && !visitLine.contains(v)){
                v.setPredecessor(vistingVertex);
                visitLine.add(v);
            }
        }
    }

    //EXECUTE
    public void runDFS(String initialVertex, String finalVertex) {
        
        try {
            visitLine.add(searchFor(initialVertex));
            Vertex target = searchFor(finalVertex); //target
            while (!visitLine.isEmpty() && !visited.contains(target)) {
                visiting();
                
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //Acha um caminho alternativo.
    public void altWay(String finalVertex){
            
        try {
            Vertex vertex = searchFor(finalVertex);
            altWay.add(vertex);


            while (vertex.getPredecessor() != null) {
                altWay.add(vertex.getPredecessor());
                vertex = vertex.getPredecessor();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

        //Tabela de Resultados do DFS
        public void showResult(){
            System.out.print("\n\nVISIT LINE: [");
            for(Vertex v : visitLine){
                System.out.print(" " + ANSI_CYAN + v.getName() + ANSI_RESET + " ");
            }
            System.out.println("]");
                  
            System.out.print("\n\nDFS RESULT: [");
            for(Vertex v : visited){
                System.out.print(" " + ANSI_CYAN + v.getName() + ANSI_RESET + " ");
            }
            System.out.println("]");
    
            System.out.print("\n\nALTERNATIVE WAY: [");
            for(Vertex v : altWay){
                System.out.print(" " + ANSI_CYAN + v.getName() + ANSI_RESET + " ");
            }
            System.out.println("]");
    
        }

    public Graph getGraph() {
        return graph;
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    public ArrayList<Vertex> getVisited() {
        return visited;
    }
    public ArrayList<Vertex> getVisitLine() {
        return visitLine;
    }
    public ArrayList<Vertex> getAltWay() {
        return altWay;
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
