package org.gregory;

class BSTNode
{
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }

    public BSTNode(int nodeKey, BSTNode parent, int level) {
        NodeKey = nodeKey;
        Parent = parent;
        Level = level;
    }

    public int getNodeKey() {
        return NodeKey;
    }

    public BSTNode getParent() {
        return Parent;
    }

    public BSTNode getLeftChild() {
        return LeftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        LeftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return RightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        RightChild = rightChild;
    }

    public int getLevel() {
        return Level;
    }
}
