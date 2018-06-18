package cracking_the_coding_interview.chapter4;

import java.util.*;

import cracking_the_coding_interview.GraphNode;

public class RoteToNode {

	public static boolean dfs(GraphNode start, GraphNode end) {
		if (start == null || end == null) return false;
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		return helper(start, end, visited);
	}
	
	private static boolean helper(GraphNode start, GraphNode end, HashSet<GraphNode> visited) {
		if (start == end) return true;
		visited.add(start);
		for (GraphNode child : start.neighbors) {
			if (visited.contains(child)) continue;
			if (helper(child, end, visited)) return true;
		}
		return false;
	}
	
	public static boolean bfs(GraphNode start, GraphNode end) {
		if (start == null || end == null) return false;
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			GraphNode node = queue.poll();
			if (node == end) return true;
			visited.add(node);
			for (GraphNode child : node.neighbors) {
				if (visited.contains(child)) continue;
				queue.offer(child);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		GraphNode node0 = new GraphNode(0);
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		
		node0.neighbors.add(node1);
		node0.neighbors.add(node2);
		node2.neighbors.add(node3);
		node3.neighbors.add(node1);
		node3.neighbors.add(node2);
		
		System.out.println(dfs(node3, node0));
		System.out.println(dfs(node2, node1));
		System.out.println(dfs(node3, node0));
		System.out.println(dfs(node2, node1));
		System.out.println(dfs(node0, node3));
	}
}
