package pluginTools;

import javax.swing.JFrame;

import ij.ImageJ;

public class InteractiveFAQT {

	
	public static void main(String[] args) {
		
		
		new ImageJ();
		JFrame frame = new JFrame("");
		
		FwingDirectoryChooser panel = new FwingDirectoryChooser();
		
		frame.getContentPane().add(panel, "Center");
		frame.getSize(panel.getPreferredSize());
		
		
	}
	
	
}
