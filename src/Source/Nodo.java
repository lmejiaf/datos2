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
    private int factorExpansion = 1;

    //cosas del nodo en si
    private final int clave;
    private Nodo derecho;
    private Nodo izquierdo;

    public Nodo(int clave) {
        this.clave = clave;
    }

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
        g.drawLine(posX + width / 2, posY + 2 * height, posX + width / 2 + width * factorExpansion, posY + 2 * height);//hacia la derecha
        g.drawLine(posX + width / 2, posY + 2 * height, posX + width / 2 - width * factorExpansion, posY + 2 * height);//hacia la izquierda
        g.drawLine(posX + width / 2 - width * factorExpansion, posY + 2 * height, posX + width / 2 - width * factorExpansion, posY + 3 * height);//para hijo izquierdo
        g.drawLine(posX + width / 2 + width * factorExpansion, posY + 2 * height, posX + width / 2 + width * factorExpansion, posY + 3 * height);//para hijo derecho
    }

    //metodos inventados
    public void PonerHijoDerecho() {
        int[] coordenadas = new int[2];
        coordenadas[0] = posX + width * factorExpansion;
        coordenadas[1] = posY + 3 * height;

        if (derecho != null) {

            derecho.setPosX(coordenadas[0]);
            derecho.setPosY(coordenadas[1]);
        }
    }

    public void PonerHijoIzquierdo() {
        int[] coordenadas = new int[2];
        coordenadas[0] = posX - width * factorExpansion + width ;
        coordenadas[1] = posY + 3 * height;

        if (izquierdo != null) {

            izquierdo.setPosX(coordenadas[0]);
            izquierdo.setPosY(coordenadas[1]);
        }
    }

    public void ponerHijos() {
        PonerHijoIzquierdo();
        PonerHijoDerecho();
    }

//2 a la (altura-nivel)
    public void aumentoFactor(int altura, int nivel) {
        factorExpansion = (int) (Math.pow(2, altura - nivel));
    }

    //gets, sets, y constructor
    public Nodo(JPanel lienzo, int clave) {

        this.clave = clave;
        g = lienzo.getGraphics();
        posY = 0;
        posX = lienzo.getWidth() / 2 - width / 2;
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

    public int getFactorExpansion() {
        return factorExpansion;
    }

    public void setFactorExpansion(int factorExpansion) {
        this.factorExpansion = factorExpansion;
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

    public int getClave() {
        return clave;
    }

}
