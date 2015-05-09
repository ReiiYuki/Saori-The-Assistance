package Saori.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ExitApplication is action listener which use for exit entire program.
 * @author Voraton Lertrattanapaisal
 *
 */
public class ExitApplication implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
