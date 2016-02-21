import java.util.Collection;

public class Utilities {
	public static String getPath(String srcCity, Storage str) {
		
		StringBuilder sb = new StringBuilder();
		Node srcNode = str.getNode(srcCity.toLowerCase());
		Node temp = srcNode;
		sb.append("Path from " + srcCity + " To Bucharest :");
		while (temp != null) {

			sb.append(temp.name);
			sb.append("->");
			temp = temp.nextNode;
		}

		return sb.toString();
	}
	
	public int nodesExpanded(Storage str) {
		Collection<Node> nodes = str.getAllNodes();
		int count =0;
		for (Node n : nodes) {
			if (n.checked) {
				count++;
			}
		}
		return count;
	}
	
}
