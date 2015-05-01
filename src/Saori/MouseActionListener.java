package Saori;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Saori.Listener.ExitListener;

public class MouseActionListener implements MouseListener {
	private SaoriUI ui;
	public MouseActionListener(SaoriUI ui){
		this.ui=ui;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.event.leftClickHandler();
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
		if (e.isPopupTrigger()){
			JPopupMenu popup = new JPopupMenu();
			JMenuItem exit = new JMenuItem();
			exit.addActionListener(new ExitListener());
			popup.add(exit);
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.isPopupTrigger()){
			JPopupMenu popup = new JPopupMenu();
			JMenuItem exit = new JMenuItem("Exit");
			exit.addActionListener(new ExitListener());
			popup.add(exit);
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
		else ui.event.releaseHandler();
	}

}
