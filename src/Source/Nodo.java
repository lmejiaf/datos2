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

    int posX, posY;
    int diametro = 50;
    int radio = diametro / 2;

    int clave;
    Nodo derecho;
    Nodo izquierdo;

    public void graficar(JFrame tablero) {
        g = tablero.getGraphics();

        g.setColor(Color.red);
        g.fillOval(posX - radio, posY - radio, diametro, diametro);

        g.setColor(Color.BLACK);
        g.drawLine(posX, posY - radio, posX, diametro);
//
//        g.drawLine(posX, diametro, posX, diametro);
//        g.drawLine(posX, posY - radio, posX, diametro);
        g.dispose();

    }
}
