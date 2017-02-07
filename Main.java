import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Main {
	private static List<DispScreen> screens = new ArrayList<DispScreen>(3);

	public static void main(String args[]) {
		String input = "";
		Scanner s = new Scanner(System.in);

		while(!input.equals("exit")) {
			System.out.print(">");
			input = s.nextLine();
			String[] sargs = input.split("\\s+");
			switch(sargs[0]) {
				case "add":
					if(sargs.length < 3) {
						System.out.println("Not enough arguments");
						break;
					}
					List<JLabel> labels = new ArrayList<JLabel>();
					for(DispScreen d: screens) {
						d.spawnItem(new Item(sargs[1], sargs[2]), labels);
					}
					System.out.println(sargs[1] + " added");
					break;
				case "exit":
					exit();
					break;
				case "test":
					System.out.println("This is a test.");
					break;
				case "start":
					screens.add(new DispScreen("Public", true));
					screens.add(new DispScreen("Player1", false));
					screens.add(new DispScreen("Player2", false));
					break;
				default:
					System.out.println(sargs[0] + " is not a valid command");	
			}
		}
	}

	public static void exit() {
		// Clean up
		System.out.println("Exiting...");
		for(DispScreen d: screens) {
			d.setVisible(false);
			d.dispose();
		}
		System.exit(0);
	}
}
