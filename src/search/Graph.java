package search;

import java.util.Arrays;
import java.util.List;

import model.City;

public final class Graph {
	
	private List<City> cities;
	private AdjacencyList adjacencyList;
	private static Graph INSTANCE;
	
	public List<City> getCities() {
		return cities;
	}
	
	public AdjacencyList getAdjacencyList() {
		return adjacencyList;
	}

	public static Graph getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Graph();
		return INSTANCE;
	}

	private Graph() {
		this.buildCities();
		this.buildAdjacencyList();
	}
	
	private void buildCities() {
		
		this.cities = Arrays.asList(
			new City("Amparo", -22.708059, -46.772665),
			new City("Atibaia", -23.117549, -46.556707),
			new City("Bom Jesus dos Perd�es", -23.136087, -46.467908),
			new City("Borda da Mata", -22.269158, -46.164069),
			new City("Bragan�a Paulista", -22.953170, -46.542324),
			new City("Bras�polis", -22.473871, -45.617999),
			new City("Bueno Brand�o", -22.439091, -46.348740),
			new City("Ca�apava", -23.099697, -45.708082),
			new City("Cachoeira de Minas", -22.354255, -45.779352),
			new City("Camanducaia", -22.748659, -46.135228),
			new City("Cambu�", -22.611883, -46.057707),
			new City("Campinas", -22.909938, -47.062633),
			new City("Campos do Jord�o", -22.742867, -45.596356),
			new City("Delfim Moreira", -22.508501, -45.280302),
			new City("Estiva", -22.458183, -46.019488),		
			new City("Extrema", -22.853210, -46.321698),
			new City("Guaratinguet�", -22.808027, -45.194220),
			new City("Igarat�", -23.205227, -46.156279),
			new City("Inconfidentes", -22.314048, -46.326852),
			new City("Itajub�", -22.422971, -45.460251),
			new City("Itapira", -22.436217, -46.822879),
			new City("Itatiba", -23.003986, -46.846800),
			new City("Jacare�", -23.298783, -45.966254),
			new City("Jacutinga", -22.283227, -46.608926),
			new City("Jaguari�na", -22.704227, -46.985509),
			new City("Joan�polis", -22.929262, -46.275386),
			new City("Lind�ia", -22.522982, -46.650235),
			new City("Lorena", -22.733872, -45.120111),
			new City("Mogi Mirim", -22.432364, -46.950960),
			new City("Monte Si�o", -22.433758, -46.575063),
			new City("Monteiro Lobato", -22.954555, -45.838692),
			new City("Morungaba", -22.879582, -46.793819),
			new City("Ouro Fino", -22.278537, -46.371213),
			new City("Parais�polis", -22.548794, -45.775068),
			new City("Pedreira", -22.741825, -46.895288),
			new City("Piquete", -22.612959, -45.179044),
			new City("Piracaia", -23.053036, -46.359817),
			new City("Pirangu�u", -22.527733, -45.496221),
			new City("Piranguinho", -22.402909, -45.533958),
			new City("Pouso Alegre", -22.227078, -45.939372),
			new City("Rosas", -22.766667, -45.683333),
			new City("Roseira", -22.901139, -45.309188),
			new City("Santa Rita do Sapuca�", -22.252252, -45.703597),
			new City("Santo Ant�nio do Pinhal", -22.825267, -45.667100),
			new City("S�o Bento do Sapuca�", -22.687425, -45.731988),
			new City("S�o Jos� dos Campos", -23.223701, -45.900907),
			new City("Socorro", -22.590591, -46.528297),
			new City("Taubat�", -23.020456, -45.556355),
			new City("Trememb�", -22.957632, -45.547962),
			new City("Vargem", -22.887536, -46.412890),
			new City("Wenceslau Braz", -22.537327, -45.363069)		
		);
	}
	
	private void buildAdjacencyList() {
		
		// Cities		
		City amparo = cities.get(0);
		City atibaia = cities.get(1);
		City bomJesusDosPerdoes = cities.get(2);
		City bordaDaMata = cities.get(3);
		City bragancaPaulista = cities.get(4);
		City brasopolis = cities.get(5);
		City buenoBrandao = cities.get(6);
		City cacapava = cities.get(7);
		City cachoeiraDeMinas = cities.get(8);
		City camanducaia = cities.get(9);
		City cambui = cities.get(10);
		City campinas = cities.get(11);
		City camposDoJordao = cities.get(12);
		City delfimMoreira = cities.get(13);
		City estiva = cities.get(14);
		City extrema = cities.get(15);
		City guaratingueta = cities.get(16);
		City igarata = cities.get(17);
		City inconfidentes = cities.get(18);
		City itajuba = cities.get(19);
		City itapira = cities.get(20);
		City itatiba = cities.get(21);
		City jacarei = cities.get(22);
		City jacutinga = cities.get(23);
		City jaguariuna = cities.get(24);
		City joanopolis = cities.get(25);
		City lindoia = cities.get(26);
		City lorena = cities.get(27);
		City mogiMirim = cities.get(28);
		City monteSiao = cities.get(29);
		City monteiroLobato = cities.get(30);
		City morungaba = cities.get(31);
		City ouroFino = cities.get(32);
		City paraisopolis = cities.get(33);
		City pedreira = cities.get(34);
		City piquete = cities.get(35);
		City piracaia = cities.get(36);
		City pirangucu = cities.get(37);
		City piranguinho = cities.get(38);
		City pousoAlegre = cities.get(39);
		City rosas = cities.get(40);
		City roseira = cities.get(41);
		City santaRitaDoSapucai = cities.get(42);
		City santoAntonioDoPinhal = cities.get(43);
		City saoBentoDoSapucai = cities.get(44);
		City saoJoseDosCampos = cities.get(45);
		City socorro = cities.get(46);
		City taubate = cities.get(47);
		City tremembe = cities.get(48);
		City vargem = cities.get(49);
		City wenceslauBraz = cities.get(50);
		
		// Adjacency List
		this.adjacencyList = new AdjacencyList();
		
		// Amparo		
		adjacencyList.connectOneWay(amparo, bragancaPaulista, 44.9);
		adjacencyList.connectOneWay(amparo, lindoia, 32.3);
		adjacencyList.connectOneWay(amparo, morungaba, 25.7);
		adjacencyList.connectOneWay(amparo, pedreira, 16.0);

		// Atibaia		
		adjacencyList.connectOneWay(atibaia, bomJesusDosPerdoes, 13.5);
		adjacencyList.connectOneWay(atibaia, bragancaPaulista, 25.2);
		adjacencyList.connectOneWay(atibaia, itatiba, 40.1);
		
		// Bom Jesus dos Perd�es
		adjacencyList.connectOneWay(bomJesusDosPerdoes, atibaia, 13.5);
		adjacencyList.connectOneWay(bomJesusDosPerdoes, igarata, 39.1);
		adjacencyList.connectOneWay(bomJesusDosPerdoes, piracaia, 18.7);		
		
		// Borda da Mata
		adjacencyList.connectOneWay(bordaDaMata, inconfidentes, 21.0);
		adjacencyList.connectOneWay(bordaDaMata, pousoAlegre, 28.7);
		
		// Bragan�a Paulista
		adjacencyList.connectOneWay(bragancaPaulista, amparo, 44.9);
		adjacencyList.connectOneWay(bragancaPaulista, atibaia, 25.2);
		adjacencyList.connectOneWay(bragancaPaulista, itatiba, 40.0);
		adjacencyList.connectOneWay(bragancaPaulista, piracaia, 27.0);
		adjacencyList.connectOneWay(bragancaPaulista, socorro, 46.9);
		adjacencyList.connectOneWay(bragancaPaulista, vargem, 23.2);
		
		// Bras�polis		
		adjacencyList.connectOneWay(brasopolis, paraisopolis, 24.9);
		adjacencyList.connectOneWay(brasopolis, piranguinho, 16.0);
		
		// Bueno Brand�o
		adjacencyList.connectOneWay(buenoBrandao, inconfidentes, 27.1);
		adjacencyList.connectOneWay(buenoBrandao, socorro, 35.5);
	
		// Ca�apava		
		adjacencyList.connectOneWay(cacapava, saoJoseDosCampos, 25.9);
		adjacencyList.connectOneWay(cacapava, taubate, 20.0);
				
		// Cachoeira de Minas		
		adjacencyList.connectOneWay(cachoeiraDeMinas, paraisopolis, 24.8);
		adjacencyList.connectOneWay(cachoeiraDeMinas, santaRitaDoSapucai, 34.4);
			
		// Camanducaia
		adjacencyList.connectOneWay(camanducaia, cambui, 20.5);
		adjacencyList.connectOneWay(camanducaia, extrema, 27.4);
			
		// Cambu�	
		adjacencyList.connectOneWay(cambui, camanducaia, 20.5);
		adjacencyList.connectOneWay(cambui, estiva, 20.1);
		adjacencyList.connectOneWay(cambui, paraisopolis, 38.5);
		
		// Campinas	
		adjacencyList.connectOneWay(campinas, itatiba, 31.9);
		adjacencyList.connectOneWay(campinas, jaguariuna, 34.0);
		
		// Campos do Jord�o	
		adjacencyList.connectOneWay(camposDoJordao, pirangucu, 39.9);
		adjacencyList.connectOneWay(camposDoJordao, rosas, 15.6);
		adjacencyList.connectOneWay(camposDoJordao, santoAntonioDoPinhal, 27.6);
		
		// Delfim Moreira
		adjacencyList.connectOneWay(delfimMoreira, itajuba, 28.6);
		adjacencyList.connectOneWay(delfimMoreira, piquete, 26.1);
		
		// Estiva		
		adjacencyList.connectOneWay(estiva, cambui, 20.1);
		adjacencyList.connectOneWay(estiva, pousoAlegre, 33.6);
			
		// Extrema	
		adjacencyList.connectOneWay(extrema, camanducaia, 27.4);
		adjacencyList.connectOneWay(extrema, vargem, 11.6);
		
		// Guaratinguet�
		adjacencyList.connectOneWay(guaratingueta, lorena, 21.3);
		adjacencyList.connectOneWay(guaratingueta, roseira, 17.5);
		
		// Igarat�
		adjacencyList.connectOneWay(igarata, bomJesusDosPerdoes, 39.1);
		adjacencyList.connectOneWay(igarata, jacarei, 31.2);
		
		// Inconfidentes
		adjacencyList.connectOneWay(inconfidentes, bordaDaMata, 21.0);
		adjacencyList.connectOneWay(inconfidentes, buenoBrandao, 27.1);
		adjacencyList.connectOneWay(inconfidentes, ouroFino, 18.6);
		
		//Itajub�
		adjacencyList.connectOneWay(itajuba, delfimMoreira, 28.6);
		adjacencyList.connectOneWay(itajuba, pirangucu, 13.4);
		adjacencyList.connectOneWay(itajuba, piranguinho, 11.1);
		adjacencyList.connectOneWay(itajuba, wenceslauBraz, 23.0);
		
		// Itapira
		adjacencyList.connectOneWay(itapira, jacutinga, 32.4);
		adjacencyList.connectOneWay(itapira, lindoia, 26.8);
		adjacencyList.connectOneWay(itapira, mogiMirim, 17.4);
		
		// Itatiba		
		adjacencyList.connectOneWay(itatiba, atibaia, 40.1);
		adjacencyList.connectOneWay(itatiba, bragancaPaulista, 40.0);
		adjacencyList.connectOneWay(itatiba, campinas, 31.9);
		adjacencyList.connectOneWay(itatiba, morungaba, 18.6);
		
		// Jacare�		
		adjacencyList.connectOneWay(jacarei, igarata, 31.2);
		adjacencyList.connectOneWay(jacarei, saoJoseDosCampos, 14.6);
		
		// Jacutinga
		adjacencyList.connectOneWay(jacutinga, itapira, 32.4);
		adjacencyList.connectOneWay(jacutinga, ouroFino, 33.1);
		
		// Jaguari�na		
		adjacencyList.connectOneWay(jaguariuna, campinas, 34.0);
		adjacencyList.connectOneWay(jaguariuna, mogiMirim, 39.3);
		adjacencyList.connectOneWay(jaguariuna, pedreira, 13.6);
		
		
		// Joan�polis
		adjacencyList.connectOneWay(joanopolis, piracaia, 25.3);
		adjacencyList.connectOneWay(joanopolis, vargem, 22.8);
		
		// Lind�ia
		adjacencyList.connectOneWay(lindoia, amparo, 32.3);
		adjacencyList.connectOneWay(lindoia, itapira, 26.8);
		adjacencyList.connectOneWay(lindoia, monteSiao, 15.8);
		adjacencyList.connectOneWay(lindoia, socorro, 20.3);
				
		// Lorena
		adjacencyList.connectOneWay(lorena, guaratingueta, 21.3);
		adjacencyList.connectOneWay(lorena, piquete, 19.3);
			
		// Mogi Mirim
		adjacencyList.connectOneWay(mogiMirim, itapira, 17.4);
		adjacencyList.connectOneWay(mogiMirim, jaguariuna, 39.3);
		
		// Monte Si�o
		adjacencyList.connectOneWay(monteSiao, lindoia, 15.8);
		adjacencyList.connectOneWay(monteSiao, ouroFino, 36.7);
		
		// Monteiro Lobato
		adjacencyList.connectOneWay(monteiroLobato, santoAntonioDoPinhal, 36.2);
		adjacencyList.connectOneWay(monteiroLobato, saoBentoDoSapucai, 42.2);
		adjacencyList.connectOneWay(monteiroLobato, saoJoseDosCampos, 39.9);
		
		// Morungaba
		adjacencyList.connectOneWay(morungaba, amparo, 25.7);
		adjacencyList.connectOneWay(morungaba, itatiba, 18.6);
		
		// Ouro Fino
		adjacencyList.connectOneWay(ouroFino, inconfidentes, 18.6);
		adjacencyList.connectOneWay(ouroFino, jacutinga, 33.1);
		adjacencyList.connectOneWay(ouroFino, monteSiao, 36.7);
		
		// Parais�polis
		adjacencyList.connectOneWay(paraisopolis, brasopolis, 24.9);
		adjacencyList.connectOneWay(paraisopolis, cachoeiraDeMinas, 24.8);
		adjacencyList.connectOneWay(paraisopolis, cambui, 38.5);
		adjacencyList.connectOneWay(paraisopolis, saoBentoDoSapucai, 18.3);
		
		// Pedreira		
		adjacencyList.connectOneWay(pedreira, amparo, 16.0);
		adjacencyList.connectOneWay(pedreira, jaguariuna, 13.6);
		
		// Piquete		
		adjacencyList.connectOneWay(piquete, delfimMoreira, 26.1);
		adjacencyList.connectOneWay(piquete, lorena, 19.3);
		adjacencyList.connectOneWay(piquete, wenceslauBraz, 41.2);
		
		// Piracaia
		adjacencyList.connectOneWay(piracaia, bomJesusDosPerdoes, 18.7);
		adjacencyList.connectOneWay(piracaia, bragancaPaulista, 27.0);
		adjacencyList.connectOneWay(piracaia, joanopolis, 25.3);
		
		// Pirangu�u
		adjacencyList.connectOneWay(pirangucu, camposDoJordao, 39.9);
		adjacencyList.connectOneWay(pirangucu, itajuba, 13.4);
		
		// Piranguinho
		adjacencyList.connectOneWay(piranguinho, brasopolis, 16.0);
		adjacencyList.connectOneWay(piranguinho, itajuba, 11.1);
		adjacencyList.connectOneWay(piranguinho, santaRitaDoSapucai, 43.1);
		
		// Pouso Alegre
		adjacencyList.connectOneWay(pousoAlegre, bordaDaMata, 28.7);
		adjacencyList.connectOneWay(pousoAlegre, estiva, 33.6);
		adjacencyList.connectOneWay(pousoAlegre, santaRitaDoSapucai, 40.8);
			
		// Rosas
		adjacencyList.connectOneWay(rosas, camposDoJordao, 15.6);
		adjacencyList.connectOneWay(rosas, saoBentoDoSapucai, 17.6);
		
		// Roseira		
		adjacencyList.connectOneWay(roseira, guaratingueta, 17.5);
		adjacencyList.connectOneWay(roseira, taubate, 32.2);
		
		// Santa Rita do Sapuca�
		adjacencyList.connectOneWay(santaRitaDoSapucai, cachoeiraDeMinas, 34.4);
		adjacencyList.connectOneWay(santaRitaDoSapucai, piranguinho, 43.1);
		adjacencyList.connectOneWay(santaRitaDoSapucai, pousoAlegre, 40.8);
		
		// Santo Ant�nio do Pinhal
		adjacencyList.connectOneWay(santoAntonioDoPinhal, camposDoJordao, 27.6);
		adjacencyList.connectOneWay(santoAntonioDoPinhal, monteiroLobato, 36.2);
		adjacencyList.connectOneWay(santoAntonioDoPinhal, tremembe, 35.2);
		
		// S�o Bento do Sapuca�
		adjacencyList.connectOneWay(saoBentoDoSapucai, monteiroLobato, 42.2);
		adjacencyList.connectOneWay(saoBentoDoSapucai, paraisopolis, 18.3);
		adjacencyList.connectOneWay(saoBentoDoSapucai, rosas, 17.6);
		
		// S�o Jos� dos Campos		
		adjacencyList.connectOneWay(saoJoseDosCampos, cacapava, 25.9);
		adjacencyList.connectOneWay(saoJoseDosCampos, jacarei, 14.6);
		adjacencyList.connectOneWay(saoJoseDosCampos, monteiroLobato, 39.9);
		
		// Socorro
		adjacencyList.connectOneWay(socorro, bragancaPaulista, 46.9);
		adjacencyList.connectOneWay(socorro, buenoBrandao, 35.5);
		adjacencyList.connectOneWay(socorro, lindoia, 20.3);
				
		// Taubat�
		adjacencyList.connectOneWay(taubate, cacapava, 20.0);
		adjacencyList.connectOneWay(taubate, roseira, 32.2);
		adjacencyList.connectOneWay(taubate, tremembe, 8.5);
		
		// Trememb�
		adjacencyList.connectOneWay(tremembe, santoAntonioDoPinhal, 35.2);
		adjacencyList.connectOneWay(tremembe, taubate, 8.5);
		
		// Vargem
		adjacencyList.connectOneWay(vargem, bragancaPaulista, 23.2);
		adjacencyList.connectOneWay(vargem, extrema, 11.6);
		adjacencyList.connectOneWay(vargem, joanopolis, 22.8);
		
		// Wenceslau Braz		
		adjacencyList.connectOneWay(wenceslauBraz, itajuba, 23.0);
		adjacencyList.connectOneWay(wenceslauBraz, piquete, 41.2);
	}
}
