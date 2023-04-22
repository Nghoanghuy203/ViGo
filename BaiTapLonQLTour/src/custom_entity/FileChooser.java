package custom_entity;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileChooser {

	    public static BufferedImage fileChooser() {
	    	BufferedImage img = null;
	    	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	        jfc.setDialogTitle("Select an image");
	        jfc.setAcceptAllFileFilterUsed(false);
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and jpg images", "png", "jpg");
	        jfc.addChoosableFileFilter(filter);

	        int returnValue = jfc.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	            try {
					img=ImageIO.read(jfc.getSelectedFile());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return img;
	    }
	}

