package search;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

import org.javatuples.Pair;

import model.City;
import util.Result;

public class AStarAlgorithm {
	/**
	 * Executa o algoritmo de busca A* a fim de encontrar o caminho entre duas Citys.<br>
	 * Referência bibliográfica: <i>http://en.wikipedia.org/wiki/A*_search_algorithm</i>
	 * @param ladj Adjacency List
	 * @param origin Origin city.
	 * @param destination Destination City.
	 * @return Result.
	 * @see auxiliar.Result
	 */
	public static Result Run(AdjacencyList ladj, City origin, City destination) {
		
		long before, after;
		
		before = System.currentTimeMillis();
		
		Result res = new Result(origin, destination);
		
		HashSet<City> closedSet = new HashSet<City>();
		HashSet<City> openSet = new HashSet<City>();
		
		openSet.add(origin);
		
		Hashtable<City, Double> f_score = new Hashtable<City, Double>();
		Hashtable<City, Double> g_score = new Hashtable<City, Double>();
		
		g_score.put(origin, 0.0);
		f_score.put(origin, g_score.get(origin) + Heuristic.Haversine(origin.getLatitude(), origin.getLongitude(), destination.getLatitude(), destination.getLongitude()));
		
		while (!openSet.isEmpty()) {
			
			City current = null;
			double currentBest = Double.MAX_VALUE;
			Iterator<City> setIterator = openSet.iterator();
			
			while (setIterator.hasNext()) {
				City cit = setIterator.next();
				if (f_score.get(cit) < currentBest) {
					currentBest = f_score.get(cit);
					current = cit;
				}
			}
			
			if (current.equals(destination)) {
				after = System.currentTimeMillis();
				res.setExecutionTime(after-before);
				return res;
			}

			openSet.remove(current);
			closedSet.add(current);
			
			double tentative_g_score;
			Iterator<Pair<City,Double>> pairIterator = ladj.getNeighbors(current).iterator();
			while (pairIterator.hasNext()) {
				
				Pair<City,Double> atual = pairIterator.next();
				City viz = atual.getValue0();
				
				if (closedSet.contains(viz))
					continue;
				tentative_g_score = g_score.get(current) + atual.getValue1();
				
				if (!openSet.contains(viz) || tentative_g_score < g_score.get(viz)) {
					res.addEdge(viz, current, atual.getValue1());
					g_score.put(viz, tentative_g_score);
					f_score.put(viz, g_score.get(viz) + Heuristic.Haversine(origin.getLatitude(), origin.getLongitude(), destination.getLatitude(), destination.getLongitude()));
					if (!openSet.contains(viz))
						openSet.add(viz);
				}
			}			
		}
		
		return res;
	}
}
