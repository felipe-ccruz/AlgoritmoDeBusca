package Graph;
public class Edge {
    String name;
    Vertex source;
    Vertex target;
    int weight;
    public Edge(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void printInfo(){
        System.out.print("[" + getSource().getName() + ", " + getTarget().getName() + "]");
    }

    public void printStatus() {
        System.out.println("\n\n-----------------------EDGE--" + getName() + "-----------------------");
        System.out.println("- SOURCE: " + source.getName());
        System.out.println("- TARGET: " + target.getName());
        System.out.println("- WEIGHT: " + weight);
        System.out.println("-------------------------");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Vertex getSource() {
        return source;
    }
    public void setSource(Vertex source) {
        this.source = source;
    }
    public Vertex getTarget() {
        return target;
    }
    public void setTarget(Vertex target) {
        this.target = target;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}