import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		
		Store st = new Store();
		Utilities uti = new Utilities();
		
		String fileName = "map.txt";
		Storage store = st.graph(fileName);
		
		String srcCity = "oradea";
		String destCity = "Bucharest";
		
		
		
		Route func = new Route();
		System.out.println("---------------1.1) Result with w = 0.5--------------");
		String path0 = func.findRoute(srcCity,destCity, store, 0.5);
		System.out.println(path0.substring(0, path0.length()-2));
		System.out.println("Total Cost: "+func.getTotalCost());
		System.out.println("Numbers of Nodes Expanded : "+uti.nodesExpanded(store));
		System.out.println("\n");
		
		System.out.println("---------------1.2) Result with w = 0.25--------------");
		String path1 = func.findRoute(srcCity,destCity, store, 0.25);
		System.out.println(path1.substring(0, path1.length()-2));
		System.out.println("Total Cost: "+func.getTotalCost());
		System.out.println("Numbers of Nodes Expanded : "+uti.nodesExpanded(store));
		System.out.println("\n");
		
		System.out.println("---------------1.2) Result with w = 0.75--------------");
		Route func1 = new Route();
		String path2 = func1.findRoute(srcCity,destCity, store, 0.75);
		System.out.println(path2.substring(0, path2.length()-2));
		System.out.println("Total Cost: "+func1.getTotalCost());
		System.out.println("Numbers of Nodes Expanded : "+uti.nodesExpanded(store));
		
		
		System.out.println("\n");
		System.out.println("--------------1.3) Result with taking logBase2 of hueristic distance");
		RouteNewFunc rt = new RouteNewFunc();
		String path = rt.findRoute(srcCity,destCity,store);
		System.out.println(path.substring(0, path.length()-2));
		System.out.println("Total Cost: " + rt.getTotalCost());
		System.out.println("Numbers of Nodes Expanded : "+uti.nodesExpanded(store));
		System.out.println("\n");
		
	}
}
