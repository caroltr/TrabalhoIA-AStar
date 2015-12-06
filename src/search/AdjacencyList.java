package search;

import java.util.HashSet;
import java.util.Hashtable;

import model.City;

import org.javatuples.Pair;

public class AdjacencyList {
	
	private Hashtable<City,HashSet<Pair<City,Double>>> ladj;
	
	public AdjacencyList() {
		this.ladj = new Hashtable<City,HashSet<Pair<City,Double>>>();
	}
	
	/**
	 * Performs a one-way connection between two cities
	 * @param origin Origin city.
	 * @param destination Destination city.
	 * @param distance Distance between cities.
	 */
	public void connectOneWay(City origin, City destination, Double distance) {
		if (this.ladj.get(origin) == null)
			this.ladj.put(origin, new HashSet<Pair<City,Double>>());
		this.ladj.get(origin).add(new Pair<City,Double>(destination, distance));
	}
	
	/**
	 * Performs a two-way connection between two cities
	 * @param origin Origin city.
	 * @param destination Destination city.
	 * @param distance Distance between cities.
	 */
	public void connectTwoWays(City origin, City destination, Double distance) {
		this.connectOneWay(origin, destination, distance);
		this.connectOneWay(destination, origin, distance);
	}
	
	/**
	 * Gets the neighbors (adjacent nodes) of a given city.
	 * @param City Cidade da qual serão obtidas os vizinhos
	 * @return Conjunto de pares cidade-valor, indicando todos os vizinhos àquela passada ao método, bem como a distância entre elas.  
	 */
	public HashSet<Pair<City,Double>> getNeighbors(City city) {
		return this.ladj.get(city);
	}
}
