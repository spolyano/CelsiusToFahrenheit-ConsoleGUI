import java.io.InputStream;
import java.util.Scanner;

public class CelsiusToFahrenheit extends ConsoleGUI{
	private double celsius;
	private double fahrenheit;
	
	//from ConsoleGUI
	public void executeAction(int key, Scanner keyReader) {
		double d = 0;

		if (key == 1) {
			System.out.print("Enter value: ");
			if (keyReader.hasNextDouble())
				d = keyReader.nextDouble();
				
			celsius = d;
			fahrenheit = calcCTF(celsius);
			System.out.println("Result: " + fahrenheit);
		}
		else if (key == 2) {
			System.out.print("Enter value: ");
			if (keyReader.hasNextDouble())
				d = keyReader.nextDouble();
				
			fahrenheit = d;
			celsius = calcFTC(fahrenheit);
			System.out.println("Result: " + celsius);
		}
		else System.exit(0);
	}
	
	public double calcCTF(double celsius) {
		return (celsius * 9/5) + 32;
	}
	
	public double calcFTC(double fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}
	
	public void calculateWithConsole() {
		setCaption("Select operation type");
		addAction("from CelsiusToFahrenheit");
		addAction("from Fahrenheit to Celsius");
		addAction("Exit");
		startConsole(System.in);
	}

	
}
