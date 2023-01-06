package Graphs;
import java.util.ArrayList;
import java.util.List;

public class Graph {
	List<List<Integer>> adjlist;
	int n;
	int type;
	
	public Graph(List<Node> nodes, final int n, final int type) {
		this.adjlist = new ArrayList<>();
		this.n = n;
		this.type = type;
		
		for(int i = 0; i < n; i++)
			this.adjlist.add(new ArrayList<>());	
		
		for(Node node : nodes) {
			if(this.type == 1) { //Undirected graph
				this.adjlist.get(node.source).add(node.dest);
				this.adjlist.get(node.dest).add(node.source);
			}else {
				this.adjlist.get(node.source).add(node.dest);
			}
		}
	}
	
	public void printNodes() {
		//Look distribution
        for (int i = 0; i < this.n; i++) {
            List<Integer> node = this.adjlist.get(i);
            System.out.print("Node " + i + " -> ");
            for (int j = 0; j < node.size(); j++) {
                System.out.print(node.get(j) + " ");
            }
            System.out.println("");
        }
	}
}
