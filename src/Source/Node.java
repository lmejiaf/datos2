package Source;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author luis
 */
public class Node {

    String name;

    Node leftChild;
    Node rightChild;

    public Node(String name) {
        this.name = name;
    }

    JPanel lienzo;
    Graphics g;
    int factorExpansion = 1;
    final int width = 50;
    final int height = 30;
    int posX;
    int posY;
    
    
    public void fixCoordenadasRoot(JPanel lienzo) {
        posX = lienzo.getWidth() / 2 - width / 2;
        posY = 0;
        g = lienzo.getGraphics();
    }

    public void fixCoordenadas(JPanel lienzo) {
        g = lienzo.getGraphics();
    }

    public void paint() {

        //el nodo
        g.setColor(Color.BLUE);
        g.fillRect(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(posX, posY, width, height);
        g.drawString(name, posX + width / 4, posY + height / 3);
        //aristas
        g.setColor(Color.BLACK);
        //arista  hacia abajo
        g.drawLine(posX + width / 2, posY + height, posX + width / 2, posY + 2 * height);
        //arista para hijo derecho
        g.drawLine(posX + width / 2, posY + 2 * height, posX + width / 2 + width * factorExpansion, posY + 2 * height);
        //arista para hijo izquierdo
        g.drawLine(posX + width / 2, posY + 2 * height, posX + width / 2 - width * factorExpansion, posY + 2 * height);
    }

    public void locateChilds() {
        if (leftChild != null) {
            leftChild.posX = (posX - width / 2) - width * factorExpansion;
            leftChild.posY = posY + 2 * height;
        }
        if (rightChild != null) {
            rightChild.posX = (posX + width / 2) + width * factorExpansion;
            rightChild.posY = posY + 2 * height;
        }
    }

    public void selectedAnimation() {
        g.setColor(Color.YELLOW);
        g.fillRect(posX, posY, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(posX, posY, width, height);
        g.drawString(name, posX + width / 4, posY + height / 3);
    }

}
