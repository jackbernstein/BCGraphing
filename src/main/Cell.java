package main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Cell {
	
	String name;
	int level;
	LinkedList<Cell> connections;
	
	public Cell(String name, int level) {
		super();
		connections = new LinkedList<Cell>();
		this.name = name;
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getName() {
		return name;
	}
	
	public void addConnection(Cell c) {
		connections.add(c);
	}
	
	public List<Cell>  getConnections() {
		return connections;
	}
	
	public void printConnecs() {
		HashSet<String> res = new HashSet<String>();
		while(!connections.isEmpty()) {
			Cell c = connections.pop();
			res.add(c.getName());
			for(Cell ce : c.connections) {
				connections.add(ce);
			}

		}
		for(String s : res) {
			System.out.println(s);
		}
	}
	
	@Override
	public boolean equals(Object c) {
		return (name.equals(((Cell) c).name) && level == ((Cell) c).level);
	}

}
