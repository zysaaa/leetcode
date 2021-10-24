package again.leetcode.设计;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: lru cache
 *
 * 需要一个链表去维护“热度”，当put的时候发现队列满了，那么取链表的尾巴节点，删除。
 * 注意，在这个场景下，链表优于数组，因为大部分操作都是节点的移动。
 *
 * @author: zysaaa
 * @date: 2021/10/24 13:00
 */
// NotThreadSafe
public class LRUCache<K, V> {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    private Map<K, Node<K, V>> data;

    private int capacity;

    private int size;


    // dummy node
    private Node<K, V> head;
    private Node<K, V> tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;

        // init work
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;

        data = new HashMap<>(capacity);
    }

    public V get(K key) {

        if (!data.containsKey(key)) {
            return null;
        }

        Node<K, V> node = data.get(key);
        moveToHead(node);
        return node.value;
    }

    public V put(K key, V val) {

        if (data.containsKey(key)) {
            Node<K, V> node = data.get(key);
            V original = node.value;
            node.value = val;
            moveToHead(node);
            return original;
        } else {
            if (size == capacity) {
                // unlink tail node
                Node<K, V> tail = unlinkTail();
                data.remove(tail.key);
            } else {
                size ++;
            }
            Node<K, V> node = new Node<>(key, val);
            linkHead(node);
            data.put(key, node);
        }
        return null;
    }

    private Node<K, V> unlinkTail() {
        Node<K, V> last =  tail.prev;
        tail.prev.next = tail;
        tail.prev = tail.prev.prev;
        return last;
    }

    private void linkHead(Node<K, V> node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void moveToHead(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        linkHead(node);
    }

    // node
    private static class Node<K, V> {

        private K key;
        private V value;

        private Node<K, V> next;
        private Node<K, V> prev;

        Node() {}

        Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

    }



}
