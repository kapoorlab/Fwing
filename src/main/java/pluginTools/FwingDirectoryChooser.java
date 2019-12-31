package pluginTools;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import loaddirectory.LeftRightDirectoryLoader;
import pluginListeners.DoneSelection;
import pluginListeners.OriginalLeftWing;
import pluginListeners.OriginalRightWing;
import pluginListeners.SegmentationLeftWing;
import pluginListeners.SegmentationRightWing;

public class FwingDirectoryChooser extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JFrame CardFrame = new JFrame("Flywing Assymmetry Quatification Tool (FAQT)");
	public JPanel panelCont = new JPanel();
	public boolean isFinished = false;
	public final GridBagLayout layout = new GridBagLayout();
	public final GridBagConstraints c = new GridBagConstraints();
	public final Insets insets = new Insets(10, 0, 0, 0);
	public JButton Done =  new JButton("Finished choosing files, start FAQT");
	public JPanel panelFirst = new JPanel();
	public String chooseOriginalImage = "Choose originalImage directory of Left and Right Wings";
	public String chooseSegmentationImage = " Choose SegmentationMap directory of Left and Right Wings";
	public JPanel Panelfileoriginal = new JPanel();
	public JPanel Panelfilesegmentation = new JPanel(); 
	public JPanel Paneldone = new JPanel();
	public Border chooseOrig = new CompoundBorder(new TitledBorder(chooseOriginalImage), new EmptyBorder(c.insets));
	public Border chooseSeg = new CompoundBorder(new TitledBorder(chooseSegmentationImage), new EmptyBorder(c.insets));
	public JFileChooser chooserOrigLeft;
	public JFileChooser chooserOrigRight;
	public JFileChooser chooserSegLeft;
	public JFileChooser chooserSegRight;
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
			
            LeftRightDirectoryLoader segmentation = new LeftRightDirectoryLoader(chooseSegmentationImage, SegmentationLeftWings, SegmentationRightWings); 
			
			Panelfilesegmentation = segmentation.LoadDirectory();
			
			panelFirst.add(Panelfilesegmentation, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, insets, 0, 0));
			
			Paneldone.add(Done, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 10), 0, 0));
			Paneldone.setBorder(LoadFAQT);
			panelFirst.add(Paneldone, new GridBagConstraints(0, 4, 3, 1, 0.0, 0.0, GridBagConstraints.WEST,
					GridBagConstraints.HORIZONTAL, insets, 0, 0));
			
			
			
			
			
			Done.addActionListener(new DoneSelection(this));
			
			original.LoadLeftWingDirectory.addActionListener(new OriginalLeftWing(this));
			original.LoadRightWingDirectory.addActionListener(new OriginalRightWing(this));
			
			segmentation.LoadLeftWingDirectory.addActionListener(new SegmentationLeftWing(this));
			segmentation.LoadRightWingDirectory.addActionListener(new SegmentationRightWing(this));
			
			
			panelFirst.setVisible(true);
			cl.show(panelCont, "1");
			CardFrame.add(panelCont, "Center");
		
			CardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			CardFrame.pack();
			CardFrame.setVisible(true);
		
	}
	
	public final void Done(final Frame parent) {
		  
		  new InteractiveImporter(originalLeftWings, originalRightWings,SegmentationLeftWings,SegmentationRightWings).run(null);
		  close(parent);
	  }
	  protected final void close(final Frame parent) {
			if (parent != null)
				parent.dispose();

			isFinished = true;
		}
	  
	
	
}
