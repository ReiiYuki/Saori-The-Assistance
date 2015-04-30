package Saori.Event;

import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Saori.SaoriUI;

public class FlyingEvent implements Event{
	private SaoriUI ui;
	public FlyingEvent(SaoriUI ui){
		this.ui=ui;
		ui.Saori.setIcon(new ImageIcon(ClassLoader.getSystemResource("Resource/Images/saori3.png")));
	}
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftClickHandler() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragHandler(MouseEvent e) {
		// TODO Auto-generated method stub
		ui.setLocation(e.getLocationOnScreen().x-40,e.getLocationOnScreen().y);
	}
	@Override
	public void releaseHandler(){
		ui.changeEvent(new FallingEvent(ui));
	}
}
