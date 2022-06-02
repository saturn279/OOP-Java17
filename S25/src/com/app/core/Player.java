/**
 * 
 */
package com.app.core;

import java.io.Serializable;


public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private int id, ranking;
	private double points;
	private static int count;
	public Player(String name, int ranking, double points) {
		super();
		this.name = name;
		this.id = count++;
		this.ranking = ranking;
		this.points = points;
	}
	public int getRanking() {
		return ranking;
	}
	@Override
	public String toString() {
		return "\nPlayer [name=" + name + ", id=" + id + ", ranking=" + ranking + ", points=" + points + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Player)
			return ((Player)obj).getId() == this.id;
		return false;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPoints() {
		return points;
	}
	public Player(int id) {
		super();
		this.id = id;
	}
	
	
	
	
}
