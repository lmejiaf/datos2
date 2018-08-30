/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author luis
 */
public class Nodo {

    Graphics g;

    int posX, posY, posXcentro, posYcentro;
    int diametro = 50;
    int radio = diametro / 2;

    int xf_AristaS, yf_AristaS;
    int xf_AristaD, yf_AristaD;
    int xf_AristaI, yf_AristaI;
    boolean soyRaizDelArbol;

    int clave;
    Nodo derecho;
    Nodo izquierdo;

    public void graficar(JFrame tablero) {
        g = tablero.getGraphics();
        if (!soyRaizDelArbol) {
            g.drawLine(posX + radio, posY + radio, posX + radio, posY - radio);// superior

        }
        g.drawLine(posX + radio, posY + radio, posX + diametro, posY + diametro);//derecho
        g.drawLine(posX + radio, posY + radio, posX, posY + diametro);//izquierdo

        xf_AristaS = posX + radio;
        yf_AristaS = posY - radio;

        xf_AristaD = posX + diametro;
        yf_AristaD = posY + diametro;

        xf_AristaI = posX;
        yf_AristaI = posY + diametro;

        g.setColor(Color.red);
        g.fillOval(posX, posY, diametro, diametro);//el nodo en si

        posXcentro = posX + radio;
        posYcentro = posY + radio;

        g.setColor(Color.black);
        g.drawString(String.valueOf(clave), posX + radio, posY + radio);

//        g.drawLine(posX + radio, posY + radio, posX + diametro, posY + radio);//en x
//        g.drawLine(posX + radio, posY + radio, posX + radio, posY + diametro);// en y
//        g.drawLine(posX, diametro, posX, diametro);
//        g.drawLine(posX, posY - radio, posX, diametro);
        g.dispose();

    }

}
