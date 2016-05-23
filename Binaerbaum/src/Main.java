/**
 * Created by saim on 23/05/16.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.insert(32);
        bTree.insert(20);
        bTree.insert(60);
        bTree.insert(10);
        bTree.insert(0);
        bTree.insert(100);
        bTree.insert(-1);
        bTree.insert(15);
        bTree.print();
    }
}
