/*
 * Created on 01-may-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * @author N-Solutions
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GraficaFourier extends JPanel{
	
	private double Pi = Math.toRadians(Math.PI);
	private int n, xi,yi,xf,yf;;
	private double temp;
	
	int FACTORESCALADO = 100;
	int ciclos, puntos;
	double[] senos;
	int[] pts;
		
	
	public GraficaFourier(){
		editar(2,100);
	}
	
	public void editar(int c, int n){
		ciclos = c;
		puntos = FACTORESCALADO * ciclos * 2;
		senos = new double[puntos];
		pts = new int[puntos];
		for(int i=0;i<puntos;i++){
			double radianes = (Math.PI/FACTORESCALADO) * i;
			temp = 0;
			for(int j=1;j<=n;j++){
				temp += (4*Math.pow(-1,j) / Math.pow(j,2)) * Math.cos(j*radianes);
			}
			senos[i] = temp+3.3;
		}
		repaint();
	}
	
	public void paintComponent(Graphics funcion){
		super.paintComponent(funcion);
		
		xi = 0;
		yi = (int)getHeight()*3/4;
		xf = getWidth();
		yf = 2;
		
		funcion.fill3DRect(xi,yi,xf,yf,true);
		
		xi = (int)getWidth()/2;
		yi = 0;
		xf = 2;
		yf = getHeight();
		
		funcion.fill3DRect(xi,yi,xf,yf,true);
		
		int anchura = getWidth();
		int altura = getHeight();
		double pasoH = (double)anchura /(double)puntos;
		for(int i=0; i<puntos;i++){
			pts[i] = (int)(senos[i] *altura/2 * -0.95 +3*altura/4);
		}
		funcion.setColor(Color.RED);
		for(int i=1; i<puntos;i++){
			xi = (int)((i-1) * pasoH);
			xf = (int)(i*pasoH);
			yi = (int)pts[i-1];
			yf = (int)pts[i];
			funcion.drawLine(xi,yi,xf,yf);
		}
	}
}
