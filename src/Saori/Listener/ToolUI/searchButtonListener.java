package Saori.Listener.ToolUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Saori.Search.FindFileUI;
/**
 * calculatorButtonListener is use for call FindFileUI.
 * @author Voraton Lertrattanapaisal
 *
 */
public class searchButtonListener implements ActionListener {

	private FindFileUI fileUI;
	public searchButtonListener(FindFileUI fileUI){
		this.fileUI = fileUI;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		fileUI.setVisible(true);
	}

}
