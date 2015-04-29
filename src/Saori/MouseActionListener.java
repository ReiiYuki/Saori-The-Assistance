package Saori;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionListener implements MouseListener {
	private SaoriUI ui;
	public MouseActionListener(SaoriUI ui){
		this.ui=ui;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.toString());
//		ui.event.leftClickHandler();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.event.leftClickHandler();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
