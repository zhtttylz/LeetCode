package may.twenty;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU cache 因为要对对象进行顺序变动，使用链表存储每个node信息
 * 因为要确定对象是否存在，使用map存储每个对象是否存在
 */
public class LRUCache {

    // 定义初始变量
    private MyLinkedNode head;
    private MyLinkedNode tail;
    private int count;
    private int capacity;
    // 记录对象是否还存在
    private Map<Integer, MyLinkedNode> map;

    class MyLinkedNode{

        int key;
        int value;
        MyLinkedNode pre;
        MyLinkedNode next;
    }

    public LRUCache(int capacity) {
        head = new MyLinkedNode();
        tail = new MyLinkedNode();

        map = new HashMap<>();
        count = 0;
        this.capacity = capacity;

        // 初始化链表指针
        head.next = tail;
        head.pre = null;

        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {

        if(map.containsKey(key)){

            MyLinkedNode node = map.get(key);
            // 将node移动到数组头部
            moveNodeToHead(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            // 更新value
            MyLinkedNode node = map.get(key);
            node.value = value;
            // 将node移动到数组头部
            moveNodeToHead(node);
        }else{

            MyLinkedNode node = new MyLinkedNode();
            node.key = key;
            node.value = value;
            addNode(node);
            map.put(key, node);
            count++;
        }

        // 如果超过容量了
        if(count > capacity){

            // 最后一个元素即tail.pre
            // 先从map中删除 在将其重链表中删除
            map.remove(tail.pre.key);
            removeNode(tail.pre);
            count--;
        }
    }

    /**
     * 删除指定的node
     */
    private void removeNode(MyLinkedNode node){

        MyLinkedNode next = node.next;
        MyLinkedNode pre = node.pre;
        pre.next = next;
        next.pre = pre;
    }

    /**
     * 在链表中添加node 即删除tail的pre node
     * @param node
     */
    private void addNode(MyLinkedNode node){

        MyLinkedNode next = head.next;

        head.next = node;
        node.pre = head;

        node.next = next;
        next.pre = node;

    }

    /**
     * 将node移动到链表头部
     * @param node
     */
    private void moveNodeToHead(MyLinkedNode node){

        // 先在链表中删除,在移动到头部
        this.removeNode(node);
        this.addNode(node);
    }

    public static void main(String[] args) {

        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        l.get(1);
        l.put(3,3);
        l.get(2);
    }
}
