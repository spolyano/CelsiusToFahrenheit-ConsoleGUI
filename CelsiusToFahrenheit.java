import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CelsiusToFahrenheit extends ConsoleGUI{
	private double celsius;
	private double fahrenheit;
	
	//from ConsoleGUI
	public void executeAction(int key) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		if (key == 1) {
			
			try {
				System.out.print("Enter temperature (celsius): ");
				celsius = Double.parseDouble(in.readLine());
				fahrenheit = calcCTF(celsius);
				System.out.println("Result (fahrenheit): " + fahrenheit);
			} catch (Exception e){
				System.out.println("Please enter valid temperature (double)");
			}

		}
		else if (key == 2) {
			
			try {
				System.out.print("Enter temperature (fahrenheit): ");
				fahrenheit = Double.parseDouble(in.readLine());
				celsius = calcFTC(fahrenheit);
				System.out.println("Result (celsius): " + celsius);
			} catch (Exception e){
				System.out.println("Please enter valid temperature (double)");
			}
			
		}
		else System.exit(0);
	}
	
	//from ConsoleGUI
	public void init() {
		setCaption("Select operation type");
		addAction("From Celsius to Fahrenheit");
		addAction("From Fahrenheit to Celsius");
		addAction("Exit");
		startConsole(System.in);
	}
	
	public double calcCTF(double celsius) {
		return (celsius * 9/5) + 32;
	}
	
	public double calcFTC(double fahrenheit) {
		return (fahrenheit - 32) * 5/9;
	}
		
}