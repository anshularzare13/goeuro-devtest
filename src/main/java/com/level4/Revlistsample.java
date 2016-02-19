package com.level4;

import javax.swing.*;

/**
 * Created by MyMac on 14/02/16.
 */



public class Revlistsample {
    public ListNode reverseList(ListNode a) {
        if(a==null){
            return a;
        }

        ListNode prev=a, current = a;

        while (current.next!=null){
            current = current.next;
            prev.next = current.next;
            current.next = a;
            a=current;
            current = prev;
        }
        return a;
    }


    public static void main(String[] args) {
        ListNode l2 = ListNode.CreateListNode(new int[]{1,2,3,4,5});

        Revlistsample r = new Revlistsample();
        ListNode.print(r.reverseList(null));

    }
}
