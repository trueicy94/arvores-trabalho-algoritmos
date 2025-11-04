package arvoreBinaria;

import java.util.List;

/**
 * Classe de arvore binaria de numeros inteiros.
 */

public class BinaryTreeOfString {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        private String element;

        public Node(String element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    // Atributos
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    // Metodos
    public BinaryTreeOfString() {
        count = 0;
        root = null;
    }

    /**
     * Remove todos os elementos da arvore.
     */
    public void clear() {
        count = 0;
        root = null;
    }

    /**
     * Verifica se a arvore esta vazia ou nao.
     *
     * @return true se arvore vazia e false caso contrario.
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Retorna o total de elementos da arvore.
     *
     * @return total de elementos
     */
    public int size() {
        return count;
    }

    /**
     * Retorna o elemento armazenado na raiz da arvore.
     *
     * @throws EmptyTreeException se arvore vazia.
     * @return elemento da raiz.
     */
    public String getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }
    // Metodo privado que procura por element a partir de target
    // e retorna a referencia para o nodo no qual element esta
    // armazenado. Retorna null se nao encontrar element.
    private Node searchNodeRef(String element, Node target) {
        if ( target == null)
            return null;
        // Visita a "raiz"
        if (element.equals(target.element))
            return target; // se achou element na "raiz"

        // Visita subarvore da esquerda
        Node aux = searchNodeRef(element, target.left);

        // Se nao encontrou, visita a subarvore da direita
        if (aux == null)
            aux = searchNodeRef(element, target.right);

        return aux;
    }

    /**
     * Verifica se element esta ou nao armazenado na arvore.
     *
     * @param element
     * @return true se element estiver na arvore, false caso contrario.
     */
    public boolean contains(String element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    /**
     * Retorna quem e o elemento pai do elemento passado por parametro.
     *
     * @param element
     * @return pai de element
     */
    public String getParent(String element) {
        Node n = this.searchNodeRef(element, root);
        if (n == null) {
            return null;
        } else if (n.father==null) {
            return null;
        }else {
            return n.father.element;
        }
    }

    /**
     * Altera o elemento da raiz da arvore.
     *
     * @param element a ser colocado na raiz da arvore.
     */
    public void setRoot(String element) {
        if (root != null){
            root.element = element;
        }
    }

    /**
     * Insere o elemento como raiz da arvore, se a arvore estiver vazia.
     * @param element a ser inserido.
     * @return true se for feita a insercao, e false caso a arvore nao estiver
     * vazia e a insercao não for feita.
     */
    public boolean addRoot(String element) {
        if (root != null) // se a arvore nao estiver vazia
            return false;
        root = new Node(element);
        count++;
        return true;
    }

    /**
     * Insere element a esquerda de elemFather. Se nao encontrar father,
     * ou se father ja tiver um filho a esquerda, element nao e´
     * inserido.
     *
     * @param element a ser inserido
     * @param elemFather pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addLeft(String element, String elemFather) {
        // Primeiro procura por elemFather
        Node aux = searchNodeRef(elemFather,root);

        // Se nao encontrou elemFather
        if (aux == null)
            return false;
        // Se elemFather ja tem filho a esquerda
        if (aux.left != null)
            return false;

        // Senao, insere element
        Node n = new Node(element); // primeiro cria o nodo
        n.father = aux; // faz o novo nodo apontar para o pai
        aux.left = n;// faz o pai apontar para o filho
        count++; // atualiza count
        return true;
    }

    /**
     * Insere element a direita de elemFather. Se nao encontrar father,
     * ou se father ja tiver um filho a direita, element nao e´
     * inserido.
     *
     * @param element a ser inserido
     * @param elemFather pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addRight(String element, String elemFather) {
        // Primeiro procura por elemFather
        Node aux = searchNodeRef(elemFather,root);

        // Se nao encontrou elemFather
        if (aux == null)
            return false;
        // Se elemFather ja tem filho a direita
        if (aux.right != null)
            return false;

        // Senao, insere element
        Node n = new Node(element); // primeiro cria o nodo
        n.father = aux; // faz o novo nodo apontar para o pai
        aux.right = n;// faz o pai apontar para o filho
        count++; // atualiza count
        return true;
    }

    // Conta o numero de nodos a partir de "n"
    private int countNodes(Node n) {
        if (n==null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

// ---------------------------------------------------------------------
    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento pre-fixado.
     *
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfString positionsPre() {
        LinkedListOfString lista = new LinkedListOfString();
        positionsPreAux(root, lista);
        return lista;
    }

    private void positionsPreAux(Node n, LinkedListOfString lista) {
        if (n != null) {
            lista.add(n.element); // visita raiz
            positionsPreAux(n.left,lista); // percorre subarvore da esq
            positionsPreAux(n.right,lista); // percorre subarvore da dir
        }
    }

    public LinkedListOfString positionsPost() {
        LinkedListOfString lista = new LinkedListOfString();
        positionsPostAux(root, lista);
        return lista;
    }

    private void positionsPostAux(Node n, LinkedListOfString lista) {
        if (n != null) {
            positionsPostAux(n.left, lista);
            positionsPostAux(n.right, lista);
            lista.add(n.element);
        }
    }

    public LinkedListOfString positionsLevel() {
        LinkedListOfString lista = new LinkedListOfString();
        if (root == null) return lista;

        // Fila manual (array simples)
        Node[] fila = new Node[count]; // count é o total de nós
        int front = 0;
        int rear = 0;

        fila[rear++] = root;

        while (front < rear) {
            Node n = fila[front++];
            lista.add(n.element);

            if (n.left != null) fila[rear++] = n.left;
            if (n.right != null) fila[rear++] = n.right;
        }

        return lista;
    }

    private Node addLeft(Node father, String element) {
        if (father.left != null) return null;
        Node n = new Node(element);
        n.father = father;
        father.left = n;
        count++;
        return n;
    }

    private Node addRight(Node father, String element) {
        if (father.right != null) return null;
        Node n = new Node(element);
        n.father = father;
        father.right = n;
        count++;
        return n;
    }

    public int height() {
        return height(root);
    }

    private int height(Node n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.left), height(n.right));
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node n) {
        if (n == null) return 0;
        if (n.isLeaf()) return 1;
        return countLeaves(n.left) + countLeaves(n.right);
    }

    public int countInternalNodes() {
        return countInternalNodes(root);
    }

    private int countInternalNodes(Node n) {
        if (n == null || n.isLeaf()) return 0;
        return 1 + countInternalNodes(n.left) + countInternalNodes(n.right);
    }

    // -------------------------CONSTRUÇÃO DO TORNEIO----------------------

    public void buildTournament(String[] players) {
        if (players.length < 8 || players.length > 32 || (players.length & (players.length - 1)) != 0) {
            throw new IllegalArgumentException("Número de jogadores deve ser 8, 16 ou 32.");
        }

        clear();
        addRoot(null); // raiz vazia
        buildTournamentAux(root, players, 0, players.length - 1);
    }

    private void buildTournamentAux(Node node, String[] players, int start, int end) {
        if (start == end) {
            node.element = players[start]; // folha recebe jogador
        } else {
            int mid = (start + end) / 2;

            Node left = addLeft(node, null);
            buildTournamentAux(left, players, start, mid);

            Node right = addRight(node, null);
            buildTournamentAux(right, players, mid + 1, end);
        }
    }


    // ---------------- REGISTRAR VENCEDOR ----------------
    public void registerMatchWinner(String winner, String loser) {
        Node lca = lcaOfPlayers(winner, loser);
        if (lca != null) {
            lca.element = winner;
        }
    }

    // ---------------- CAMINHO ATÉ A FINAL ----------------
    public LinkedListOfString pathToFinal(String player) {
        LinkedListOfString path = new LinkedListOfString();
        Node leaf = searchNodeRef(player, root);

        if (leaf == null) {
            path.add("Jogador não encontrado.");
            return path;
        }

        Node cur = leaf.father;
        while (cur != null) {
            if (cur.element == null) {
                path.add("Partida ainda não decidida");
            } else {
                path.add("Partida vencida por: " + cur.element);
            }

            // Se o jogador foi eliminado
            if (cur.element != null && !cur.element.equals(player)) {
                path.add("Eliminado aqui.");
                break;
            }

            cur = cur.father;
        }

        return path;
    }


    // ---------------- LCA (primeira partida possível) ----------------
    public String lcaMatchLabel(String p1, String p2) {
        Node lca = lcaOfPlayers(p1, p2);
        if (lca == null) return null;
        return "Partida entre " + p1 + " e " + p2;
    }

    private Node lcaOfPlayers(String p1, String p2) {
        Node a = searchNodeRef(p1, root);
        Node b = searchNodeRef(p2, root);
        if (a == null || b == null) return null;

        int da = depth(a);
        int db = depth(b);

        while (da > db) { a = a.father; da--; }
        while (db > da) { b = b.father; db--; }

        while (a != b) {
            a = a.father;
            b = b.father;
        }
        return a;
    }

    private int depth(Node n) {
        int d = 0;
        while (n != null) {
            d++;
            n = n.father;
        }
        return d;
    }

}
