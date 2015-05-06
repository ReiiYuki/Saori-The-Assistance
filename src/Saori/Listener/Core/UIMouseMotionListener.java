package Saori.Listener.Core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Core.SaoriUI;

public class UIMouseMotionListener implements MouseMotionListener {
	private SaoriUI ui;
	public UIMouseMotionListener(SaoriUI ui){
		this.ui=ui;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.getEvent().dragHandler(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
