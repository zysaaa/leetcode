package com.zysaaa.zysaaa20210225;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/lru-cache-lcci/
 * @author:zysaaa
 * @date: 2021/3/28 17:01
 */
public class LRUCache2 {

    public static void main(String[] args) {
        LRUCache2 lruCache2 = new LRUCache2(2);
        lruCache2.put(1,1);
        lruCache2.put(2,2);
        lruCache2.get(1);
        lruCache2.put(3,3);

    }

    private int capacity;

    private Map<Integer, Node> map;

    private int size;

    private Node head;
    private Node tail;

    private static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;
    }

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }


    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private Node moveLast() {
        Node lastNode = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return lastNode;
    }

    private void moveNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public int get(int key) {
        if (map.containsKey(key)) {
            // nodelist update
            Node node = map.get(key);
            moveNode(node);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveNode(node);
            moveToHead(node);
        } else {
            Node node = new Node();
            node.key = key;
            node.value = value;
            if (size == capacity) {
                Node moveLast = moveLast();
                moveToHead(node);
                map.remove(moveLast.key);
            } else {
                size++;
                moveToHead(node);
            }
            map.put(key, node);
        }
    }

}
