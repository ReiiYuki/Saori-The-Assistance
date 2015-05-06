package Saori.Search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.Timer;

import Saori.Calculator.Calculator;
public class FindFileUI extends JFrame{
	private FindFile findfile;
	private JPanel pane ;
	private Timer timer;
	private JLabel searchFrom , fileName ;
	private JComboBox searchFromBox ;
	private JTextField fileNameTextField ;
	private JButton searchButton ;
	protected JList jlist ;
	DefaultListModel listModel = new DefaultListModel();
	private String[] c  = {"s","a"};
	public FindFileUI(FindFile findfile){
		this.setTitle( "DigitalClock" );
		this.setDefaultCloseOperation( EXIT_ON_CLOSE );
		this.initComponents();
		this.findfile = findfile ;
	}
	private void initComponents(){
		pane = new JPanel();
		pane.setLayout(new BoxLayout ( pane , BoxLayout.Y_AXIS ) );	
		searchFrom = new JLabel("the directory where to search");
		fileName = new JLabel("the file to be searched    ");
		searchFromBox = new JComboBox();
		searchFromBox.addItem("D:\\");
		fileNameTextField = new JTextField();

		jlist = new JList(listModel);
		searchButton = new JButton("search...");
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				findflieActionPerformed( e );
			}
		});
		pane.add(searchFrom);
		pane.add(searchFromBox);
		pane.add(fileName);
		pane.add(fileNameTextField);
		pane.add(new JScrollPane(jlist));
		pane.add(searchButton);


		super.add(pane);
		//		int delay = 500 ; // milliseconds
		//		ActionListener task = new ActionListener() {
		//			public void actionPerformed(ActionEvent evt) {
		//
		//				findFile(fileName.getText(),new File(searchFrom.getText()));
		//			}
		//		};
		//		timer = new Timer( delay , task );
		//		timer.start();
	}
	private void findflieActionPerformed(ActionEvent evt) {

		this.findfile.fileFrom.clear();
		this.findfile.findFile( fileNameTextField.getText() , new File(searchFromBox.getSelectedItem()+"") );

		for (int i = 0; i < this.findfile.fileFrom.size(); i++) {
			listModel.add(i, this.findfile.fileFrom.get(i));
		}
	
		jlist.setModel(listModel);
	}//end findflieActionPerformed
}
