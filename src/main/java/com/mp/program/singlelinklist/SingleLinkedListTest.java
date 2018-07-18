package com.mp.program.singlelinklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表翻转
 *
 * Created by min on 3/3/2017.
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        Node sourceLink = generateLinkedList(list);

        printSingleLinkedList(sourceLink);

        Node descLink = reverseLinkedList(sourceLink);

        printSingleLinkedList(descLink);


    }

    /**
     * 反转链表
     *
     * @param node
     * @return
     */
    private static Node reverseLinkedList(Node node) {
        if (null == node) {
            return null;
        }
        if (null == node.getNext()) {
            return node;
        }
        Node resultNode = new Node(node.getData(), null);
        node = node.getNext();
        while(null != node.getNext()) {
            Node nextNode = node.getNext();
            node.setNext(resultNode);
            resultNode = node;
            node = nextNode;
        }
        node.setNext(resultNode);
        resultNode = node;
        return resultNode;
    }

    /**
     * 将列表元素组装成单链表
     *
     * @param list
     * @return
     */
    public static Node generateLinkedList(List<Integer> list){
        if (null == list) {
            System.out.println("Empty list!");
        }
        if (list.size() == 0) {
            return null;
        }
        Node indexNode = new Node(list.get(0), null);
        Node head = indexNode;
        Node node = null;
        for (int i = 1; i < list.size(); i++) {
            node = new Node(list.get(i),null);
            indexNode.setNext(node);
            indexNode = indexNode.getNext();
        }
        return head;
    }

    /**
     * 输出单链表
     *
     * @param node
     */
    public static void printSingleLinkedList(Node node) {
        StringBuilder sb = new StringBuilder("");
        while(null != node.getNext()){
            sb.append(node.getData() + ",");
            node = node.getNext();
        }
        sb.append(node.getData());
        System.out.println(sb.toString());
    }
}
