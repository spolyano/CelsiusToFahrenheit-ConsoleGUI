import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleGUI {
	private String caption;
	private ArrayList<String> actions = new ArrayList<String>();
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public void executeAction(int key, Scanner keyReader) {
		System.out.println("pressed: " + key);
	}
	
	public void addAction(String name) {
		actions.add(name);
	}
	
	public void startConsole(InputStream inStr) {
		System.out.println(caption);
		
		for (int i = 0; i < actions.size(); i++)
			System.out.println("--> " + (i + 1) + " <-- " + actions.get(i));
		
		int key = 0;
		boolean keyIsActive = true;
		Scanner keyReader = new Scanner(inStr);
		
		while(keyIsActive) {
			System.out.println("Select --> key <-- from menu");
			if (keyReader.hasNextInt())
				key = keyReader.nextInt();
			
			if (key >= 1 && key <= actions.size())
				executeAction(key, keyReader);
			else keyIsActive = false;
		}
		
		keyReader.close();
		
	}
	
}
