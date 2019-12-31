package pluginListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import pluginTools.FwingDirectoryChooser;

public class SegmentationLeftWing implements ActionListener {
	
	final FwingDirectoryChooser parent;
	
	public SegmentationLeftWing(final FwingDirectoryChooser parent) {
		
		this.parent = parent;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		parent.chooserSegLeft = new JFileChooser();
		if(parent.chooserSegRight!=null)
			parent.chooserSegLeft.setCurrentDirectory(parent.chooserSegRight.getCurrentDirectory());
		else
		parent.chooserSegLeft.setCurrentDirectory(new java.io.File("."));
		parent.chooserSegLeft.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "tif","tiff", "jpg", "png", "jpeg", "nd2");
		parent.chooserSegLeft.setFileFilter(filter);
				
		parent.chooserSegLeft.setAcceptAllFileFilterUsed(false);
		
if (parent.chooserSegLeft.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
			

			parent.SegmentationLeftWings = parent.chooserSegLeft.getSelectedFile().listFiles(new FilenameFilter() {

				@Override
				public boolean accept(File pathname, String filename) {

					return (filename.endsWith(".tif") || filename.endsWith(".tiff") || filename.endsWith(".jpg")
							|| filename.endsWith(".png")|| filename.endsWith(".jpeg") || filename.endsWith(".nd2")      );
				}
			});
			System.out.println("getCurrentDirectory(): " + parent.chooserSegLeft.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + parent.chooserSegLeft.getSelectedFile());
		} else {
			System.out.println("No Selection ");
		}

		
	}
		
		
	}
	
	
	

