package deque;

import java.util.List;
import java.util.ArrayList;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    private Node sentinel;
    private int size = 0;

    public LinkedListDeque61B(){
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(T x) {
        Node oldFirstNode = sentinel.next;
        Node newNode = new Node(x);

        sentinel.next = newNode;
        newNode.prev = sentinel;
        newNode.next = oldFirstNode;
        oldFirstNode.prev = newNode;

        size++;
    }

    @Override
    public void addLast(T x) {
        Node oldLastNode = sentinel.prev;
        Node newNode = new Node(x);

        oldLastNode.next = newNode;
        newNode.prev = oldLastNode;
        newNode.next = sentinel;
        sentinel.prev = newNode;

        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node pointer = sentinel.next; // 从第一个有效节点开始遍历

        while (pointer != sentinel) { // 遇到 sentinel 说明遍历结束
            returnList.add(pointer.value); // 添加当前节点的值
            pointer = pointer.next; // 移动到下一个节点
        }

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        if(sentinel.next == sentinel){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        if ((index > size-1) || (index < 0) ){
            return null;
        }
        else{
            Node pointer = sentinel.next; // first node
            for (int i = 0; i < index; i++){
                pointer = pointer.next;
            }
            return pointer.value;
        }
    }

    @Override
    public T getRecursive(int index) {
        if ((index > size-1) || (index < 0) ){
            return null;
        }
        else{
            return getRecursiveHelper(sentinel.next, index);
        }
    }

    private T getRecursiveHelper(Node current, int index){
        if (index == 0){
            return current.value;
        }
        else{
            return getRecursiveHelper(current.next, index - 1);
        }
    }

    private class Node{
        public T value;
        public Node next;
        public Node prev;

        public Node(T x){
            value = x;
        }

        public Node(){
        }
    }
}