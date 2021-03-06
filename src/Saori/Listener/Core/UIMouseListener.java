package Saori.Listener.Core;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Saori.Listener.ExitApplication;
import Core.SaoriUI;
/**
 * UIMouseListener is use for call doing event of Saori.
 * @author Voraton Lertrattanapaisal
 *
 */
public class UIMouseListener implements MouseListener {
	private SaoriUI ui;
	public UIMouseListener(SaoriUI ui){
		this.ui = ui;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.getEvent().enterHandler();
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
			JMenuItem exit = new JMenuItem("Exit");
			exit.addActionListener(new ExitApplication());
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
			exit.addActionListener(new ExitApplication());
			popup.add(exit);
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
		ui.getEvent().releaseHandler();
	}

}
