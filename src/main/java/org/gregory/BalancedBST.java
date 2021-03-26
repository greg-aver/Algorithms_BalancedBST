package org.gregory;

import java.util.Arrays;

class BalancedBST {
    public BSTNode Root; // корень дерева

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        Arrays.sort(a);
        setRoot(createBST(a, 0, a.length - 1, null, 1));
    }

    private BSTNode createBST(int[] a, int indexBegin, int indexEnd, BSTNode parent, int level) {
        int indexCentralElement = indexBegin + (indexEnd - indexBegin) / 2;
        BSTNode node = new BSTNode(a[indexCentralElement], parent, level);
        if (indexBegin == indexEnd) {
            return node;
        }
        node.setLeftChild(createBST(a, indexBegin, indexCentralElement - 1, node, level + 1));
        node.setRightChild(createBST(a, indexCentralElement + 1, indexEnd, node, level + 1));
        return node;
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node == null) {
            return true;
        }

        int leftDeep = height(root_node.getLeftChild());
        int rightDeep = height(root_node.getRightChild());

        if (Math.abs(leftDeep - rightDeep) <= 1
                && IsBalanced(root_node.getLeftChild())
                && IsBalanced(root_node.getRightChild())) {
            return true;
        }
        return false;
    }

    private int height(BSTNode root_node) {
        if (root_node == null) {
            return 0;
        }
            return 1 + Math.max(height(root_node.getLeftChild()), height(root_node.getRightChild()));
    }

    public BSTNode getRoot() {
        return Root;
    }

    public void setRoot(BSTNode root) {
        Root = root;
    }
}
