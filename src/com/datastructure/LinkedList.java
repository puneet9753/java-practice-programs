package com.datastructure;

import java.util.ArrayList;
// LinkList Class created.
public class LinkedList {
    LinkedListNode headNode;
    private int length = 0;

    public synchronized LinkedListNode getHead() {
        return headNode;
    }

    public LinkedList() {
        headNode = null;
    }

    // returns all the values in array list
    public ArrayList<Integer> getListValues() {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (headNode != null) {
            LinkedListNode currentNode = headNode;
            while (currentNode != null) {
                resultList.add(currentNode.getNodeValue());
                currentNode = currentNode.getNextNode();
            }
        }

        return resultList;
    }

    // returns the size of the list
    public int getListSize() {
        int size = 0;
        if (headNode != null) {
            LinkedListNode currentNode = headNode;
            while (currentNode != null) {
                size++;
                currentNode = currentNode.getNextNode();
            }
        }
        return size;
    }

    // returns the last node of the list
    public LinkedListNode getLastNode() {
        if (headNode == null)
            return null;
        LinkedListNode currentNode = headNode;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    // returns the node at given position
    public LinkedListNode getNode(int position) throws Exception {
        if (position > getListSize()) {
            throw new Exception("Position is greater than length of list.");
        } else if (position < 1) {
            throw new Exception("Position is invalid.");
        } else {
            if (headNode == null)
                return null;

            LinkedListNode currentNode = headNode;
            int counter = 1;
            while (counter < position) {
                currentNode = currentNode.getNextNode();
                counter++;
            }
            return currentNode;
        }
    }

    // add node at the end with given value
    public void addNodeAtLast(int val) {
        LinkedListNode newNode = new LinkedListNode(val);
        LinkedListNode listLastNode = getLastNode();
        if (listLastNode == null) {
            headNode = newNode;
        } else {
            listLastNode.setNextNode(newNode);
        }
    }

    // add node after the given position with given value
    public void addNodeAfterGivenPosition(int value, int position) {
        LinkedListNode newNode = new LinkedListNode(value);
        if (position == getListSize()) {
            addNodeAtLast(value);
        } else {
            LinkedListNode insertAfterNode = null;
            LinkedListNode insertBeforeNode = null;
            try {
                insertAfterNode = getNode(position);
                if (insertAfterNode == null) {
                    headNode = newNode;
                } else {
                    insertBeforeNode = insertAfterNode.getNextNode();
                    insertAfterNode.setNextNode(newNode);
                    newNode.setNextNode(insertBeforeNode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //update node value with new value on given position
    public void updateNode(int newValue, int position) {
        LinkedListNode nodeToUpdate;
        if (position == getListSize()) {
            nodeToUpdate = getLastNode();
            nodeToUpdate.setNodeValue(newValue);
        } else {
            try {
                nodeToUpdate = getNode(position);
                if (nodeToUpdate == null) {
                    addNodeAfterGivenPosition(newValue, position);
                } else {
                    nodeToUpdate.setNodeValue(newValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // add node at given position with given value
    public void addNodeAtGivenPosition(int value, int position) {
        LinkedListNode newNode = new LinkedListNode(value);
        if (position == getListSize()) {
            addNodeAtLast(value);
        } else {
            LinkedListNode previousNode = null;
            try {
                if (position == 1) {    // add as first node
                    newNode.setNextNode(headNode);
                    headNode = newNode;
                } else {
                    previousNode = getNode(position - 1);
                    if (previousNode == null) {
                        headNode = newNode;
                    } else {
                        newNode.setNextNode(previousNode.getNextNode());
                        previousNode.setNextNode(newNode);
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    //delete node on given position
    public void deleteNode(int position) {
        try {
            if (getListSize() == 0) {
                return;
            } else {
                if (position == 1 && getListSize() == 1) {
                    headNode = null;
                } else if (position == 1 && getListSize() > 1) {
                    headNode = headNode.getNextNode();
                } else {
                    LinkedListNode nodeToBeDeleted = getNode(position);
                    LinkedListNode previousNode = getNode(position - 1);
                    previousNode.setNextNode(nodeToBeDeleted.getNextNode());

                    // nodeToBeDeleted.setNextNode(nodeToBeDeleted.getNextNode().getNextNode());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedListNode findNThNodeFromEnd(int position) {
        if (getListSize() == 0 || position < 0) {
            return null;
        } else {
               /* if (position == 1 && getListSize() == 1) {
                    return headNode;
                } else {*/
            LinkedListNode pTemp = headNode;
            LinkedListNode pNthNode = null;
            int counter = 1;
            while (pTemp != null) {
                pTemp = pTemp.getNextNode();
                counter++;
                if (counter == position) {
                    pNthNode = pTemp;
                    return pNthNode;
                }
            }
        }
        return null;
    }

    public boolean isLinkedListCyclic() {
        LinkedListNode pointerOne = headNode;
        LinkedListNode pointerTwo = headNode;

        while (pointerTwo != null && pointerTwo.getNextNode() != null) {
            pointerOne = pointerOne.getNextNode();
            pointerTwo = pointerTwo.getNextNode().getNextNode();
            if (pointerOne == pointerTwo) {
                return true;
            }
        }
        return false;
    }

    public LinkedListNode returnStartForCyclicList() {
        LinkedListNode pointerOne = headNode;
        LinkedListNode pointerTwo = headNode;
        LinkedListNode resultNode = null;
        boolean isCyclic = false;

        while (pointerTwo != null && pointerTwo.getNextNode() != null) {
            pointerOne = pointerOne.getNextNode();
            pointerTwo = pointerTwo.getNextNode().getNextNode();
            if (pointerOne == pointerTwo) {
                isCyclic = true;
                break;
            }
        }

        if (isCyclic == true) {
            LinkedListNode pointerThree = headNode;
            pointerOne = headNode;
            while (pointerTwo != pointerOne) {
                pointerOne = pointerOne.getNextNode();
                pointerTwo = pointerTwo.getNextNode();
            }
            resultNode = pointerOne;
        }
        return null;
    }

    public int getLengthOfCyclicList() {
        LinkedListNode pointerOne = headNode;
        LinkedListNode pointerTwo = headNode;
        boolean isCyclic = false;
        int size = 0;

        while (pointerTwo != null && pointerTwo.getNextNode() != null) {
            pointerOne = pointerOne.getNextNode();
            pointerTwo = pointerTwo.getNextNode().getNextNode();
            if (pointerOne == pointerTwo) {
                isCyclic = true;
                size = 1;
                break;
            }
        }

        if (isCyclic == true) {
            pointerOne = headNode;
            while (pointerTwo != pointerOne) {
                pointerOne = pointerOne.getNextNode();
                pointerTwo = pointerTwo.getNextNode();
                size++;
            }
        }
        return size;
    }

    public void insertInSortedList(int value) {
        LinkedListNode currentNode = headNode;
        LinkedListNode prevNode = null;
        LinkedListNode newNode = new LinkedListNode(value);
        if (value < headNode.getNodeValue()) { // first element to be inserted
            newNode.setNextNode(headNode);
            headNode = newNode;
        } else {
            while (currentNode != null && currentNode.getNodeValue() < value) {
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            newNode.setNextNode(currentNode);
            prevNode.setNextNode(newNode);
        }
    }

    /*public void reverseList(){

        LinkedListNode currentNode = headNode;
        LinkedListNode prevNode = headNode;
        LinkedListNode tempNode = headNode;
        while(currentNode != null){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        headNode = currentNode;
        headNode.setNextNode(prevNode);
    }*/
}
