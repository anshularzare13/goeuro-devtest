package com.level4;

/**
 * Created by MyMac on 14/02/16.
 */

//* Definition for singly-linked list.


public class Intersectlist {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {

        // find size of node a & b.
        if(a==null || b==null){
            return null;
        }
        int l1= getSize(a);
        int l2 =getSize(b);
        //if l1 > l2, traverse l1-l2 in a else if l2>l1 traverse l2-l1 in b.
        int newlength=l1;
        if(l1>l2){
            newlength=l2;
            int diff = l1-l2;
            while(diff>0){
                a=a.next;
                diff--;
            }
        }else if(l2>l1){
            newlength=l1;
            int diff = l2-l1;
            while (diff>0){
                b=b.next;
                diff--;
            }
        }

        //now a & b has equal size so start from beginning.
        while (newlength>0){
            if(a==b){
                return a;
            }else{
                a=a.next;
                b=b.next;
            }
            newlength--;
        }
        return null;

    }

    private int getSize(ListNode node) {
        int size=0;
        while (node!=null){
            size++;
            node = node.next;
        }
        return size;
    }

    public static void main(String[] args) {
        Intersectlist l = new Intersectlist();
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(10);


        ListNode l2 = ListNode.CreateListNode(new int[]{5,6,8,10});
        System.out.println(l.getIntersectionNode(null, l2).val);
    }
}
