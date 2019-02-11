public class ConsoleGUINavi extends ConsoleGUI {
    public ConsoleGUINavi(String caption, ConsoleWidget widgetCntrl, String menuLabel, char menuKey) {
        super(caption, widgetCntrl, menuLabel, menuKey);
    }
    
	protected void executeAction(double input) {
	    widgetCntrl.setNextPage(this);
	}

}