package Saori.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitApplication implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
