package Saori;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMovingListener implements MouseMotionListener {
	private SaoriUI ui;
	public MouseMovingListener(SaoriUI ui){
		this.ui=ui;
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		ui.event.dragHandler(arg0);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
