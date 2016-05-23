import java.util.List;

/**
 * Created by saim on 23/05/16.
 */
public class BinaryTree {
    Node root;

    public void insert(int i) {
        //Baum ist leer?
        if(root == null){
            root = new Node(i);
        } else {
            insert(root, i);
        }
    }

    private void insert(Node current, int i) {
        // Ist 'i' < Wert in current, dann füge links
        if(i < current.key){
            if (current.left == null){
                current.left = new Node(i);
            } else {
                insert(current.left, i);
            }
        }
        // Ist 'i' > Wert in current, dann füge rechts
        if(i > current.key){
            if (current.right == null){
                current.right = new Node(i);
            } else {
                insert(current.right, i);
            }
        }

    }

    public void print() {
        if (root != null){
            print(root);
        }
    }

    //pre-Order :: W-l-r
    //post-Order:: L-r-W
    //in-Order  :: l-W-r

    private void print(Node current) {

//        if (current.key == null) return;
//        System.out.println(current.key);
//        print(current.left);
//        print(current.right);
        if (current.left != null)
            print(current.left);
        System.out.println(current.key);
        if (current.right != null)
            print(current.right);
    }

    public List<Integer> asSortedList(){
        return null;
    }

    public boolean contains(int value){
        return false;
    }

    public List<Integer> elementsSmallerThan(int value){
        return null;
    }
}
