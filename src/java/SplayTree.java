public class SplayTree<T> {

    private SplayNode root;


    public T find(T target) {

    }

    public SplayNode findNode(SplayNode node, Object target) {
        if (node == null)
            return null;
        if (node.element.hashCode() > target.hashCode()) {
            node.left = findNode(node.left, target);
            if (node.left != null && node.left.left != null && node.left.left.element.hashCode() == target.hashCode()) {
                //
            } else if (node.left != null && node.left.right != null && node.left.right.element.hashCode() == target.hashCode()) {

            }
        } else if (node.element.hashCode() < target.hashCode()) {
            node.right = findNode(node.right, target);
            if (node.right != null && node.right.right != null && node.right.right.element.hashCode() == target.hashCode()) {
                //
            } else if (node.right != null && node.right.left != null && node.right.left.element.hashCode() == target.hashCode()) {
                //
            }
        }
        if (node == root) {
            if (root.left.element.hashCode() == target.hashCode()) {
                SplayNode tmp = root.left;
                root.left = tmp.right;
                tmp.right = root;
                root = tmp;
            } else if (node.right.element.hashCode() == target.hashCode()) {
                SplayNode tmp = root.right;
                root.right = tmp.left;
                tmp.left = root;
                root = tmp;
            }
        }
        return node;
    }


    class SplayNode {
        private Object element;
        private SplayNode left;
        private SplayNode right;

    }

    private SplayNode leftStrightRotate(SplayNode node) {

    }

    private SplayNode rightStrightRotate(SplayNode node) {

    }

    private SplayNode leftZigRotate(SplayNode node) {

    }

    private SplayNode rightZigRotate(SplayNode node) {

    }

}
