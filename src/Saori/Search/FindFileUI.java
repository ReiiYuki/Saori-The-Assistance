package Saori.Search;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.io.File;
import java.io.IOException;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Saori.Calculator.Calculator;
public class FindFileUI extends JFrame{
	private FindFile findfile;
	private JPanel pane , panelButton;
	private JLabel searchFrom , fileName ;
	private JComboBox searchFromBox ;
	private JTextField fileNameTextField ;
	private JButton searchButton , openButton;
	protected JList jList ;
	private JScrollPane scrollPane ;
	DefaultListModel listModel = new DefaultListModel();
	public FindFileUI(FindFile findfile){
		this.setTitle( "SearchFile" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 285);
		setResizable(false);
		this.initComponents();
		this.findfile = findfile ;
	}
	private void initComponents(){

		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);

		searchFrom = new JLabel("the directory where to search");
		searchFrom.setFont(new Font("Tahoma", 1, 12)); 
		searchFrom.setBounds(0, 0, 204, 25);

		searchFromBox = new JComboBox();
		searchFromBox.setBounds(0, 25, 204, 25);
		searchFromBox.addItem("C:\\");
		searchFromBox.addItem("D:\\");
		searchFromBox.addItem("E:\\");
		searchFromBox.addItem("F:\\");

		fileName = new JLabel("the file to be searched");
		fileName.setFont(new Font("Tahoma", 1, 12)); 
		fileName.setBounds(0, 50, 204, 25);

		fileNameTextField = new JTextField();
		fileNameTextField.setBounds(0, 75, 204, 25);
		fileNameTextField.setColumns(10);

		jList = new JList();
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 100, 204, 111);
		scrollPane.setViewportView(jList);

		searchButton = new JButton(" search ");
		searchButton.setFont(new Font("Tahoma", 1, 12)); 
		searchButton.setBounds(20, 222, 80, 30);
		searchButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.setFocusable(false);
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				listModel.clear();
				findflieActionPerformed();
			}
		});
		searchButton.addKeyListener(new KeyListener(){
	
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					listModel.clear();
					findflieActionPerformed();
				}
			}
			public void keyReleased(KeyEvent e) {

			}
			public void keyTyped(KeyEvent e) {

			}
		});
		openButton = new JButton(" open ");
		openButton.setFont(new Font("Tahoma", 1, 12)); 
		openButton.setBounds(110, 222, 80, 30);
		openButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
		openButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		openButton.setFocusable(false);
		openButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				openflieActionPerformed( e );
			}


		});

		pane.add(searchFrom);
		pane.add(searchFromBox);
		pane.add(fileName);
		pane.add(fileNameTextField);
		pane.add(scrollPane);
		pane.add(searchButton);
		pane.add(openButton);

	}
	private void findflieActionPerformed() {
		this.findfile.fileFrom.clear();
		this.findfile.findFile( fileNameTextField.getText() , new File(searchFromBox.getSelectedItem()+"") );
		for (int i = 0; i < this.findfile.fileFrom.size(); i++) {
			listModel.add(i, this.findfile.fileFrom.get(i));
		}
		jList.setModel(listModel);
	}//end findflieActionPerformed
	private void openflieActionPerformed(ActionEvent evt) {
		this.findfile.openFile( jList.getSelectedValue()+"");
	}//end openflieActionPerformed
}
