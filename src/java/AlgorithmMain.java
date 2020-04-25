public class AlgorithmMain {

    public static void main(String[] args) {
        SplayTree<Integer> tree = new SplayTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        System.out.println(tree.find(5));
    }

}
