import java.util.Scanner;

public class ConsoleWidget {
    private ConsoleGUI currentPage;
    private ConsoleGUI nextPage;
    
    public void setNextPage(ConsoleGUI page) { nextPage=page; }

    public void process(ConsoleGUI startPage) {
        if(startPage==null) return;
        currentPage=startPage;
        Scanner in = new Scanner(System.in);
        
        while(true) {
            currentPage.showConsole();
            currentPage.processConsole(in);
            if(nextPage!=null) currentPage=nextPage;
            nextPage=null;
        }
    }
    
}
