import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class ConsoleGUI {
	private final int INVALID = 0;
	private String caption;
	private ArrayList<String> actions = new ArrayList<String>();
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public abstract void executeAction(int key);
	public abstract void init();
	
	public void addAction(String name) {
		actions.add(name);
	}
		
	public void startConsole(InputStream inStr) {
		System.out.println(caption);
		
		for (int i = 0; i < actions.size(); i++)
			System.out.println("--> " + (i + 1) + " <-- " + actions.get(i));
		
		int key = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Select --> key <-- from menu");
			
			try {
				key = Integer.parseInt(in.readLine());
			} catch (Exception e){
				key = INVALID;
			}
					
			if (key < 0 || key > actions.size())
				key = INVALID;
			
			if (key == INVALID) System.out.println("Please enter a valid integer value");
			else executeAction(key);
	
		}
			
	}
	
}