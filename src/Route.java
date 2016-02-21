import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Route {
	
	private static int totalDist;
	public String findRoute(String srcCity,String destCity, Storage st, double weight) {
		
		totalDist = 0;
		Collection<Node> allNodes = st.getAllNodes();
		for (Node n : allNodes) {
			n.checked = false;
			n.minDistance = Integer.MIN_VALUE;
		}

		Node srcNode = st.getNode(srcCity.toLowerCase());

		PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>();
		srcNode.minDistance = 0;
		nodeQueue.add(srcNode);

		while (!nodeQueue.isEmpty()) {

			Node src = nodeQueue.poll();
			src.checked = true;

			Node nextNode = getNextNode(src, st, weight);
			if (nextNode != null) {
				src.nextNode = nextNode;
				if(nextNode.name.equalsIgnoreCase(destCity))
					break;
				nodeQueue.add(nextNode);
			}

		}

		return Utilities.getPath(srcCity,st);

	}

	private Node getNextNode(Node src, Storage st, double w) {
		Map<Node, Double> bestNode = new HashMap<Node, Double>();
		for (Edge e : src.adjancies) {
			Node dest = e.destNode;
			if (!dest.checked) {
				int actualDist = e.distance;
				int directDist = st.getDisp(dest.name);
				/*
				 * f = (1-w)g + wh, where g = ActualDist h = Displacement
				 * Distance
				 */
				double hueristicDist = (1 - w) * actualDist + w * directDist;
				dest.minDistance = e.distance;
				bestNode.put(dest, hueristicDist);
			}
		}
		Node nextNode = null;
		ArrayList<Double> valueList = new ArrayList<Double>(bestNode.values());
		Collections.sort(valueList);
		for (Node key : bestNode.keySet()) {
			if (valueList.get(0).equals(bestNode.get(key))) {
				nextNode = key;
				totalDist += nextNode.minDistance;
				break;
			}
		}
		return nextNode;
	}

	public int getTotalCost() {
		return totalDist;
	}
}
