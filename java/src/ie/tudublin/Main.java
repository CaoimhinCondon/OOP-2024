
// Packages must match the folder structure
package ie.tudublin;

public class Main {

	public void BugZap() {

		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new BugZap());
	}
	
	public static void main(String[] args) {
		
		Main m = new Main();

		m.BugZap();
	}
}