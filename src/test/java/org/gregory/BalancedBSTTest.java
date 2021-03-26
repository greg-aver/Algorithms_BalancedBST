package org.gregory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.nullValue;

class BalancedBSTTest {
    BalancedBST balancedBST;

    @BeforeEach
    void setUp() {
        balancedBST = new BalancedBST();
    }

    @AfterEach
    void tearDown() {
        balancedBST = null;
    }

    @Test
    void isBalanced_3Elements_true() {
        balancedBST.GenerateTree(new int[]{5, 1, 3});
        assertThat(balancedBST.IsBalanced(balancedBST.getRoot()), is(true));
    }

    @Test
    void isBalanced_7Elements_true() {
        balancedBST.GenerateTree(new int[]{5, 1, 3, 7, 6, 4, 8});
        assertThat(balancedBST.IsBalanced(balancedBST.getRoot()), is(true));
    }

    @Test
    void generateTree_arrayLength3() {
        balancedBST.GenerateTree(new int[]{5, 1, 3});
        assertThat(balancedBST.getRoot().getParent(), nullValue());
        assertThat(balancedBST.getRoot().getNodeKey(), is(3));
        assertThat(balancedBST.getRoot().getLevel(), is(1));

        assertThat(balancedBST.getRoot().getLeftChild().getNodeKey(), is(1));
        assertThat(balancedBST.getRoot().getLeftChild().getLevel(), is(2));

        assertThat(balancedBST.getRoot().getRightChild().getNodeKey(), is(5));
        assertThat(balancedBST.getRoot().getRightChild().getLevel(), is(2));

        assertThat(balancedBST.getRoot().getLeftChild().getParent().getNodeKey(), is(3));
        assertThat(balancedBST.getRoot().getRightChild().getParent().getNodeKey(), is(3));
    }

    @Test
    void generateTree_arrayLength7() {
        balancedBST.GenerateTree(new int[]{5, 1, 3, 7, 6, 4, 8});
        assertThat(balancedBST.getRoot().getParent(), nullValue());
        assertThat(balancedBST.getRoot().getNodeKey(), is(5));
        assertThat(balancedBST.getRoot().getLevel(), is(1));

        assertThat(balancedBST.getRoot().getLeftChild().getNodeKey(), is(3));
        assertThat(balancedBST.getRoot().getLeftChild().getLevel(), is(2));

        assertThat(balancedBST.getRoot().getRightChild().getNodeKey(), is(7));
        assertThat(balancedBST.getRoot().getRightChild().getLevel(), is(2));

        assertThat(balancedBST.getRoot().getLeftChild().getParent().getNodeKey(), is(5));
        assertThat(balancedBST.getRoot().getRightChild().getParent().getNodeKey(), is(5));

        assertThat(balancedBST.getRoot().getLeftChild().getLeftChild().getNodeKey(), is(1));
        assertThat(balancedBST.getRoot().getLeftChild().getLeftChild().getLevel(), is(3));

        assertThat(balancedBST.getRoot().getLeftChild().getRightChild().getNodeKey(), is(4));
        assertThat(balancedBST.getRoot().getLeftChild().getRightChild().getLevel(), is(3));

        assertThat(balancedBST.getRoot().getLeftChild().getLeftChild().getParent().getNodeKey(), is(3));
        assertThat(balancedBST.getRoot().getLeftChild().getRightChild().getParent().getNodeKey(), is(3));

        assertThat(balancedBST.getRoot().getRightChild().getLeftChild().getNodeKey(), is(6));
        assertThat(balancedBST.getRoot().getRightChild().getLeftChild().getLevel(), is(3));

        assertThat(balancedBST.getRoot().getRightChild().getRightChild().getNodeKey(), is(8));
        assertThat(balancedBST.getRoot().getRightChild().getRightChild().getLevel(), is(3));

        assertThat(balancedBST.getRoot().getRightChild().getLeftChild().getParent().getNodeKey(), is(7));
        assertThat(balancedBST.getRoot().getRightChild().getRightChild().getParent().getNodeKey(), is(7));
    }
}