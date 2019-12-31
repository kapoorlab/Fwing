package pluginListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import pluginTools.FwingDirectoryChooser;

public class SegmentationRightWing implements ActionListener {
	
	final FwingDirectoryChooser parent;
	
	public SegmentationRightWing(final FwingDirectoryChooser parent) {
		
		this.parent = parent;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		parent.chooserSegRight = new JFileChooser();
		if(parent.chooserSegLeft!=null)
			parent.chooserSegRight.setCurrentDirectory(parent.chooserSegLeft.getCurrentDirectory());
		else
		parent.chooserSegRight.setCurrentDirectory(new java.io.File("."));
		parent.chooserSegRight.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "tif","tiff", "jpg", "png", "jpeg", "nd2");
		parent.chooserSegRight.setFileFilter(filter);
				
		parent.chooserSegRight.setAcceptAllFileFilterUsed(false);
		
if (parent.chooserSegRight.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
			

			parent.SegmentationRightWings = parent.chooserSegRight.getSelectedFile().listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File pathname, String filename) {

					return (filename.endsWith(".tif") || filename.endsWith(".tiff") || filename.endsWith(".jpg")
							|| filename.endsWith(".png")|| filename.endsWith(".jpeg") || filename.endsWith(".nd2")      );
				}
			});
			System.out.println("getCurrentDirectory(): " + parent.chooserSegRight.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + parent.chooserSegRight.getSelectedFile());
		} else {
			System.out.println("No Selection ");
		}

		
	}
		
		
	}
	
	
	

