class node<T> {
    T data;
    node<T> left;
    node<T> right;

    node(T d) {
        data = d;
    }

    public String toString() {
        return data.toString();
    }
}

public class BST<T extends Comparable<T>> {
    node<T> root;

    public void insert(T key) {
        node<T> n = new node<T>(key);
        if (root == null) {
            root = n;
            return;
        }
        node<T> prev = root, temp = root;
        while (temp != null) {
            prev = temp;
            if (temp.data.compareTo(key) > 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (prev.data.compareTo(key) > 0) {
            prev.left = n;
        } else {
            prev.right = n;
        }
    }

    public void LNR(node n) {
        if (n == null)
            return;
        LNR(n.left);
        System.out.println(n);
        LNR(n.right);
    }

    public void LRN(node n) {
        if (n == null)
            return;
        LRN(n.left);
        LRN(n.right);
        System.out.println(n);
    }

    int maxDepth(node n) {
        if (n == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(n.left);
            int rDepth = maxDepth(n.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    public void NLR(node n) {
        if (n == null)
            return;
        System.out.println(n);
        NLR(n.left);
        NLR(n.right);
    }

    public node<T> find(T key) {
        node<T> temp = root;

        while (temp != null && temp.data.compareTo(key) != 0) {
            if (temp.data.compareTo(key) > 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return temp;
    }

    public node[] findPT(T key) {
        node<T> temp = root;
        node<T> prev = root;

        while (temp != null && temp.data.compareTo(key) != 0) {
            prev = temp;
            if (temp.data.compareTo(key) > 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        if (temp == null)
            return null;
        return new node[] { temp, prev };
    }

    public node Minimum() {
        node temp = root;
        if (temp == null)
            return null;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public node Maximum() {
        node temp = root;
        if (temp == null)
            return null;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public void deleteNochild(node<T> t, node<T> p) {
        if (t == root) {
            root = null;
            return;
        }
        if (p.left != null) {
            if (t.data.compareTo(p.left.data) == 0)
                p.left = null;
            else
                p.right = null;
        } else
            p.right = null;
        System.out.println("2 child");
    }

    public void deleteOnechild(node<T> t, node<T> p) {

        node temp = t;
        if (t == root) {
            if (t.left == null)
                root = t.right;
            else
                root = t.left;
            return;
        }
        if (t.left == null)
            temp = t.right;
        else
            temp = t.left;
        if (p.left != null) {
            if (t.data.compareTo(p.left.data) == 0)
                p.left = temp;
            else
                p.right = temp;
        } else
            p.right = temp;
    }

    public node maxNode(node n) {
        if (n.right == null)
            return n;
        return maxNode(n.right);
    }

    public node minNode(node n) {
        if (n.left == null)
            return n;
        return minNode(n.left);
    }

    public void Delete(T key) {
        node<T>[] nodes = findPT(key); // find node to delete that return node t and its parent p references
        if (nodes == null) {
            System.out.println("item doesn't exist");
            return;
        }
        node temp = nodes[0];
        node prev = nodes[1];
        if (temp.left == null && temp.right == null) {
            deleteNochild(temp, prev);
        } else if (temp.left == null || temp.right == null) { // call deleteOnechild(t,p)
            deleteOnechild(temp, prev);
        } else {
            System.out.println("delete 2");
            node<T> min = minNode(temp.right);
            nodes = findPT(min.data);
            prev = nodes[1];
            if (min.left == null && min.right == null) {
                deleteNochild(min, prev);
            } else
                deleteOnechild(min, prev);
            temp.data = min.data;
        }

    }

    public void PrintRange(node<Integer> r, int k1, int k2) { // Function for Task 1
        if (r == null)
            return;
        PrintRange(r.left, k1, k2);
        if (r.data <= k2 && r.data >= k1)
            System.out.println(r);
        PrintRange(r.right, k1, k2);
    }

}

class BST_TEST_MAIN {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();

        bst.insert(12);
        bst.insert(10);
        bst.insert(100);
        bst.insert(14);
        bst.insert(16);
        bst.insert(12);
        bst.insert(15);
        bst.insert(1000);

        bst.PrintRange(bst.root, 12, 15);
        System.out.println("******************");
        bst.LNR(bst.root);
    }
}
