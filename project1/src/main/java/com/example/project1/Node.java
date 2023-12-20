package com.example.project1;

public class Node<Object extends Comparable<Object>> {
    Object data;
    Node next;

    Node(Object d) {
        data = d;
    }

}
