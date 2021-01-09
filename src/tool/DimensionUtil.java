package tool;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DimensionUtil {
	public static Rectangle getBounds() {
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Insets screenInsets=Toolkit.getDefaultToolkit().getScreenInsets(new JFrame().getGraphicsConfiguration());
		Rectangle rectangle=new Rectangle(screenInsets.left,screenInsets.top,screenSize.width-screenInsets.left-screenInsets.right,screenSize.height-screenInsets.top-screenInsets.bottom);
		
		return rectangle;
		
	}
	
}
