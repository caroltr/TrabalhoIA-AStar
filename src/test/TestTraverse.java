package test;

import java.util.Arrays;
import java.util.List;

import model.City;

import org.junit.Test;

import search.AStarAlgorithm;
import search.Graph;
import util.Result;

public class TestTraverse {

	@Test
	public void test() {
		
		Graph g = Graph.getInstance();
		
		List<City> cities = g.getCities();
	
		City atibaia = cities.get(1);
		City camanducaia = cities.get(9);
		City cambui = cities.get(10);
		City campinas = cities.get(11);
		City estiva = cities.get(14);
		City extrema = cities.get(15);
		City pousoAlegre = cities.get(39);
		City santaRitaDoSapucai = cities.get(42);
		
		List<City> subCities = Arrays.asList(
				atibaia,
				camanducaia,
				cambui,
				campinas,
				estiva,
				extrema,
				pousoAlegre,
				santaRitaDoSapucai
		);
				
		for(City origem : subCities) {
			for(City destino : subCities) {
				System.out.println(origem.getName() + " -> " + destino.getName());
				Result res = AStarAlgorithm.Run(g.getAdjacencyList(), origem, destino);
				System.out.println(res.getRouteInformation());
			}
		}
		
	}

}
