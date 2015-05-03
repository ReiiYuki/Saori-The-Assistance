package Saori.Search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
public class FindFileUI extends JFrame{
	private JPanel pane ;
	private Timer timer;
	private JLabel searchFrom , fileName ;
	private JComboBox searchFromBox ;
	private JTextField fileNameTextField ;
	private JButton searchButton ;
	private JLabel area ;
	public FindFileUI(){
		this.setTitle( "DigitalClock" );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.initComponents();
	}
	private void initComponents(){
		pane = new JPanel();
		pane.setLayout(new BoxLayout ( pane , BoxLayout.Y_AXIS ) );	
		searchFrom = new JLabel("the directory where to search");
		fileName = new JLabel("the file to be searched    ");
		searchFromBox = new JComboBox();
		searchFromBox.addItem("D:");
		fileNameTextField = new JTextField();
		area = new JLabel();
		searchButton = new JButton("search...");
		pane.add(searchFrom);
		pane.add(searchFromBox);
		pane.add(fileName);
		pane.add(fileNameTextField);
		pane.add(area);
		pane.add(searchButton);


		super.add(pane);
		int delay = 500 ; // milliseconds
		ActionListener task = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				findFile(fileName.getText(),new File(searchFrom.getText()));
			}
		};
		timer = new Timer( delay , task );
		timer.start();
	}
	public void findFile(String name,File file){
		File[] list = file.listFiles();
		if(list!=null)
			for (File fil : list)
			{
				if (fil.isDirectory())
				{
					findFile(name,fil);
				}
				else if (name.equalsIgnoreCase(fil.getName()))
				{
					area.setText(fil.getParentFile()+"\n");
				}
			}
	}
}
