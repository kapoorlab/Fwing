package pluginListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import pluginTools.FwingDirectoryChooser;

public class OriginalRightWing implements ActionListener {
	
	final FwingDirectoryChooser parent;
	
	public OriginalRightWing(final FwingDirectoryChooser parent) {
		
		this.parent = parent;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		parent.chooserOrigRight = new JFileChooser();
		if(parent.chooserOrigLeft!=null)
			parent.chooserOrigRight.setCurrentDirectory(parent.chooserOrigLeft.getCurrentDirectory());
		else
		parent.chooserOrigRight.setCurrentDirectory(new java.io.File("."));
		parent.chooserOrigRight.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "tif","tiff", "jpg", "png", "jpeg", "nd2");
		parent.chooserOrigRight.setFileFilter(filter);
				
		parent.chooserOrigRight.setAcceptAllFileFilterUsed(false);
		
if (parent.chooserOrigRight.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
			

			parent.originalRightWings = parent.chooserOrigRight.getSelectedFile().listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File pathname, String filename) {

					return (filename.endsWith(".tif") || filename.endsWith(".tiff") || filename.endsWith(".jpg")
							|| filename.endsWith(".png")|| filename.endsWith(".jpeg") || filename.endsWith(".nd2")      );
				}
			});
			System.out.println("getCurrentDirectory(): " + parent.chooserOrigRight.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + parent.chooserOrigRight.getSelectedFile());
		} else {
			System.out.println("No Selection ");
		}

		
	}
		
		
	}
	
	
	

