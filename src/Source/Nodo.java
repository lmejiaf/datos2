/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author luis
 */
public class Nodo {

    //graficas del nodo
    private Graphics g;
    private int posX;
    private int posY;
    private int width = 50;
    private int height = 30;

    //cosas del nodo en si
    private int clave;
    private Nodo derecho;
    private Nodo izquierdo;

    //metodos propios del nodo
    public void graficar() {

        //el nodo
        g.setColor(Color.blue);
        g.fillRect(posX, posY, width, height);
        g.setColor(Color.black);
        g.drawRect(posX, posY, width, height);
        g.drawString(String.valueOf(clave), posX + width / 3, posY + height / 2);

        //aristas del nodo
        g.drawLine(posX + width / 2, posY + height, posX + width / 2, posY + 2 * height);//hacia abajo 
        g.drawLine(posX + width / 2, posY + 2 * height, posX + width / 2 + width, posY + 2 * height);//hacia la derecha
        g.drawLine(posX + width / 2, posY + 2 * height, posX + width / 2 - width, posY + 2 * height);//hacia la izquierda
        g.drawLine(posX + width / 2 - width, posY + 2 * height, posX + width / 2 - width, posY + 3 * height);//para hijo izquierdo
        g.drawLine(posX + width / 2 + width, posY + 2 * height, posX + width / 2 + width, posY + 3 * height);//para hijo derecho
        g.dispose();
    }

    public void regraficar() {
        g.translate(posX+10, posY+40);
    }

    public int[] getPosHijoDerecho() {

        int coordenadas[] = new int[2];
        coordenadas[0] = posX + width / 2 + width;
        coordenadas[1] = posY + 3 * height;

        return coordenadas;
    }

    public int[] getPosHijoIzquierdo() {
        int coordenadas[] = new int[2];
        coordenadas[0] = posX + width / 2 - width;
        coordenadas[1] = posY + 3 * height;

        return coordenadas;
    }

    //getters and setters and constructor(lienzo, dato)
    public Nodo(JPanel lienzo, int clave) {

        this.clave = clave;
        g = lienzo.getGraphics();
        posY = 0;
        posX = lienzo.getWidth() / 2;

    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public Graphics getG() {
        return g;
    }

    public void setG(Graphics g) {
        this.g = g;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

}
