package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Graph {
	
	static List<List<Cell>> list = new ArrayList<List<Cell>>();
	
	static List<Cell> l1 = new ArrayList<Cell>();
	static List<Cell> l2 = new ArrayList<Cell>();
	static List<Cell> l3 = new ArrayList<Cell>();
	static List<Cell> l4 = new ArrayList<Cell>();
	static List<Cell> l5 = new ArrayList<Cell>();
	
	public static void main(String[] args) throws IOException {
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		list.add(l5);
		
		
		File file = new File("/Users/jackbernstein/Documents/BCTesting.csv");
		FileReader input = new FileReader(file);
		BufferedReader csv = new BufferedReader(input);
		String row;
		
		
		while ((row = csv.readLine()) != null) {
		    String[] parse = row.split(",");
		    Cell first = null;
		    for(int i = 0; i < parse.length; i++) {
		    	String obj = parse[i];
		    	if(obj == "")
		    		continue;
		    	else {
		    		int level = Character.getNumericValue(obj.charAt(1));
		    		String name = obj.substring(3, obj.length());
		    		Cell temp = new Cell(name, level);
		    		switch (level) {
		    		case 1:
		    			if(!l1.contains(temp))
		    				l1.add(temp);
		    			else {
		    				int index = l1.indexOf(temp);
		    				temp = l1.get(index);
		    			}
		    			break;
		    		case 2:
		    			if(!l2.contains(temp))
		    				l2.add(temp);
		    			else {
		    				int index = l2.indexOf(temp);
		    				temp = l2.get(index);
		    			}
		    			break;
		    		case 3:
		    			if(!l3.contains(temp)) {
		    				l3.add(temp);
		    			} else {
		    				int index = l3.indexOf(temp);
		    				temp = l3.get(index);
		    			}
		    			break;
		    		case 4:
		    			if(!l4.contains(temp))
		    				l4.add(temp);
		    			else {
		    				int index = l4.indexOf(temp);
		    				temp = l4.get(index);
		    			}
		    			break;
		    		case 5:
		    			if(!l5.contains(temp))
		    				l5.add(temp);
		    			else {
		    				int index = l5.indexOf(temp);
		    				temp = l5.get(index);
		    			}
		    			break;
		    		default:
		    			break;
		    		} 
		    		if(i == 0)
			    		first = temp;
			    	else if(first != null)
			    		first.addConnection(temp);
		    		
		    	}
		    		
		    		
		    }
		    
		}
		if(args.length != 1)
			System.out.println("No Arguments given");
		else {
			int level = Character.getNumericValue(args[0].charAt(1));
    		String name = args[0].substring(3, args[0].length());
    		Cell temp = new Cell(name, level);
    		for(int i = 0; i < list.get(level - 1).size(); i++) {
    			if(list.get(level-1).get(i).equals(temp))
    				list.get(level-1).get(i).printConnecs();
    		}
		}
		
		
		csv.close();
	}

}
