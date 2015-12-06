package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.City;
import search.AStarAlgorithm;
import search.Graph;
import util.Result;

public class AStarPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public AStarPanel() {

		final JComboBox<City> cbFrom = new JComboBox<City>();		
		final JComboBox<City> cbTo = new JComboBox<City>();

		final List<City> cities = Graph.getInstance().getCities();

		for(int i=0; i<cities.size(); i++)
		{
			cbFrom.addItem(cities.get(i));
			cbTo.addItem(cities.get(i));
		}

		final JPanel panelResult = new JPanel();
		panelResult.setBackground(SystemColor.control);
		panelResult.setForeground(SystemColor.desktop);
		panelResult.setBorder(new LineBorder(SystemColor.windowBorder, 1, true));
		panelResult.setLayout(new BorderLayout(0, 0));

		final JLabel lblTitle = new JLabel("Algoritmo A* para o c\u00E1lculo de rotas rodovi\u00E1rias modeladas atrav\u00E9s de um grafo");
		lblTitle.setFont(lblTitle.getFont().deriveFont(lblTitle.getFont().getStyle() | Font.BOLD));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLACK);

		final JLabel lblFrom = new JLabel("De:");
		final JLabel lblTo = new JLabel("Para:");

		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		final JScrollPane scrollPane = new JScrollPane(textArea);
		panelResult.add(scrollPane, BorderLayout.CENTER);
		
		final JButton btnRunAStar = new JButton("Buscar melhor rota");
		btnRunAStar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				City cityFrom = (City)cbFrom.getSelectedItem();
				City cityTo = (City)cbTo.getSelectedItem();
				
				Graph g = Graph.getInstance();
				
				Result result = AStarAlgorithm.Run(g.getAdjacencyList(), cityFrom, cityTo);
				textArea.setText("");
				textArea.setText(result.getRouteInformation());
			}
		});
		
		final GroupLayout groupLayout = new GroupLayout(this);
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelResult, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
						.addComponent(btnRunAStar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cbFrom, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFrom))
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTo)
								.addComponent(cbTo, 0, 240, Short.MAX_VALUE))))
					.addContainerGap())
		);
		
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFrom)
						.addComponent(lblTo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRunAStar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelResult, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		setLayout(groupLayout);
	}
}
