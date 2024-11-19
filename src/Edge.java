public class Edge {
    String name;
    Vertex source;
    Vertex target;
    public Edge(String name) {
        this.name = name;
    }

    public void printInfo(){
        System.out.print("[" + getSource().getName() + ", " + getTarget().getName() + "]");
    }

    public void printStatus() {
        System.out.println("\n\n-----------------------EDGE--" + getName() + "-----------------------");
        System.out.println("- SOURCE: " + source.getName());
        System.out.println("- TARGET: " + target.getName());
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
}