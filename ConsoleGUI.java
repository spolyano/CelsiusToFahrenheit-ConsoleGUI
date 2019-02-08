import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public abstract class ConsoleGUI {
	private boolean invalidInput = false;
	private String caption;

	private ArrayList<ConsoleGUI> children = new ArrayList<ConsoleGUI>();
	protected ConsoleGUI parent;
	protected ConsoleWidget widgetCntrl;
	
	private String menuLabel;
	private char menuKey;
	
	private boolean handlesDouble = false;
	private ConsoleGUI hndDouble;

	public ConsoleGUI(String caption, ConsoleWidget widgetCntrl, String menuLabel, char menuKey, boolean handlesDouble) {
		this.caption=caption;
		this.widgetCntrl=widgetCntrl;
		this.menuLabel=menuLabel;
		this.menuKey=menuKey;
		this.handlesDouble=handlesDouble;
	}	
	
	public boolean isHandlerDouble() { return handlesDouble; }
	public boolean act(char command) {
		if(menuKey!=command) return false;
		executeAction(0);
		return true;
	}
	public boolean act(double input) {
		if(!handlesDouble) return false;
		executeAction(input);
		return true; 
	}
	protected abstract void executeAction(double input);
	
	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void addChild(ConsoleGUI newChild, boolean canDoubles) {
		children.add(newChild);
		if(canDoubles) hndDouble=newChild;
		newChild.parent=this;
	}
	
	public String toString() {
		String res = "[";
		res+= handlesDouble ? "Value] " : menuKey+"] ";
		res+= menuLabel;
		return res;
	}
	
	public void showConsole() {
		try {
			if (!System.getProperty("os.name").contains("Windows")) Runtime.getRuntime().exec("clear");
		} catch (IOException ex) {}
		System.out.println(caption);
		for(int i=0;i<children.size();i++) System.out.println(children.get(i));
		if(invalidInput) System.out.print("Unknown command");
		System.out.print("\n>");
		invalidInput=false;
	}

	public void processConsole(Scanner inStr) {

		String nextCommand = inStr.next();
		double numValue;

		try {
			numValue = Double.parseDouble(nextCommand);
			if(hndDouble!=null) hndDouble.act(numValue); else invalidInput=true;
		} catch (Exception e){
			boolean cmdProcessed = false;
			if(nextCommand.length()==1) for(int i=0;i<children.size() && (!cmdProcessed);i++) cmdProcessed=children.get(i).act(nextCommand.charAt(0));
			if(!cmdProcessed) invalidInput=true;
		}
	}
}