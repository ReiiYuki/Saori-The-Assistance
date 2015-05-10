package Saori.Search;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingWorker;
/**
 * FindFile is command that have findFile method ,openFile method 
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class FindFile extends SwingWorker{
	protected ArrayList<String> fileFrom ;
	private FindFileUI findfileUI;
	public FindFile(FindFileUI findfileUI){
		fileFrom = new ArrayList<String>();
		this.findfileUI = findfileUI ;
	}
	/**
	 * findFile is find file on computer that you want
	 * @param name is name of file that that you want to search ,type String
	 * @param file is directory that you want to search ,type File
	 */
	public void findFile(String name,File file){
		File[] list = file.listFiles();
		System.out.println(file.getAbsolutePath());
		if(list!=null)
			for (File fil : list)
			{
				if (fil.isDirectory())
				{
					findFile(name,fil);
				}
				else if (fil.getName().contains(name))
				{
					fileFrom.add(fil.getPath());
				}
			}
	}
	/**
	 * openFile is open file on computer that you want
	 * @param fileFrom is file that you want to open
	 */
	public void openFile(String fileFrom){
		File file = new File(fileFrom);
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(file);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	/**
	 * do SwingWorker in background, dot't show in monitor
	 */
	protected Object doInBackground() throws Exception {
		this.findFile(this.findfileUI.fileNameTextField.getText() , new File(this.findfileUI.searchFromBox.getSelectedItem()+""));
		return null;
	}
	/**
	 * when do SwingWorker finish, program do this method
	 */
	protected void done(){
		for (int i = 0; i < this.fileFrom.size(); i++) {
			this.findfileUI.listModel.add(i, this.fileFrom.get(i));
		}
		this.findfileUI.jList.setModel(this.findfileUI.listModel);
	}
}