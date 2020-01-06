package pluginTools;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import ij.plugin.PlugIn;

public class InteractiveImporter implements PlugIn {
	
	
	final File[] Leftfile, Rightfile, LeftSegfile, RightSegfile;
	
	public InteractiveImporter(final File[] Leftfile, final File[] Rightfile,final File[] LeftSegfile, final File[] RightSegfile ) {

		this.Leftfile = Leftfile;
		this.Rightfile = Rightfile;
		this.LeftSegfile = LeftSegfile;
		this.RightSegfile = RightSegfile;
		
	}

	@Override
	public void run(String arg0) {
		Card();
		
	}
	
	public static enum ValueChange {
		
		DISPLAYIMAGE, DISPLAYSEG;
	}
	
	public void updatePreview(final ValueChange change) {
		
		
		
		
	}
	
	
	public JFrame Cardframe = new JFrame("Main FAQT");
	
	public int rowfile = 0;
	public String inputfile;
	public JPanel panelFirst = new JPanel();
	public JPanel panelCont = new JPanel();
	public JPanel PanelSelectFile = new JPanel();
	public JPanel PanelSelectSeg = new JPanel();
	public final GridBagLayout layout = new GridBagLayout();
	public final GridBagConstraints c = new GridBagConstraints();
	public final Insets insets = new Insets(10, 0, 0, 0);
	public Border selectfile = new CompoundBorder(new TitledBorder("Select File"), new EmptyBorder(c.insets));
	public JTable tablefile;
	public JScrollPane scrollPanefile;
	public void Card() {
		
		inputfile = Leftfile[rowfile].getParentFile().getAbsolutePath();
		
		CardLayout cl = new CardLayout();

		c.insets = new Insets(5, 5, 5, 5);
		panelCont.setLayout(cl);
		
		panelCont.add(panelFirst, "1");
		panelFirst.setLayout(layout);
		PanelSelectFile.setLayout(layout);
		PanelSelectSeg.setLayout(layout);
		c.anchor = GridBagConstraints.BOTH;
		c.ipadx = 35;

		c.gridwidth = 10;
		c.gridheight = 10;
		c.gridy = 1;
		c.gridx = 0;
		
		Object[] colnamesfile = new Object[] { "Filename", "Done" };

		Object[][] rowvaluesfile = new Object[Leftfile.length][colnamesfile.length];
		
		
		tablefile = new JTable(rowvaluesfile, colnamesfile);
		

		tablefile.setFillsViewportHeight(true);

		tablefile.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		int width = 500;
		scrollPanefile = new JScrollPane(tablefile);

		scrollPanefile.getViewport().add(tablefile);
		scrollPanefile.setAutoscrolls(true);
		scrollPanefile.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		PanelSelectFile.add(scrollPanefile, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));
		
		
		panelFirst.add(PanelSelectFile, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));
		
		Cardframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cl.show(panelCont, "1");
		tablefile.validate();
		scrollPanefile.validate();
		Cardframe.add(panelCont, "Center");
		panelFirst.setVisible(true);
		Cardframe.pack();
		Cardframe.setVisible(true);

	
	}

}
