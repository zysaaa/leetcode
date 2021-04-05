package com.zysaaa.zysaaa20210225;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: https://leetcode-cn.com/problems/lfu-cache/
 * @author:zysaaa
 * @date: 2021/4/5 17:04
 */
public class LFUCache {

    public static void main(String[] args) {

        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(2,2);
        lfuCache.put(1,1);
        lfuCache.get(2);
        lfuCache.get(1);
        lfuCache.get(2);
        lfuCache.put(3,3);
        lfuCache.put(4,4);
        lfuCache.get(3);
        lfuCache.get(2);
        lfuCache.get(1);
        lfuCache.get(4);

    }

    private int capacity;

    private int size;

    private Map<Integer, Node> data;

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;
        int accessCount;
    }

    private Node head;
    private Node tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void moveNode(Node node, boolean removeIt) {
        // 找到第一个accesscount比它大的，成为它的pre
        if (removeIt) {
            removeNode(node);
        }
        Node tmp = head.next;
        boolean find = false;
        while (tmp != null) {
            if (tmp.accessCount <= node.accessCount) {
                find = true;
                tmp.prev.next = node;
                node.prev = tmp.prev;
                tmp.prev = node;
                node.next = tmp;
                break;
            } else {
                tmp = tmp.next;
            }
        }
        if (!find) {
            moveToTail(node);
        }
    }

    private void moveToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void moveToTail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private Node removeLast() {
        Node last = tail.prev;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return last;
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            Node node = data.get(key);
            // access count +1
            node.accessCount ++;
            // move
            moveNode(node, true);
            return node.value;

        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (data.containsKey(key)) {
            Node node = data.get(key);
            // access count +1
            node.accessCount ++;
            node.value = value;
            // move
            moveNode(node, true);
        } else {
            if (size == capacity) {
                // 移除最不常使用的
                Node node = removeLast();
                data.remove(node.key);
            } else {
                size ++;
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            node.accessCount = 1;
            data.put(key, node);
            moveNode(node, false);

        }
    }
}
