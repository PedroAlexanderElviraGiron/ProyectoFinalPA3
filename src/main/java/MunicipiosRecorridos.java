/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
/**
 *
 * @author Pedro
 */
public class MunicipiosRecorridos {
   private int[][] graph;
    private int numVertices;

    public MunicipiosRecorridos(int[][] graph) {
        this.graph = graph;
        this.numVertices = graph.length;
    }

    public void findShortestPaths(int source) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int minDistance = findMinDistance(distances, visited);
            visited[minDistance] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && graph[minDistance][j] != 0 &&
                    distances[minDistance] != Integer.MAX_VALUE &&
                    distances[minDistance] + graph[minDistance][j] < distances[j]) {
                    distances[j] = distances[minDistance] + graph[minDistance][j];
                }
            }
        }

        printShortestPaths(distances);
    }

    private int findMinDistance(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && distances[i] <= minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printShortestPaths(int[] distances) {
         String[] paises = {"Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Ecuador", "Guyana", "Paraguay", "Perú", "Surinam", "Uruguay", "Venezuela"};
        System.out.println("Piases de Sur America:");

        for (int i = 0; i < numVertices; i++) {
            System.out.println("Pais " +paises[i]  + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] graph = {
            //Municipios con distancias entre si
            { 0, 20, 89, 44, 10, 5, 2, 52, 7, 11, 15, 24, 18 },   // País 0: Argentina
            { 4, 23, 4, 2, 11, 4, 10, 89, 91, 0, 18, 2, 88 },   // País 1: Bolivia
            { 8, 24, 1, 3, 58, 3, 71, 88, 20, 1, 17, 5, 8 },   // País 2: Brasil
            { 8, 26, 3, 21, 118, 50, 7, 0, 25, 5, 16, 7, 6 },   // País 3: Chile
            { 7, 31, 4, 89, 95, 0, 73, 1, 27, 45, 14, 8, 5 },   // País 4: Colombia
            { 6, 35, 6, 68, 63, 8, 74, 2, 29, 47, 16, 62, 4 },   // País 5: Ecuador
            { 9, 38, 9, 20, 65, 90, 78, 3, 20, 49, 19, 56, 3 },   // País 6: Guyana
            { 20, 39, 11, 56, 25, 50, 79, 5, 24, 55, 15, 63, 2 },   // País 7: Paraguay
            { 10, 98, 12, 41, 29, 55, 73, 9, 65, 89, 13, 98, 1 },   // País 8: Peru
            { 11, 59, 15, 6, 33, 54, 76, 5, 89, 52, 12, 99, 65 },   // País 9: Surinam
            { 89, 56, 16, 8, 31, 52, 75, 8, 87, 25, 11, 12, 45 },   // País 10: Uruguay
            { 98, 85, 19, 25, 36, 51, 88, 52, 50, 1, 18, 15, 7 },   // País 11: Venezuela
          
            
            
        
                
        };
        
        String[] paises = {"Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Ecuador", "Guyana", "Paraguay", "Perú", "Surinam", "Uruguay", "Venezuela"};

        System.out.println("Países de América del Sur, ingrese el país a consultar:");
        for (int i = 0; i < paises.length; i++) {
            System.out.println((i + 0) + ". " + paises[i]);
        }
        
        System.out.print("Este seria la distancia entre Paises: ");
        int opcion = scanner.nextInt();

        MunicipiosRecorridos dijkstra = new MunicipiosRecorridos(graph);
        dijkstra.findShortestPaths(opcion);
    }
}