package com.level5;

import com.level4.ListNode;

/**
 * Created by MyMac on 20/02/16.
 */
public class Revlistrec {


    public ListNode reverseList(ListNode a) {
        if(a==null){
            return a;
        }
        // Do not take global variable.
        ListNode head;

        if(a.next==null){
            head= a;
            return head;
        }
        head = reverseList(a.next);
        ListNode nxt = a.next;
        nxt.next = a;
        a.next = null;
        return head;
    }


    public static void main(String[] args) {

        ListNode in  = ListNode.CreateListNode(new int[]{});
        Revlistrec rev= new Revlistrec();
        ListNode.print(rev.reverseList(in));

    }
}
