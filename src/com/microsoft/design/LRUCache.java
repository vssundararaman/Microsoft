package com.microsoft.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    final Node head = new Node ();
    final Node tail = new Node ();
    Map<Integer,Node> nodeMap;
    int cacheCapacity;

    public LRUCache(int cacheCapacity){
        nodeMap = new HashMap<> (cacheCapacity);
        this.cacheCapacity = cacheCapacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        int result = -1;
        Node node = nodeMap.get (key);
        if(node!=null){
            result = node.val;
            remove (node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value){
        Node node = nodeMap.get (key);
        if(node !=null){
            remove (node);
            node.val = value;
            add (node);
        }else{
            if(nodeMap.size () == cacheCapacity){
                nodeMap.remove (tail.prev.key);
                remove (tail.prev);
            }
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.val = value;
        nodeMap.put (key,newNode);
        add(node);
    }

    public void add(Node node){
        Node headNext= head.next;
        node.next = headNext;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void remove(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;
}
