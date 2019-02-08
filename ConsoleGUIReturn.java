public class ConsoleGUIReturn extends ConsoleGUI {
    public ConsoleGUIReturn(ConsoleWidget widgetCntrl, String menuLabel, char menuKey) {
        super("", widgetCntrl, menuLabel, menuKey);
    }
    
	protected void executeAction(double input) {
	    if(parent==null || parent.parent==null) System.exit(0);
	    
	    widgetCntrl.setNextPage(parent.parent);
	}

}
