package com.zysaaa.zysaaa20210225;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author:zysaaa
 * @date: 2021/3/14 18:22
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }


    private int capacity;

    private int size;

    private Map<Integer, Node<Integer, Integer>> data = new HashMap<>();

    private Node<Integer, Integer> head;
    private Node<Integer, Integer> tail;

    private static class Node<K, V> {

        private K key;
        private V value;

        private Node<K, V> pre, next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }


    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node<>(-1, -1);
        tail = new Node<>(-1, -1);
        head.next = tail;
        tail.pre = head;

    }

    private void moveToHead(Node<Integer, Integer> target) {

        target.next = head.next;
        head.next.pre = target;
        head.next = target;
        target.pre = head;
    }

    private void moveNode(Node target) {
        target.pre.next = target.next;
        target.next.pre = target.pre;
    }

    private Node removeLast() {
        Node node = tail.pre;
        tail.pre.pre.next = tail;
        tail.pre = tail.pre.pre;
        return node;
    }

    private void addToHead(Node<Integer, Integer> node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            Node<Integer, Integer> node = data.get(key);
            moveNode(node);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    // 线程安全问题？
    public void put(int key, int value) {

        if (data.containsKey(key)) {
            Node<Integer, Integer> node = data.get(key);
            node.value = value;
            moveNode(node);
            moveToHead(node);
        } else {
            Node<Integer, Integer> node = new Node<>(key, value);
            if (size == capacity) {
                // remove
                Node removeLast = removeLast();
                data.remove(removeLast.key);
            } else {
                size ++;
            }
            addToHead(node);
            data.put(key, node);
        }

    }


}
