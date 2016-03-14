package com.level4;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by MyMac on 06/03/16.
 */
public class ReorderList {

    public ListNode reorderList(ListNode A) {
        //First find mid of the link list.

        if(A==null || A.next==null ||A.next.next==null){
            return A;
        }
        ListNode slowptr = A;
        ListNode fastPtr = A;
        ListNode prev=A;
        int mid=0;
        while (fastPtr!=null && fastPtr.next!=null){
            prev=slowptr;
            mid++;
            slowptr=slowptr.next;
            fastPtr=fastPtr.next.next;
        }
        prev.next = reverseList(slowptr);
        slowptr=prev.next;
        fastPtr=A;
        //Now do the swapping. first check whether reverse works or not. It works!!
        while (mid>1){
            ListNode tmp1 = fastPtr.next;
            ListNode tmp2 =slowptr.next;
            fastPtr.next = slowptr;
            slowptr.next = tmp1;
            prev.next = tmp2;
            fastPtr = tmp1;
            slowptr=tmp2;
            mid--;
        }


        return A;
    }

    private ListNode reverse(ListNode slowptr) {
        if(slowptr.next==null){
            return slowptr;
        }
        ListNode r = reverse(slowptr.next);
        ListNode tmp = r;
        while(r.next!=null) {
            r = r.next;
        }
        r.next=slowptr;
        r.next.next=null;
        return tmp;
    }

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
        ListNode l = ListNode.CreateListNode(new int[]{1,2,3,4,5,6,7,8,9});
        ReorderList r = new ReorderList();
        ListNode.print(r.reorderList(l));
    }
}
