public class SplayTree<T> {

    private SplayNode root;

    public void insert(T target) {
        root = insertNode(root, target);
    }

    private SplayNode insertNode(SplayNode node, Object target) {
        if (node == null) {
            node = new SplayNode();
            node.element = target;
            return node;
        } else if (node.element.hashCode() == target.hashCode()) {
            return node;
        } else if (node.element.hashCode() > target.hashCode()) {
            node.left = insertNode(node.left, target);
        } else if (node.element.hashCode() < target.hashCode()) {
            node.right = insertNode(node.right, target);
        }
        return node;
    }

    public T find(T target) {
        root = findNode(root, target);
        if (root != null && root.element.hashCode() == target.hashCode()) {
            return target;
        }
        return null;
    }

    private SplayNode findNode(SplayNode node, Object target) {
        if (node == null)
            return null;
        if (node.element.hashCode() > target.hashCode()) {
            node.left = findNode(node.left, target);
            if (node.left != null && node.left.left != null && node.left.left.element.hashCode() == target.hashCode()) {
                node = leftStrightRotate(node);
            } else if (node.left != null && node.left.right != null && node.left.right.element.hashCode() == target.hashCode()) {
                node = leftZigRotate(node);
            }
        } else if (node.element.hashCode() < target.hashCode()) {
            node.right = findNode(node.right, target);
            if (node.right != null && node.right.right != null && node.right.right.element.hashCode() == target.hashCode()) {
                node = rightStrightRotate(node);
            } else if (node.right != null && node.right.left != null && node.right.left.element.hashCode() == target.hashCode()) {
                node = rightZigRotate(node);
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
        SplayNode tmpLeft = node.left;
        SplayNode tmp = tmpLeft.left;
        node.left = tmpLeft.right;
        tmpLeft.right = node;
        tmpLeft.left = tmp.right;
        tmp.right = tmpLeft;
        return tmp;
    }

    private SplayNode rightStrightRotate(SplayNode node) {
        SplayNode tmpRight = node.right;
        SplayNode tmp = tmpRight.right;
        node.right = tmpRight.left;
        tmpRight.left = node;
        tmpRight.right = tmp.left;
        tmp.left = tmpRight;
        return tmp;
    }

    private SplayNode leftZigRotate(SplayNode node) {
        SplayNode tmpLeft = node.left;
        SplayNode tmp = tmpLeft.right;
        tmpLeft.right = tmp.left;
        tmp.left = tmpLeft;
        node.left = tmp.right;
        tmp.right = node;
        return tmp;
    }

    private SplayNode rightZigRotate(SplayNode node) {
        SplayNode tmpRight = node.right;
        SplayNode tmp = tmpRight.left;
        tmpRight.left = tmp.right;
        tmp.right = tmpRight;
        node.right = tmp.left;
        tmp.left = node;
        return tmp;
    }

}
