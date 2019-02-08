public class ConsoleGUIReturn extends ConsoleGUI {
    public ConsoleGUIReturn(String caption, ConsoleWidget widgetCntrl, String menuLabel, char menuKey) {
        super(caption, widgetCntrl, menuLabel, menuKey, false);
    }
    
	protected void executeAction(double input) {
	    if(parent==null || parent.parent==null) System.exit(0);
	}

}
