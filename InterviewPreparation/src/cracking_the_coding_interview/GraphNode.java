package cracking_the_coding_interview;

import java.util.*;

public class GraphNode {
	public int val;
	public List<GraphNode> neighbors;
	public GraphNode(int val) {
		this.val = val;
		neighbors = new ArrayList<GraphNode>();
	}
}
