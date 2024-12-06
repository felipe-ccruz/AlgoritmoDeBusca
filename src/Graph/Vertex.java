package Graph;
import java.util.ArrayList;

public class Vertex {
    private String name;
    private Vertex predecessor;
    private int smalDistance;
    private ArrayList<Vertex> entering;
    private ArrayList<Vertex> leaving;
    private ArrayList<Edge> edges;
    public Vertex(String name) {
        this.name = name;
        this.entering = new ArrayList<Vertex>();
        this.leaving = new ArrayList<Vertex>();
        this.edges = new ArrayList<Edge>();
    }
    
    public void addEnteringVertex(Vertex vertex) {
        entering.add(vertex);
    }

    public void addLeavingVertex(Vertex vertex) {
        leaving.add(vertex);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
    
    public void printEnteringVertex() {

        for (Vertex v : entering) {
            System.out.print(" " + v.getName() + " ");
        }
    }

    public void printLeavingVertex() {
        for (Vertex v : leaving) {
            System.out.print(" " + v.getName() + " ");
        }
    }

    public void printEdges() {
        for (Edge e : edges) {
            System.out.print(" " + e.getName() + " ");
        }
    }

    public void printStatus(){
        System.out.println("\n\n-----------------------VERTEX--" + getName() + "-----------------------");
        System.out.println("- LEAVING:");
        System.out.print("  [");
        printLeavingVertex();
        System.out.println("]\n");

        System.out.println("- ENTERING:");
        System.out.print("  [");
        printEnteringVertex();
        System.out.println("]\n");

        System.out.println("- EDGES:");
        System.out.print("  [");
        printEdges();
        System.out.println("]\n");
    }


    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Vertex> getEntering() {
        return entering;
    }
    public ArrayList<Vertex> getLeaving() {
        return leaving;
    }
    public Vertex getPredecessor() {
        return predecessor;
    }
    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }
    public int getSmalDistance() {
        return smalDistance;
    }
    public void setSmalDistance(int smalDistance) {
        this.smalDistance = smalDistance;
    }
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    
}
