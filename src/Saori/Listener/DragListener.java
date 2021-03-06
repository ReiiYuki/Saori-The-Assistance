package Saori.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;
/**
 * DragListener is listener to the program change position when drag.
 * @author Voraton Lertrattanapaisal
 *
 */
public class DragListener implements MouseMotionListener {
	private JDialog dialog;
	public DragListener(JDialog dialog){
		this.dialog = dialog;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		dialog.setLocation(e.getLocationOnScreen());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//do nothing
	}

}
