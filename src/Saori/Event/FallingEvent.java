package Saori.Event;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

import Saori.SaoriUI;

public class FallingEvent implements Runnable{
	private SaoriUI ui;
	public FallingEvent(SaoriUI ui){
		this.ui=ui;
	}
	@Override
	public void run(){
		try {
			int height=Toolkit.getDefaultToolkit().getScreenSize().height;
			Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
			int max = maxBounds.height;
			int i = (int) ui.getLocation().getY();
			while (true){
				if (i==max-(height-max)){
					continue;
				}
				if (i!=max-(height-max)){
					if (i>height) i=0;
					i+=1;
					ui.setLocation((int) ui.getLocation().getX(),i);
				}
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
