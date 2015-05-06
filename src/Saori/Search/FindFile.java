package Saori.Search;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JList;
import javax.swing.ListModel;

import Saori.Calculator.CalculatorUI;

public class FindFile {
	private FindFileUI findfileUI;
	public FindFile(FindFileUI findfileUI){
		this.findfileUI = findfileUI;
	}
	public void findFile(String name,File file){
		File[] list = file.listFiles();
		ArrayList<String> fileFrom = new ArrayList<String>();
		if(list!=null)
			for (File fil : list)
			{
				if (fil.isDirectory())
				{
					findFile(name,fil);
				}
				else if (name.equalsIgnoreCase(fil.getName()))
				{
					fileFrom.add(fil.getParentFile()+"");
				}
			}
		this.findfileUI.jlist = new JList((ListModel) fileFrom);
	}
//    public static void main(String[] args) 
//    {
//        FindFile ff = new FindFile();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the file to be searched.. " );
//        String name = scan.next();
//        System.out.println("Enter the directory where to search ");
//        String directory = scan.next();
//        ff.findFile(name,new File(directory));
//    }
}
