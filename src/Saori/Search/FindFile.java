package Saori.Search;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * FindFile is command that have findFile method ,openFile method 
 * @author Wanchanapon Thanwaranurak
 * @version 5/7/2015
 */
public class FindFile {
	protected ArrayList<String> fileFrom ;
	public FindFile(){
		fileFrom = new ArrayList<String>();
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
}