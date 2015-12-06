package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.javatuples.Pair;

import model.City;

public class Result {
	
	private City originCity, destinationCity;
	private double totalDistance = 0.0;
	private long executionTime = 0;
	private HashMap<City,Pair<City,Double>> arestaPara = null;

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	/**
	 * Efetua uma conexão unilateral entre duas Cities a fim de armazenar o caminho encontrado pelo A*.
	 * @param origin Origin city.
	 * @param destination Destination city.
	 * @param distance Distance between the cities.
	 */
	public void addEdge(City origin, City destination, double distance) {
		if (this.arestaPara == null)
			arestaPara = new HashMap<City, Pair<City,Double>>();
		arestaPara.put(origin, new Pair<City, Double>(destination, distance));
	}

	/**
	 * Monta o caminho inverso (pilha) encontrado pelo A*.
	 * @return Caminho em ordem inversa (pilha).
	 */
	private Stack<City> findPath() {
		totalDistance = 0;
		Stack<City> st = new Stack<City>();
		City aux = destinationCity;
		while (!aux.equals(originCity)) {
			st.push(aux);
			totalDistance += this.arestaPara.get(aux).getValue1();
			aux = this.arestaPara.get(aux).getValue0();
		}
		st.push(originCity);
		return st;
	}

	/**
	 * Creates the correct path found by the A* .
	 * @return Path in correct order.
	 */
	private List<City> rebuildPath(Stack<City> stack) {
		List<City> path = new ArrayList<City>();
		while (!stack.empty()) path.add(stack.pop());
		return path;
	}

	/**
	 * Displays information about the path and distance found by A*
	 */
	public String getRouteInformation() {
		StringBuffer buffer = new StringBuffer();
		Stack<City> stack = findPath();
		List<City> path = rebuildPath(stack);
		buffer.append("Caminho:\n");
		for (City c : path)
			buffer.append("\t-> " +  c.getName() + "\n");
		buffer.append(String.format("\nDistancia total:\n\t%.2f km\n", totalDistance));
		buffer.append(String.format("\nTempo de execucao:\n\t%d ms\n", executionTime));
		return buffer.toString();
	}

	public Result(City originCity, City destinationCity) {
		this.originCity = originCity;
		this.destinationCity = destinationCity;
	}
}
