package Saori.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
/** 
 * ExitListener is Action Listener that use for dispose somme dialog.
 * @author Voraton Lertrattanapaisal
 *
 */
public class ExitListener implements ActionListener {
	private JDialog dialog;
	public ExitListener(JDialog dialog){
		this.dialog = dialog;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dialog.dispose();
	}

}
