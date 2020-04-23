
public class AVLTree<T> {

    private AvlNode root;

    class AvlNode {
        private Object element;
        private AvlNode leftNode;
        private AvlNode rightNode;
        private int height;

        public Object getElement() {
            return element;
        }

        public AvlNode getLeftNode() {
            return leftNode;
        }

        public AvlNode getRightNode() {
            return rightNode;
        }

        public void setElement(Object element) {
            this.element = element;
        }

        public void setLeftNode(AvlNode leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(AvlNode rightNode) {
            this.rightNode = rightNode;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    private int findHeight(AvlNode node) {
        if (node == null)
            return -1;
        return max(findHeight(node.leftNode), findHeight(node.rightNode)) + 1;
    }

    private int max(int a, int b) {
        return a>b?a:b;
    }

    public void printTree() {
        searchTree(root);
    }

    private void searchTree(AvlNode node) {
        if (node == null)
            return;
        searchTree(node.getLeftNode());
        System.out.print(node.getElement().toString() + "  ");
        searchTree(node.getRightNode());

    }

    public void insert(T element) {
        root = insertNode(element, root);
    }

    private AvlNode insertNode(Object element, AvlNode tree) {
        if (tree == null) {
            AvlNode node = new AvlNode();
            node.setElement(element);
            node.setHeight(0);
            return node;
        }
        if (element.hashCode() < tree.getElement().hashCode()) {
            tree.setLeftNode(insertNode(element, tree.getLeftNode()));
            if ((findHeight(tree.getLeftNode()) - findHeight(tree.getRightNode())) == 2) {
                if (element.hashCode() < tree.getLeftNode().getElement().hashCode()) {
                    tree = leftSingleRotate(tree);
                } else if (element.hashCode() > tree.getLeftNode().getElement().hashCode()) {
                    tree = leftDoubleRotate(tree);
                }
            }
        } else if (element.hashCode() > tree.getElement().hashCode()) {
            tree.setRightNode(insertNode(element, tree.getRightNode()));
            if ((findHeight(tree.getRightNode()) - findHeight(tree.getLeftNode())) == 2) {
                if (element.hashCode() < tree.getRightNode().getElement().hashCode()) {
                    tree = rightDoubleRotate(tree);
                } else if (element.hashCode() > tree.getRightNode().getElement().hashCode()) {
                    tree = rightSingleRotate(tree);
                }
            }

        }

        tree.setHeight(findHeight(tree));

        return tree;
    }

    private AvlNode leftSingleRotate(AvlNode node) {
        AvlNode tmp = node.getLeftNode();
        node.setLeftNode(node.getLeftNode().getRightNode());
        tmp.setRightNode(node);
        return tmp;
    }

    private AvlNode rightSingleRotate(AvlNode node) {
        AvlNode tmp = node.getRightNode();
        node.setRightNode(tmp.getLeftNode());
        tmp.setLeftNode(node);
        return tmp;
    }

    private AvlNode leftDoubleRotate(AvlNode node) {
        node.setLeftNode(rightSingleRotate(node.getLeftNode()));
        node = leftSingleRotate(node);
        return node;
    }

    private AvlNode rightDoubleRotate(AvlNode node) {
        node.setRightNode(leftSingleRotate(node.getRightNode()));
        node = rightSingleRotate(node);
        return node;
    }


}
