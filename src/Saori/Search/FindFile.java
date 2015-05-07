package Saori.Search;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.swing.ListModel;

import Saori.Calculator.CalculatorUI;

public class FindFile {
	protected ArrayList<String> fileFrom ;
	public FindFile(){
		fileFrom = new ArrayList<String>();
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
				else if (fil.getName().contains(name))
				{
					fileFrom.add(fil.getPath());
				}
			}
	}
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
