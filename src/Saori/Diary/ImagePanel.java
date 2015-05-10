package Saori.Diary;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * JPanel which have image as the background.
 * @author Voraton Lertrattanapaisal
 */
public class ImagePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3441543622349777546L;
	private String url;
	public ImagePanel(String url) {
		this.url = url;
	}
	@Override
	public void paintComponent(Graphics g) {
	    g.drawImage(new ImageIcon(ClassLoader.getSystemResource(url)).getImage(), 0, 0, null);
	 }
}
