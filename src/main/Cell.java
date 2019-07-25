package main;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	
	String name;
	int level;
	List<Cell> connections;
	
	public Cell(String name, int level) {
		super();
		connections = new ArrayList();
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
		for(Cell conn : this.connections) {
			System.out.println(conn.getName());
			conn.printConnecs();
		}
	}
	
	@Override
	public boolean equals(Object c) {
		return (name.equals(((Cell) c).name) && level == ((Cell) c).level);
	}

}
