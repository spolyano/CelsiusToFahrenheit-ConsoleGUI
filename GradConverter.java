public class GradConverter extends ConsoleGUI {
	
	public enum GradSystems { CELSIUS, FAHRENHEIT }
	GradSystems from;
	GradSystems to;
	
	public GradConverter(ConsoleWidget widgetCntrl, String menuLabel, GradSystems from, GradSystems to) {
	    super("", widgetCntrl, menuLabel, '-');
	    this.from=from;
	    this.to=to;
	    handlesDouble=true;
	}
	
	protected void executeAction(double input) {
	    widgetCntrl.setNextPage(this);
		String newCap = input + " Grad "+ from + " equals " + convert(input) + " Grad " + to;
        setCaption(newCap);
	}
    
    public double convert(double input) {
        if(from==GradSystems.CELSIUS && to==GradSystems.FAHRENHEIT) return 32 + input*9/5; 
        if(from==GradSystems.FAHRENHEIT && to==GradSystems.CELSIUS) return (input-32)*5/9;
        
        return 0;
    }
}
