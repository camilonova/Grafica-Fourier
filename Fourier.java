/*
 * Created on 01-may-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 * @author N-Solutions
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Fourier extends JApplet{
	
	private JPanel panel = new JPanel();
	private JSplitPane splitpane;
	private GraficaFourier grafica1 = new GraficaFourier();
	private GraficaFourier grafica2 = new GraficaFourier();
	private JTextField ciclos = new JTextField();
	private JTextField aprox = new JTextField();
	
	public void init(){
		setName("Grafica de serie de Fourier");
		getContentPane().add(graficar());
	}

	private Component graficar() {
				
		JButton boton = new JButton("Calcular");
		splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, grafica1, grafica2);
		splitpane.setEnabled(false);
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				grafica2.editar(Integer.parseInt(ciclos.getText()), Integer.parseInt(aprox.getText()));
				grafica2.repaint();
				panel.repaint();
			}
		});
		
		ciclos.setPreferredSize(new Dimension(20,20));
		aprox.setPreferredSize(new Dimension(20,20));
			
		grafica1.setPreferredSize(new Dimension(600,240));
		grafica2.setPreferredSize(new Dimension(600,240));
		
		grafica1.setBackground(Color.WHITE);
		grafica2.setBackground(Color.WHITE);
		
		panel.add(splitpane);
		panel.add(new JLabel("Numero de ciclos: "));
		panel.add(ciclos);
		panel.add(new JLabel("Numero de aproximaciones: "));
		panel.add(aprox);
		panel.add(boton);
		
		return panel;
	}
}
