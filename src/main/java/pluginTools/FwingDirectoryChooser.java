package pluginTools;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import loaddirectory.LeftRightDirectoryLoader;

public class FwingDirectoryChooser extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JFrame CardFrame = new JFrame("Flywing Assymmetry Quatification Tool (FAQT)");
	public JPanel panelCont = new JPanel();
	public final GridBagLayout layout = new GridBagLayout();
	public final GridBagConstraints c = new GridBagConstraints();
	public final Insets insets = new Insets(10, 0, 0, 0);
	public JButton Done =  new JButton("Finished choosing files, start FAQT");
	public JPanel panelFirst = new JPanel();
	public String chooseOriginalImage = "Choose original Left and Right Wing directories";
	public String chooseSegmentation = " Choose SegmentationMap directory of Left and Right Wings";
	public JPanel Panelfileoriginal = new JPanel();
	public JPanel Panelfilesegmentation = new JPanel(); 
	public JPanel Paneldone = new JPanel();
	public Border chooseOrig = new CompoundBorder(new TitledBorder(chooseOriginalImage), new EmptyBorder(c.insets));
	public Border chooseSeg = new CompoundBorder(new TitledBorder(chooseSegmentation), new EmptyBorder(c.insets));
	public File[] originalLeftWings;
	public File[] originalRightWings;
	public File[] SegmentationLeftWings;
	public File[] SegmentationRightWings;

	public String donestring = "Done Selection";
	
	  public Border LoadFAQT = new CompoundBorder(new TitledBorder(donestring),
				new EmptyBorder(c.insets));
	
	
	public FwingDirectoryChooser() {
		
	   panelFirst.setLayout(layout);
		   
		   Paneldone.setLayout(layout);
	       CardLayout cl = new CardLayout();

			panelCont.setLayout(cl);
			panelCont.add(panelFirst, "1");
		
			
			LeftRightDirectoryLoader original = new LeftRightDirectoryLoader(chooseOriginalImage, originalLeftWings, originalRightWings); 
			
			Panelfileoriginal = original.LoadDirectory();
			
			panelFirst.add(Panelfileoriginal, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, insets, 0, 0));
			
            LeftRightDirectoryLoader segmentation = new LeftRightDirectoryLoader(chooseOriginalImage, SegmentationLeftWings, SegmentationRightWings); 
			
			Panelfilesegmentation = segmentation.LoadDirectory();
			
			panelFirst.add(Panelfilesegmentation, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, insets, 0, 0));
			
			Paneldone.add(Done, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
			Paneldone.setBorder(LoadFAQT);
			panelFirst.add(Paneldone, new GridBagConstraints(0, 4, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, insets, 0, 0));
			
			
			
			
			
			Done.addActionListener(new DoneListener());
			
			original.LoadLeftWingDirectory.addActionListener(new OriginalLeftWing(this, original.LoadLeftWingDirectory));
			original.LoadRightWingDirectory.addActionListener(new OriginalRightWing(this, original.LoadRightWingDirectory));
			
			segmentation.LoadLeftWingDirectory.addActionListener(new SegmentationLeftWing(this, segmentation.LoadLeftWingDirectory));
			segmentation.LoadRightWingDirectory.addActionListener(new SegmentationRightWing(this, segmentation.LoadRightWingDirectory));
			
			
			panelFirst.setVisible(true);
			cl.show(panelCont, "1");
			CardFrame.add(panelCont, "Center");
		
			CardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			CardFrame.pack();
			CardFrame.setVisible(true);
		
	}
	
	
	
}
