import java.util.LinkedList;
import java.util.List;

public class Node {
	public final String name;
	public List<Edge> adjancies;
	boolean checked = false;
	public Node nextNode;
	int minDistance;
	
	public Node(String name){
		this.name = name;
		this.adjancies = new LinkedList<Edge>();
		this.nextNode = null;
	}
}
