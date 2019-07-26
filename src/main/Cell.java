package main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Cell {
	
	private String name;
	private int level;
	private LinkedList<Cell> connections;
	private LinkedList<Cell> uses;
	
	public Cell(String name, int level) {
		super();
		connections = new LinkedList<Cell>();
		uses = new LinkedList<Cell>();
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
	
	public List<Cell> getUses() {
		return uses;
	}
	
	public void addUse(Cell c) {
		uses.add(c);
	}
	
	public void printUses() {
		HashSet<String> res = new HashSet<String>();
		while(!uses.isEmpty()) {
			Cell c = uses.pop();
			res.add(c.getName());
			for(Cell ce : c.uses) {
				uses.add(ce);
			}

		}
		
		for(String s : res) {
			System.out.println(s);
		}
	}

}
