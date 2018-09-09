/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author luis
 */
public class Tree {

    Node rootTree;
    int height = 0;
    int factorAnchura = 1;

    public void add(Node parent, Node child) {
        if (isEmpty()) {
            initializeTree(parent);
        } else {
            if (parent.rightChild == null) {
                parent.rightChild = child;
            } else if (parent.leftChild == null) {
                parent.leftChild = child;
            }
        }
        if (getHeight(rootTree) != height) {
            height = getHeight(rootTree);
        }
    }

    public void remove(Node toDelete) {
        Queue<Node> cola = new LinkedList();
        if (rootTree != null) {
            cola.add(rootTree);
            Node n;
            while (!cola.isEmpty()) {

                n = cola.poll();
                //accion con n
                if (n.leftChild == toDelete) {
                    toDelete = null;
                    n.leftChild = null;
                } else if (n.rightChild == toDelete) {
                    toDelete = null;
                    n.rightChild = null;
                }

                //fin accion con n
                if (n.leftChild != null) {

                    cola.add(n.leftChild);
                }
                if (n.rightChild != null) {

                    cola.add(n.rightChild);
                }

            }
        } else if (toDelete == rootTree) {
            rootTree = null;
        }

    }

    public int getHeight(Node root) {
        return (root == null) ? -1 : (1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild)));
    }

    public void preOrder(Node root) {
        if (root != null) {
            //accion con rootTree
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.leftChild);
            //accion con rootTree
            inOrder(root.rightChild);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            //accion con rootTree

        }
    }

    public void forLevels(Node root) {
        Queue<Node> cola = new LinkedList();
        cola.add(root);
        if (root != null) {
            Node n;
            while (!cola.isEmpty()) {

                n = cola.poll();
                //accion con n
                System.out.println(n.name);
                //fin accion con n
                if (n.leftChild != null) {

                    cola.add(n.leftChild);
                }
                if (n.rightChild != null) {

                    cola.add(n.rightChild);
                }

            }
        }
    }

    // mis metodos
    public void initializeTree(Node root) {
        this.rootTree = root;
    }

    public boolean isEmpty() {
        return rootTree == null;
    }

    public LinkedList searchNodes(String nombre) {

        LinkedList<Node> nodes = new LinkedList();
        if (rootTree != null) {
            Queue<Node> cola = new LinkedList();
            cola.add(rootTree);
            Node n;
            while (!cola.isEmpty()) {
                n = cola.poll();
                //accion con n  
                if (n.name.equalsIgnoreCase(nombre)) {
                    nodes.add(n);
                }
                //fin accion con n
                if (n.leftChild != null) {
                    cola.add(n.leftChild);
                }
                if (n.rightChild != null) {
                    cola.add(n.rightChild);
                }
            }
        }
        return nodes;
    }

    public DefaultListModel<Node> getMatchModel(String nombre) {
        LinkedList<Node> matches = searchNodes(nombre);

        DefaultListModel<Node> matchesModel = new DefaultListModel();

        matches.forEach((match) -> {
            if (match.leftChild == null || match.rightChild == null) {
                matchesModel.addElement(match);
            }
        });

        return matchesModel;
    }

    public void paintForLevels(Node root, JPanel canvas) {

        Queue<Node> cola = new LinkedList();
        cola.add(root);
        if (root != null) {
            canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            Node n;
            int altura = getHeight(this.rootTree);
            int nivel = 0;
            if (altura % 4 == 0 && altura != 0 && height != altura) {
                factorAnchura++;
            }
            rootTree.factorExpansion = altura + factorAnchura;
            while (!cola.isEmpty()) {

                n = cola.poll();
                //accion con n
                if (rootTree == n) {
                    n.fixCoordenadasRoot(canvas);
                } else {
                    n.fixCoordenadas(canvas);
                }
                n.paint();
                n.locateChilds();
                System.out.println(altura);
                //fin accion con n
                if (n.leftChild != null) {
                    nivel++;
                    if (altura % 2 == 0 && altura != 0) {
                        n.leftChild.factorExpansion = n.factorExpansion - 1;
                    }
                    cola.add(n.leftChild);
                }
                if (n.rightChild != null) {
                    nivel++;
                    if (altura % 2 == 0 && altura != 0) {
                        n.rightChild.factorExpansion = n.factorExpansion - 1;
                    }
                    cola.add(n.rightChild);
                }

            }
        }
    }

    public void paint(JPanel canvas) {
        if (rootTree != null) {
            paintForLevels(rootTree, canvas);
        }
    }

    public Node searchNodeByPosition(int posX, int posY) {
        Queue<Node> cola = new LinkedList();
        cola.add(rootTree);
        if (rootTree != null) {
            Node n;
            while (!cola.isEmpty()) {

                n = cola.poll();
                //accion con n
                if (posX >= n.posX && posX <= n.posX + n.width && posY >= n.posY && posY <= n.posY + n.height) {

                    return n;

                }
                //fin accion con n
                if (n.leftChild != null) {

                    cola.add(n.leftChild);
                }
                if (n.rightChild != null) {

                    cola.add(n.rightChild);
                }

            }
        }
        return null;
    }

    public Node searchPartner(Node x) {
        if (rootTree.leftChild == x || rootTree.rightChild == x) {

            return rootTree;

        } else {
            Queue<Node> cola = new LinkedList();
            cola.add(rootTree);
            if (rootTree != null) {
                Node n;
                while (!cola.isEmpty()) {

                    n = cola.poll();
                    //accion con n
                    if (n.leftChild == x || n.rightChild == x) {

                        return n;

                    }
                    //fin accion con n
                    if (n.leftChild != null) {

                        cola.add(n.leftChild);
                    }
                    if (n.rightChild != null) {

                        cola.add(n.rightChild);
                    }

                }
            }
        }
        return null;
    }

    public Node searchBrother(Node x) {
        if (x != null) {
            Node padre = searchPartner(x);
            if (rootTree == x) {
                return rootTree;
            } else {
                if (padre.leftChild != x) {
                    return padre.leftChild;
                } else {
                    return padre.rightChild;
                }
            }
        } else {
            return null;
        }

    }

    public LinkedList<Node> searchChilds(Node x) {
        if (x != null) {

            LinkedList<Node> childs = new LinkedList();

            if (x.leftChild != null) {
                childs.add(x.leftChild);
            }
            if (x.rightChild != null) {
                childs.add(x.rightChild);
            }
            return childs;
        } else {
            return null;
        }
    }

    

}
