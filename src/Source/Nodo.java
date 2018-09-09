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
    private final int width = 50;
    private final int height = 30;
    private int factorExpansion = 1;

    //cosas del nodo en si
    private final String nombre;
    private Nodo derecho;
    private Nodo izquierdo;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    //metodos propios del nodo
    public void graficar() {
        //el nodo
        g.setColor(Color.WHITE);
        g.fillRect(posX, posY, width, height);
        g.setColor(Color.black);
        g.drawRect(posX, posY, width, height);
        g.drawString(nombre, posX + width / 3, posY + height / 2);
        
        
        
        
        
        
//        //aristas del nodo
//        g.drawLine(posX + width / 2, posY + height, posX + width / 2, posY + 2 * height);//hacia abajo 
//        g.drawLine(posX + width / 2, posY + 2 * height, posX + width / 2 + width * factorExpansion, posY + 2 * height);//hacia la derecha
//        g.drawLine(posX + width / 2, posY + 2 * height, posX + width / 2 - width * factorExpansion, posY + 2 * height);//hacia la izquierda
////        g.drawLine(posX + width / 2 - width * factorExpansion, posY + 2 * height, posX + width / 2 - width * factorExpansion, posY + 3 * height);//para hijo izquierdo
////        g.drawLine(posX + width / 2 + width * factorExpansion, posY + 2 * height, posX + width / 2 + width * factorExpansion, posY + 3 * height);//para hijo derecho
    }
    //metodos inventados por mi

    public void cambiarFactorExpansion(int altura, int nivel) {
        factorExpansion = (int) (Math.pow(2, (altura - nivel)));
    }

    public void asignarPosHijos() {

        if (derecho != null) {
            derecho.setPosX(posX + width / 2 + width * factorExpansion - width / 2);
            derecho.setPosY(posY + 3 * height);
            //derecho.graficar();
        }
        if (izquierdo != null) {
            izquierdo.setPosX(posX + width / 2 - width * factorExpansion - width / 2);
            izquierdo.setPosY(posY + 3 * height);
            //izquierdo.graficar();
        }
    }

    public void desiluminar() {
        g.setColor(Color.WHITE);
        g.fillRect(posX, posY, width, height);
        g.setColor(Color.black);
        g.drawRect(posX, posY, width, height);
        g.drawString(nombre, posX + width / 3, posY + height / 2);
    }

    public void iluminar() {
        g.setColor(Color.YELLOW);
        g.fillRect(posX, posY, width, height);
        g.setColor(Color.black);
        g.drawRect(posX, posY, width, height);
        g.drawString(nombre, posX + width / 3, posY + height / 2);

    }

    public void iluminar2() {
        g.setColor(Color.BLUE);
        g.fillRect(posX, posY, width, height);
        g.setColor(Color.black);
        g.drawRect(posX, posY, width, height);
        g.drawString(nombre, posX + width / 4, posY + height / 2);

    }
//    public void recalcular(int altura, int nivel) {
////        g.clearRect(posX + width / 2 - width * factorExpansion, posY, (posX + width / 2 + width * factorExpansion) - (posX + width / 2 - width * factorExpansion), posY + 3 * height);
//        cambiarFactorExpansion(altura, nivel);
//        asignarPosHijos();juan
////        graficar();
//
//    }
    //gets, sets, y constructor

    public Nodo(JPanel lienzo, String nombre) {

        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

}
