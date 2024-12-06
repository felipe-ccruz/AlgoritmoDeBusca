package SearchAlgorithms;

import java.util.*;

import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;

public class Dijkstra {
    private Graph graph;
    private Map<Vertex, Integer> distances = new HashMap<>();
    private PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

    public Dijkstra(Graph graph) {
        System.out.println("\n\n\n---------------Dijkstra---------------\n\n");
        this.graph = graph;
    }

    public void runDijkstra(String initialVertexName, String finalVertexName) {
        try {
            Vertex initialVertex = searchFor(initialVertexName);
            Vertex targetVertex = searchFor(finalVertexName);
            runDistances(initialVertex);
            queue.add(initialVertex);

            while (!queue.isEmpty()) {
                Vertex current = queue.poll();

                if (current.equals(targetVertex)) break;

                for (Edge edge : current.getEdges()) {
                    relaxEdge(current, edge);
                }
            }
            showResults( initialVertex, targetVertex);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void runDistances(Vertex initialVertex) {
        for (Vertex v : graph.getVertices()) {
            distances.put(v, Integer.MAX_VALUE);
        }
        distances.put(initialVertex, 0);
    }

    private void relaxEdge(Vertex current, Edge edge) {
        Vertex neighbor = edge.getTarget();
        int newDist = distances.get(current) + edge.getWeight();
        if (newDist < distances.get(neighbor)) {
            distances.put(neighbor, newDist);
            neighbor.setPredecessor(current);
            queue.add(neighbor);
        }
    }

    // Busca um vértice pelo nome
    public Vertex searchFor(String vertexName) throws VertexNotFoundException {
        for (Vertex v : graph.getVertices()) {
            if (v.getName().equals(vertexName)) {
                return v;
            }
        }
        throw new VertexNotFoundException("Vértice '" + vertexName + "' não encontrado.");
    }

    public void showResults(Vertex initialVertex, Vertex targetVertex) {
        System.out.printf("%-10s | %-10s | %-15s%n", "Vértice", "Distância", "Predecessor");
        System.out.println("--------------------------------------------");
    
        for (Vertex v : graph.getVertices()) {
            String predecessorName = (v.getPredecessor() != null) ? v.getPredecessor().getName() : "null";
            System.out.printf("%-10s | %-10d | %-15s%n", v.getName(), distances.get(v), predecessorName);
        }
    
        // Imprimir caminho do source ao target
        printShortestPath(initialVertex, targetVertex);
    }
    
    // Função para imprimir o caminho mais curto até o target
    public void printShortestPath(Vertex initialVertex, Vertex target) {
        List<String> path = new ArrayList<>();
        Vertex step = target;
    
        while (step != null) {
            path.add(step.getName());
            step = step.getPredecessor();
        }
        Collections.reverse(path);
        System.out.println("\nCaminho mais curto: " + String.join(" -> ", path));
        System.out.println("Distância total: " + distances.get(target));
    }
    
}
