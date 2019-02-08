public class Tester {
	public static void main(String args[]) {
		ConsoleWidget appMenu = new ConsoleWidget();
		ConsoleGUINavi startPage = new ConsoleGUINavi("Application menu", appMenu, "", '-');
		ConsoleGUIReturn startPageExit = new ConsoleGUIReturn("Exit", appMenu, "Exit", 'x');
		startPage.addChild(startPageExit, false);
		
		appMenu.process(startPage);
	}
}
