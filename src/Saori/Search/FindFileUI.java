package Saori.Search;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import Core.SaoriUI;
/**
 * FindFileUI is GUI of FindFile
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class FindFileUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7835782992446656174L;
	// attributes for graphical components
	private FindFile findfile;
	@SuppressWarnings("unused")
	private JPanel pane , panelButton;
	private JLabel searchFrom , fileName ;
	@SuppressWarnings("rawtypes")
	protected JComboBox searchFromBox ;
	protected JTextField fileNameTextField ;
	private JButton searchButton , openButton;
	@SuppressWarnings("rawtypes")
	protected JList jList ;
	private JScrollPane scrollPane ;
	@SuppressWarnings("rawtypes")
	DefaultListModel listModel = new DefaultListModel();
	/**
	 * Constructor for new DigitalClockUI
	 */
	public FindFileUI(){
		this.setTitle( "SearchFile" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 285);
		setResizable(false);
		this.initComponents();
		this.findfile = new FindFile(this) ;
	}
	/**
	 * initialize components in the window
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents(){

		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);

		searchFrom = new JLabel("the directory where to search");
		searchFrom.setFont(new Font("Tahoma", 1, 12)); 
		searchFrom.setBounds(0, 0, 204, 25);


		searchFromBox = new JComboBox(File.listRoots());
		searchFromBox.setBounds(0, 25, 204, 25);

		fileName = new JLabel("the file to be searched");
		fileName.setFont(new Font("Tahoma", 1, 12)); 
		fileName.setBounds(0, 50, 204, 25);

		fileNameTextField = new JTextField();
		fileNameTextField.setBounds(0, 75, 204, 25);
		fileNameTextField.setColumns(10);
		fileNameTextField.addKeyListener(new KeyListener(){

			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					listModel.clear();
					SwingWorker< Void, Void > worker = new SwingWorker<Void, Void>() {

						protected Void doInBackground() throws Exception {
							findfile.doInBackground();
							return null;
						}
						protected void done(){
							findfile.done();
						}
					};
					worker.execute();
				}
			}
			public void keyReleased(KeyEvent e) {

			}
			public void keyTyped(KeyEvent e) {

			}
		});

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
				SwingWorker< Void, Void > worker = new SwingWorker<Void, Void>() {

					protected Void doInBackground() throws Exception {
						findfile.doInBackground();
						return null;
					}
					protected void done(){
						findfile.done();
					}
				};
				worker.execute();
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
				openflieActionPerformed();
			}


		});

		pane.add(searchFrom);
		pane.add(searchFromBox);
		pane.add(fileName);
		pane.add(fileNameTextField);
		pane.add(scrollPane);
		pane.add(searchButton);
		pane.add(openButton);

	}//end initComponents
	/**
	 * openflieActionPerformed is action open file when you click open
	 */
	private void openflieActionPerformed() {
		this.findfile.openFile( jList.getSelectedValue()+"");
	}//end openflieActionPerformed


}