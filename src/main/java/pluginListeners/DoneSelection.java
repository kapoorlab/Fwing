package pluginListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pluginTools.FwingDirectoryChooser;

public class DoneSelection implements ActionListener {
	
	
	final FwingDirectoryChooser parent;
	
	public DoneSelection(final FwingDirectoryChooser parent) {
		
		this.parent = parent;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		parent.Done(parent.CardFrame);
		
	}
	
	
	

}
