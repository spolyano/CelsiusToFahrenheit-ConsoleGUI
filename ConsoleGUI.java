import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleGUI {
	private String caption;
	private ArrayList<SimpleAction> actions = new ArrayList<SimpleAction>();
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	
	//it seems, not needed
	public class SimpleAction {
		private String name;
		
		public SimpleAction(String name) {
			this.name = name;
		}
		
		public void executeAction() {
			
		}
	}
	
	public void executeAction(int key) {
		System.out.println("pressed: " + key);
	}
	
	public void addAction(String name) {
		SimpleAction act = new SimpleAction(name);
		actions.add(act);
	}
	
	public void startConsole(InputStream inStr) {
		System.out.println(caption);
		
		for (int i = 0; i < actions.size(); i++)
			System.out.println("--> " + (i + 1) + " <-- " + actions.get(i).name);
		
		int key = 0;
		boolean keyIsActive = true;
		Scanner keyReader = new Scanner(inStr);
		
		while(keyIsActive) {
			System.out.println("Select --> key <-- from menu");
			if (keyReader.hasNextInt())
				key = keyReader.nextInt();
			
			if (key >= 1 && key <= actions.size())
				executeAction(key);
			else keyIsActive = false;
		}
		
		keyReader.close();
		
	}
	
}
