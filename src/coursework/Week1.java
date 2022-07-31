package coursework;

import coursework.SinglyLinkedList.Node;

public class Week1 {

    SinglyLinkedList[] arr; // This array stores all the linked lists user inputs.

    Week1(SinglyLinkedList[] arr) {
        // constructor
        this.arr = arr;
    }

    SinglyLinkedList MergeAll() {
        // This function itterates through all the linked lists and merges them into one
        // linked list.
        SinglyLinkedList FinalOutputList = arr[0]; 
        SinglyLinkedList mergedList; 
        for (int i = 1; i < arr.length; i++) {
            
            mergedList = MergeTwo(FinalOutputList, arr[i]); 
            FinalOutputList = mergedList; 
        }
        return FinalOutputList; 
    }

    SinglyLinkedList MergeTwo(SinglyLinkedList a, SinglyLinkedList b) {
        // This function merges two linked lists.
        SinglyLinkedList result = new SinglyLinkedList(); 
        Node first_itterator = a.head; 
        Node second_itterator = b.head; 
        while (first_itterator != null) {
            
            result.addNode(first_itterator.data); 
            first_itterator = first_itterator.next; 
        }
        while (second_itterator != null) {
           
            result.addNode(second_itterator.data); 
            second_itterator = second_itterator.next; 
        }
        return sortLinkedList(result); 
    }

    SinglyLinkedList sortLinkedList(SinglyLinkedList list) {
       
        Node current = list.head, index = null; 
        int temp; 

        if (list.head == null) {
            return null; 
        } else {
            while (current != null) {
               
                index = current.next;

                while (index != null) {
                   
                   
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
        return list; 
    }

    void Median() {

        int median = (MergeAll().getSize() + 1) / 2; 
        
        System.out.println("Median: " + MergeAll().getDataAtAnyPos(median)); 
    }

    public static void main(String[] args) {
       
        SinglyLinkedList[] arr = new SinglyLinkedList[3];
        SinglyLinkedList L1 = new SinglyLinkedList();
        SinglyLinkedList L2 = new SinglyLinkedList();
        SinglyLinkedList L3 = new SinglyLinkedList();

       
        L1.addNode(2);
        L1.addNode(4);
        L1.addNode(7);
        L1.addNode(5);
        L1.addNode(10);
        L2.addNode(3);
        L2.addNode(2);
        L2.addNode(7);
        L2.addNode(9);
        L3.addNode(12);
        L3.addNode(5);
        L3.addNode(6);
        L3.addNode(9);
      
        arr[0] = L1;
        arr[1] = L2;
        arr[2] = L3;
        Week1 w = new Week1(arr);
        
        w.Median();
        
    }
}