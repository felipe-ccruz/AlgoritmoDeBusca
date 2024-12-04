package Graph;
import java.util.ArrayList;

public class Vertex {
    private String name;
    private Vertex predecessor;
    private ArrayList<Vertex> entering;
    private ArrayList<Vertex> leaving;
    public Vertex(String name) {
        this.name = name;
        this.entering = new ArrayList<Vertex>();
        this.leaving = new ArrayList<Vertex>();
    }
    
    public void addEnteringVertex(Vertex vertex) {
        entering.add(vertex);
    }

    public void addLeavingVertex(Vertex vertex) {
        leaving.add(vertex);
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
}
