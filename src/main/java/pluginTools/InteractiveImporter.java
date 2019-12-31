package pluginTools;

import java.io.File;

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
		// TODO Auto-generated method stub
		
	}

}
