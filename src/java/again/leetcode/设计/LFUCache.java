package again.leetcode.设计;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: lfu cache---有序双向列表也可以啊？如果使用堆的话？ 因为妈的跟lru没差别
 *
 * 使用双map，但是，请注意，需要自己实现一个LinkedList，而不能使用JDK中提供的，JDK中提供的remove并不是O(1)的复杂度
 *
 * @author: zysaaa
 * @date: 2021/10/24 13:53
 */
public class LFUCache {


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0);
        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);
        System.out.println(cache.get(2));
    }

    private int minFreq = 0;
    private int capacity = 0;
    private int size;

    private Map<Integer, Node> keyTable;

    private Map<Integer, DLinkedList> freqTable;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyTable = new HashMap<>(capacity);
        freqTable = new HashMap<>();
    }

    public int get(int key) {
        if (!keyTable.containsKey(key)) {
            return -1;
        }
        Node node = keyTable.get(key);

        DLinkedList dLinkedList = freqTable.get(node.freq);

        dLinkedList.remove(node);
        if (dLinkedList.isEmpty()) {
            freqTable.remove(node.freq);
            if (node.freq == minFreq) {
                minFreq++;
            }
        }
        DLinkedList linkedList = freqTable.getOrDefault(node.freq + 1, new DLinkedList());
        linkedList.add(node);
        node.freq ++;

        // update node
        keyTable.put(key, node);
        freqTable.put(node.freq, linkedList);
        return node.value;

    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyTable.containsKey(key)) {

            // 更新value，访问次数+1

            Node node = keyTable.get(key);
            int freq = node.freq;

            DLinkedList nodes = freqTable.get(freq);
            // O(1)
            nodes.remove(node);
            if (nodes.isEmpty()) {
                freqTable.remove(freq);
                // 更新minFreq
                if (freq == minFreq) {
                    minFreq ++;  //因为新的节点的访问次数就是 当前+1
                }
            }
            DLinkedList dLinkedList = freqTable.getOrDefault(freq + 1, new DLinkedList());
            node.freq++;
            node.value = value;
            dLinkedList.add(node);
            freqTable.put(freq + 1, dLinkedList);
            keyTable.put(key, node);
        } else {
            if (keyTable.size() == capacity) {
                // 删
                DLinkedList dLinkedList = freqTable.get(minFreq);
                Node node = dLinkedList.removeLast();

                keyTable.remove(node.key);

                if (dLinkedList.isEmpty()) {
                    freqTable.remove(minFreq);
                }

                // 加入，此时访问次数是1
                DLinkedList linkedList = freqTable.getOrDefault(1, new DLinkedList());
                Node newNode = new Node(key, value);
                freqTable.put(1, linkedList);
                newNode.freq = 1;
                linkedList.add(newNode);
                keyTable.put(key, newNode);
                minFreq = 1;
            } else {
                Node node = new Node(key, value);
                node.freq = 1;
                DLinkedList dLinkedList = freqTable.getOrDefault(1, new DLinkedList());
                dLinkedList.add(node);
                freqTable.put(1, dLinkedList);
                keyTable.put(key, node);
                minFreq = 1;
            }
        }

    }

    private static class Node {
        private int key;
        private int value;
        private int freq;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DLinkedList {

        private Node head;
        private Node tail;

        private DLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
        }

        public Node removeLast() {

            Node node = tail.prev;
            remove(node);
            return node;

        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }

}
