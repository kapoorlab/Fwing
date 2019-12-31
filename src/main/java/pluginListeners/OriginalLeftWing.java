package pluginListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import pluginTools.FwingDirectoryChooser;

public class OriginalLeftWing implements ActionListener {
	
	final FwingDirectoryChooser parent;
	
	public OriginalLeftWing(final FwingDirectoryChooser parent) {
		
		this.parent = parent;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		parent.chooserOrigLeft = new JFileChooser();
		if(parent.chooserOrigRight!=null)
			parent.chooserOrigLeft.setCurrentDirectory(parent.chooserOrigRight.getCurrentDirectory());
		else
		parent.chooserOrigLeft.setCurrentDirectory(new java.io.File("."));
		parent.chooserOrigLeft.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "tif","tiff", "jpg", "png", "jpeg", "nd2");
		parent.chooserOrigLeft.setFileFilter(filter);
				
		parent.chooserOrigLeft.setAcceptAllFileFilterUsed(false);
		
if (parent.chooserOrigLeft.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
			

			parent.originalLeftWings = parent.chooserOrigLeft.getSelectedFile().listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File pathname, String filename) {

					return (filename.endsWith(".tif") || filename.endsWith(".tiff") || filename.endsWith(".jpg")
							|| filename.endsWith(".png")|| filename.endsWith(".jpeg") || filename.endsWith(".nd2")      );
				}
			});
			System.out.println("getCurrentDirectory(): " + parent.chooserOrigLeft.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + parent.chooserOrigLeft.getSelectedFile());
		} else {
			System.out.println("No Selection ");
		}

		
	}
		
		
	}
	
	
	

