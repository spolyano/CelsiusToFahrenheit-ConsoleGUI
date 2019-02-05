import java.io.InputStream;
import java.util.Scanner;

public class CelsiusToFahrenheit extends ConsoleGUI{
	private double celsius;
	private double fahrenheit;
	
	//start first from constructor
	public CelsiusToFahrenheit() {
		setCaption("Select operation type");
		addAction("from CelsiusToFahrenheit");
		addAction("from Fahrenheit to Celsius");
		addAction("Exit");
	}
	
	//from ConsoleGUI
	public void executeAction(int key) {
		setGrad(key);
	}
	
	public double calcCTF(double celsius) {
		return (celsius * 9/5) + 32;
	}
	
	public double calcFTC(double fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}
	
	public void setGrad(int type) {
		
		InputStream inStr;
		double d = 0;
		Scanner keyReader = new Scanner(System.in);
		
		System.out.print("Enter value: ");
		if (keyReader.hasNextDouble())
				d = keyReader.nextDouble();
		
		if (type == 1) {
			celsius = d;
			fahrenheit = calcCTF(celsius);
			System.out.println("Result: " + fahrenheit);
		}
		else if (type == 2) {
			fahrenheit = d;
			celsius = calcFTC(fahrenheit);
			System.out.println("Result: " + celsius);
		}
		else System.exit(0);

	}
	
	public void calculate() {
		startConsole(System.in);
	}

	
}
