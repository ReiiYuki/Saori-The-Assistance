package Saori.Listener.ToolUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Saori.Clock.DigitalClockUI;

public class clockButtonListener implements ActionListener {
	private DigitalClockUI clock;
	public clockButtonListener(DigitalClockUI clock){
		this.clock = clock;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		clock.setVisible(true);
	}
}
