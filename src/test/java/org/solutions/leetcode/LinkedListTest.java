package org.solutions.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.solutions.leetcode.dataStructures.Node;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    static LinkedListProblems linkedListProblems;

    @BeforeAll
    static void setup() {
        linkedListProblems = new LinkedListProblems();
    }

    @Test
    void hasCycle() {
        Node head = getLinkedListFromListWithCycle(Arrays.asList(3,2,0,-4), 1);
        assertTrue(linkedListProblems.hasCycle(head));

        head = getLinkedListFromListWithCycle(Arrays.asList(1, 2), 0);
        assertTrue(linkedListProblems.hasCycle(head));

        head = getLinkedListFromListWithCycle(Collections.singletonList(1), -1);
        assertFalse(linkedListProblems.hasCycle(head));
    }

    private Node getLinkedListFromListWithCycle(List<Integer> entries, int pos) {
        List<Node> nodesList = entries.stream()
                .map(Node::new)
                .collect(Collectors.toList());

        for(int i=0; i<entries.size()-1; i++) {
            nodesList.get(i).setNext(nodesList.get(i+1));
        }

        // create a loop from last node to node at index = pos.
        // no cycle if pos = -1
        if (pos >= 0) {
            nodesList.get(entries.size() - 1).setNext(nodesList.get(pos));
        }

        return nodesList.get(0);
    }

    private Node getLinkedListFromList(List<Integer> entries) {
        return getLinkedListFromListWithCycle(entries, -1);
    }
}