package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/lfu-cache
 *
 * @author jimmapzya@gmail.com(zysaaa)
 */
public class LFUCache {

    private int capacity;
    private int time;
    private int size;

    private TreeSet<Node> treeSet;
    private Map<Integer, Node> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.time = 0;
        treeSet = new TreeSet<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        int val = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            treeSet.remove(node);
            val = node.val;
            node.time = ++time;
            node.cnt++;
            treeSet.add(node);
            map.put(key, node);
        }
        return val;
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        if (!map.containsKey(key)) {
            if (size == capacity) {
                Node first = treeSet.first();
                map.remove(first.key);
                treeSet.remove(first);
            } else {
                size++;
            }
            Node node = new Node();
            node.cnt = 1;
            node.time = ++time;
            node.key = key;
            node.val = value;
            treeSet.add(node);
            map.put(key, node);
        } else {
            Node node = map.get(key);
            node.val = value;
            treeSet.remove(node);
            node.time = ++time;
            node.cnt++;
            treeSet.add(node);
            map.put(key, node);
        }
    }


    static class Node implements Comparable<Node> {

        public int cnt;
        public int time;
        public int key;
        public int val;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return cnt == node.cnt && time == node.time && key == node.key && val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cnt, time, key, val);
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt != o.cnt ? this.cnt - o.cnt : this.time - o.time;
        }
    }
}
