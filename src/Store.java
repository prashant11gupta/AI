import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Store {
	
	
	public Storage graph(String fileName) throws NumberFormatException, IOException{
		Storage st = new Storage();
		File file = new File(fileName);
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line = null;
			while((line = br.readLine()) != null){
				String[] split = line.split("\\s\\s");
				st.addDisp(split[0].toLowerCase(), Integer.parseInt(split[1]));
				Node srcNode = st.addNode(split[0].toLowerCase());

				for(int i = 2; i < split.length;i++){
					String[] split1 = split[i].split("\\s");
					Node destNode = st.addNode(split1[0].toLowerCase());
					int distance = Integer.parseInt(split1[1]);
					Edge e = new Edge(destNode,distance);
					srcNode.adjancies.add(e);
				}
				
			}
			
			return st;
		}catch(FileNotFoundException e){
			System.out.println("File Not found "+ file.toString());
		}
		
		return null;
	}
}
