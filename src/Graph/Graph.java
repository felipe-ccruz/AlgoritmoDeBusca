package Graph;
import java.util.ArrayList;
import java.util.Random;

public class Graph {
    private int[][] connections;
    public Graph(int numVertices) {
        vertexGenerator(numVertices);
        this.connections = new int[numVertices][numVertices];
        createConnectMat();
    }

    //ELEMENTS
    ArrayList<Vertex> vertices = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();


    //GENERATOR
    public void edgeGenerator(int numEdges) {
        Random r = new Random();

        for (int i = 0; i < numEdges; i++){
            Edge e = new Edge("e" + (i + 1), (r.nextInt(9) + 1) * 100);
            edges.add(e);
        }
    }

    public void vertexGenerator(int numVertices){
        for (int i = 0; i < numVertices; i++){
            Vertex v = new Vertex("v" + (i + 1));
            vertices.add(v);
        }
    }

    
    //MATRIX
    public void createConnectMat(){
        for (int i = 0; i < vertices.size(); i++){
            for(int j = 0; j < vertices.size(); j++){
                connections[i][j] = 0;
            }
        }
    }

    public void printConnectMat() {
        System.out.print("  ");
        for (Vertex v : vertices){
            System.out.print(" " + v.getName());
        }
        System.out.println();
        
        for (int i = 0; i < vertices.size(); i++){
            System.out.print(vertices.get(i).getName() + "[");
            for(int j = 0; j < vertices.size(); j++){
                if(connections[i][j] > 0){
                    System.out.print(" " + ANSI_GREEN + connections[i][j] + ANSI_RESET + " ");
                } else{
                    System.out.print(" " + connections[i][j] + " ");
                }  
            }
            System.out.println("]");
        }
    }


    //CONNECTION
    public void connect(Edge edge, int source, int target){
        Vertex tempSource = getVertices().get(source - 1);
        Vertex tempTarget = getVertices().get(target - 1);

        tempSource.addLeavingVertex(tempTarget);
        tempTarget.addEnteringVertex(tempSource);

        edge.setSource(tempSource);
        edge.setTarget(tempTarget);

        connections[vertices.indexOf(tempSource)][vertices.indexOf(tempTarget)] = connections[vertices.indexOf(tempSource)][vertices.indexOf(tempTarget)] + 1;
    }

    public void printVertexConnections(){
        for(Vertex v : vertices){
            v.printStatus();
        }
    }

    public void printEdgeConnections(){
        for(Edge e : edges){
            e.printStatus();
        }
    }


    //"IS" FUCTIONS
    // public void isLooping(){
    //     System.out.println("\n----------------LOOP--------------");
    //     for(int i = 0; i < vertices.size(); i++){
    //         if(connections[i][i] > 0){
    //             System.out.println("\nGraph has a loop at vertex: " + vertices.get(i).getName() + "\n");
    //         }
    //     }
    // }

    // public void isParallel(){
    //     System.out.println("\n----------------PARALLEL--------------");
    //     for(int i = 0; i < vertices.size(); i++){
    //         for(int j = 0; j < vertices.size(); j++){
    //             if(connections[i][j] > 1 ){
    //                 System.out.println("\nGraph has a parallel at vertex: " + vertices.get(i).getName() + " to " + vertices.get(j).getName() + "\n");
    //             }  else if(connections[i][j] == connections[j][i] && connections[i][j] > 0 && i != j){
    //                 System.out.println("\nGraph has a parallel at vertex: " + vertices.get(i).getName() + " to " + vertices.get(j).getName() + "\n");
    //             }
    //         }
    //     }
    // }

    // public void isIsolated(){
    //     System.out.println("\n----------------ISOLATED--------------");
         
    //     for(Vertex v : vertices){
    //         if(v.getLeaving().isEmpty() && v.getEntering().isEmpty()){
    //             System.out.println("\nGraph has an isolated vertex: " + v.getName() + "\n");
    //         }
    //     }
    // }


    //LISTS FUNCTION
    public void adjacencyList(){
        System.out.println("\n\n Vertex  |   adjacency list ");

        for(int i = 0; i < vertices.size(); i++){
            

            System.out.print("   " + vertices.get(i).getName() + "    |  ");

            System.out.print(ANSI_CYAN);
            vertices.get(i).printLeavingVertex();
            System.out.print(ANSI_RESET);
            
            System.out.println();

        }
    }

    public void edgeList(){
        System.out.println("\n\n Vertex  |    edge list ");

        for(int i = 0; i < vertices.size(); i++){

            Vertex tempVertex = vertices.get(i);
            

            System.out.print("   " + tempVertex.getName() + "    |  ");

            System.out.print(ANSI_CYAN);
            for(Edge edge : edges){
                if(edge.getSource().equals(tempVertex)){
                    edge.printInfo();
                }
            }
            System.out.print(ANSI_RESET + "\n");
        }
    }


    //AUTOMATIC
    public void automatic(){
        Random random = new Random();

        int numConnections = random.nextInt(vertices.size() * vertices.size()) + 10;

        edgeGenerator(numConnections);

        for(int i = 0; i < numConnections; i++){
            int source = random.nextInt(vertices.size()) + 1;
            int target = random.nextInt(vertices.size()) + 1;

            Edge tempEdge = edges.get(i);

            connect(tempEdge, source, target);
        }
    }
    

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
    public ArrayList<Edge> getEdges() {
        return edges;
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
