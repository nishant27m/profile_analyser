package com.practice.test.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShortestPath {
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int noOfQueries = scanner.nextInt();
        ShortestPath sPath = new ShortestPath();
        Graph[] graphs = new Graph[noOfQueries];
        for(int index = 0; index < noOfQueries; index++) {
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            Graph graph = new Graph(nodes);
            graphs[index] = graph;
            for(int no = 0; no < edges; no++) {
                int startVertex = scanner.nextInt();
                int endVertex = scanner.nextInt();
                if(!graph.nodesMap.containsKey(startVertex)) {
                	graph.nodesMap.put(startVertex, Integer.MAX_VALUE);
                }
                if(!graph.nodesMap.containsKey(endVertex)) {
                	graph.nodesMap.put(endVertex, Integer.MAX_VALUE);
                }

                WeightedEdge weightedEdge = new WeightedEdge(startVertex, endVertex, 6);
                graph.addWeightedEdge(weightedEdge);
            }
            graph.startNode = scanner.nextInt();
            sPath.printShortestPath(graph);
        }
        scanner.close();
    }

	void printShortestPath(Graph graph) {
		int currentNode = graph.startNode;
		extractNode(currentNode);
		graph.pathMap.put(currentNode, null);
		graph.weightMap.put(currentNode, 0);
		graph.list.stream().filter(edge -> edge.startVertex == currentNode)
						   .forEach(node -> {
							   graph.pathMap.put(node.endVertex, node.startVertex);
							   graph.weightMap.put(node.endVertex, node.weight);
						   });
	}
	
	void extractNode(int nodeName) {
		
	}

}	
class WeightedEdge {
	
    int startVertex;
    
    int endVertex;
    
    int weight;
    
    public WeightedEdge(int startVertex, int endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }
}

class Graph {
	
    List<WeightedEdge> list = new ArrayList<>();
    
    Map<Integer, Integer> pathMap = new HashMap<>();
	
	Map<Integer, Integer> weightMap = new HashMap<>();
	
	Map<Integer, Integer> nodesMap = new HashMap<>();
    
    int nodes;
    
    int startNode;
    
    Graph(int nodes) {
    	this.nodes = nodes;
    }
    
    void addWeightedEdge(WeightedEdge edge) {
        list.add(edge);
    }
    
}
