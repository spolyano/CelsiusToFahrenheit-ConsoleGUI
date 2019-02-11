public class Tester {
	public static void main(String args[]) {
		ConsoleWidget appMenu = new ConsoleWidget();
		ConsoleGUINavi startPage = new ConsoleGUINavi("Application menu", appMenu, "", '-');
		
		ConsoleGUIReturn ctfExit =  new ConsoleGUIReturn(appMenu, "Ok", 'k');
		GradConverter ctfPage = new GradConverter(appMenu, "", GradConverter.GradSystems.CELSIUS, GradConverter.GradSystems.FAHRENHEIT);
		ctfPage.addChild(ctfExit);
		
		ConsoleGUIReturn ctfNaviExit =  new ConsoleGUIReturn(appMenu, "Return", 'r');
		ConsoleGUINavi ctfNaviPage = new ConsoleGUINavi("Input Celsius Grad value...", appMenu, "Convert Celsius to Fahrenheit", 'q');
		ctfNaviPage.addChild(ctfPage);
		ctfNaviPage.addChild(ctfNaviExit);
		
		ConsoleGUIReturn startPageExit = new ConsoleGUIReturn(appMenu, "Exit", 'x');
		startPage.addChild(ctfNaviPage);
		startPage.addChild(startPageExit);
		
		appMenu.process(startPage);
	}
}
