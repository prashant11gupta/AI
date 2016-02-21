import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Storage {
	private Map<String,Node> map;
	private Map<String,Integer> displacement;
	public Storage(){
		map = new HashMap<String,Node>();
		displacement = new HashMap<String,Integer>();
	}
	
	public Node addNode(String name){
		if(map.containsKey(name)){
			return map.get(name);
		}else{
			Node newNode = new Node(name);
			map.put(name, newNode);
			return newNode;
		}
	}
	
	public Node getNode(String name){
		if(map.containsKey(name))
			return map.get(name);
		else
			return null;
	}
	
	public void addDisp(String name, int weight){
		if(!displacement.containsKey(name)){
			displacement.put(name, weight);
		}
	}
	
	public int getDisp(String name){
		if(displacement.containsKey(name))
			return displacement.get(name);
		else
			return 0;
	}
	
	public Collection<Node> getAllNodes() {
		return map.values();
	}
	
}
