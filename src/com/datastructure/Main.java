package com.datastructure;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNodeAtLast(11);
        list.addNodeAtLast(12);
        list.addNodeAtLast(13);
        list.addNodeAtLast(13);
        list.addNodeAtLast(15);
        try {
            //System.out.println("Element value at position: " + list.getNode(3).getNodeValue());
            //  list.addNodeAtGivenPosition(100, 1);
            //  list.deleteNode(1);
            list.insertInSortedList(-55);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Current size: " + list.getListSize());
        ArrayList result = list.getListValues();
        //list.reverseList();
        //System.out.println("Current size: " + list.getListSize());
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Position:" + (i + 1) + "   Value:" + result.get(i));
        }
        System.out.println("Current size: " + list.getListSize());
        LinkedListNode resultNode = list.findNThNodeFromEnd(0);

        if(resultNode != null)
            System.out.println("Result list - > " + list.findNThNodeFromEnd(0).getNodeValue());
        else
            System.out.println("result is null.....");
    }


}
