/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bstree;

/**
 * 
 * BSTree: A program demonstrating an inorder traversal algorithm within a Binary Search Tree.
 * 
 * @author sheehantoufiq
 * 
 * ** Public Classes: **
 * 
 * BSTree Class.
 * Class generates 50 random numbers from 0-99 and inserts them into an array.
 * Each number is printed out. Once the numbers are are generated, a new BSTree
 * is created. Then we must add a node to the BSTree.Node Object for each number
 * i within the array. Here we call the addNode() method which creates a new BSTree.Node
 * object. We pass in a key which is the generated number i within the array as a
 * parameter. 
 * 
 * If the root node is null, we create a new node. Else we set the current node as the
 * root and perform a while loop that sets the parent as the current node. 
 * 
 * If the key is less than the current node's key, we set the current node as the new 
 * parent and the current node as the parent's left child.
 * 
 * If the key is greater than the current node's key, then we the current node as the
 * new parent and the current node as the parent's right child.
 * 
 * After each key is assigned to a node, we pass in the root of the tree into the 
 * inOrder() method with the root of the tree as a parameter. The inOrder() method
 * then traverses the Binary search tree in an inorder recursive algorithm. As each
 * node is recursively searched, the algorithm prints each key in order.
 * 
 * Node Class:
 * The Node Class is an Object that has the property key. There is a setter that 
 * sets the key as the number i in the array.  Once a parent Node is created, a 
 * leftChild and rightChild new node can be created. The return String is a Override
 * method that return the Node's key for the Node Object.
 * 
 * ** Public Methods: **
 * 
 * void numberGenerator()       --> Generates 50 random numbers and adds them to the
 *                                  array numbers.
 * void addNode()               --> Insert a key to a new node. Tests to see if root, 
 *                                  leftChild or rightChild.
 * void inOrder()               --> Recursively traverses the binary search tree with
 *                                  an inorder algorithm.
 * void main()                  --> Calls numberGenerator(), creates a new BSTree, calls
 *                                  addNode(key) for each number i in array numbers,
 *                                  calls, inOrder for the root of BSTree.
 * 
 * ** Algorithms: **
 * 
 * The inorder recursive algorithm:
 * 1. Pass in parameter currentNode into inOrder().
 * 2. If currentNode is null 
 *    then:
 *      3. Pass in parameter currentNode.leftChild into inOrder().
 *      4. Print key for currentNode.
 *      5. Pass in parameter currentNode.rightChild into inOrder().
 * 
 * ** Data Structures: **
 * 
 * Array: {numbers[]}
 * Binary Search Tree: {BSTree}
 * Node Object Constructor: {class Node}
 * 
 * 
 */
public class BSTree {
    
    /*
     * Global variables for array and the a new Node set as root.
     */
    public static int[] numbers = new int[50];
    Node root;
    
    /*
     * Public Node Object Class. Constructs a node with a key. Has the ability to
     * create a new Node leftChild or a new Node rightChild.
     */
    public class Node {
        int key;
        Node leftChild;
        Node rightChild;
        
        /*
         * Node constructer/setter. --> Sets a new node with parameter int key.
         * @param {int} key --> the int for each i in the array numbers
         * @return void
         * Precondition: Must have the array numbers generated. Must have a int parameter.
         * Postcondition: A new node is created with a key equal to numbers[i].
         */
        Node(int key) {
            this.key = key;
        }
        
        /*
         * Override method for Node class
         * @param none
         * @return {String} key --> return toString of int key
         */
        @Override
        public String toString() {
            return Integer.toString(key);
        }
    }
    
    /*
     * AddNode Method --> Adds new node as root, leftChild, or rightChild to tree 
     * based on parameter key.
     * @param {int} key
     * @return void
     * Precondition: Must have the array numbers generated. Must have a int parameter.
     * Postcondition: A node is added as root, leftChild, or rightChild depending on the value of the parameter.
     */
    public void addNode(int key) {
        Node newNode = new Node(key);
        if(root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            Node parent;
            while(true) {
                parent = currentNode;
                if (key < currentNode.key) {
                    currentNode = currentNode.leftChild;
                    if(currentNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    currentNode = currentNode.rightChild;
                    if(currentNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    /*
     * inOrder Method --> Recursive function that uses a inOrder traveral algorithm to put
     * the key in each Node for BSTree in order.
     * them to the array numbers.
     * @param {Node} currentNode
     * @return void
     * Precondition: Must have a BSTree built with all keys in numbers added as nodes.
     * Postcondition: Recursively calls itself until there are no more keys to put in order
     * 0-99. Numbers are printed on screen on each recursive iteration, resulting in the set
     * of keys put in order.
     */
    public void inOrder(Node currentNode) {
        if(currentNode != null) {
            inOrder(currentNode.leftChild);
            System.out.print(currentNode + ", ");
            inOrder(currentNode.rightChild);
        }
    }
    /*
     * NumberGenerator Method --> Generates 50 randoms numbers ranging from 0-99 and adds 
     * them to the array numbers.
     * @param none
     * @return void
     * Precondition: Must have an array named numbers[] initialized.
     * Postcondition: Array is filled with numbers equal to numbers.length (50) ranging from 
     * 0-99. Numbers are printed on screen.
     */
    public static void numberGenerator() {
        System.out.println("Generating 50 random numbers 0-99...");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 99) + 1;
            System.out.print(numbers[i] + ", ");
        }
        System.out.println("\n");
    }
    
    /*
     * Main Method --> Calls numberGenerator(), builds BSTree, addNode for BSTree for each key.
     * Prints keys array. Calls inOrder().
     * them to the array numbers.
     * @param {String[]} args
     * @return void
     * Precondition: Must have an array named numbers[] initialized.
     * Postcondition: Array is filled with numbers equal to numbers.length (50) ranging from 
     * 0-99. Calls addNode() to BSTree for each i in numbers[]. Calls inOrder() method to
     * traverse tree recursively and prints out the key in each Node in order.
     * 
     */
    public static void main(String[] args) {
        
        numberGenerator();
        BSTree tree = new BSTree();
        
        for (int i = 0; i < numbers.length; i++) {
            tree.addNode(numbers[i]);
        }
        
        System.out.println("Traversing binary search tree by inorder recursion...");
        tree.inOrder(tree.root);
        System.out.print("\n");
        
    }
}
