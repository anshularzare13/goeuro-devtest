package com.level4;

/**
 * Created by MyMac on 06/03/16.
 */
public class RotateList
{
    public ListNode rotateRight(ListNode a, int b) {
        if(a==null || a.next == null || b==0){
            return a;
        }
        //first find out length.
        ListNode tmp=a;
        int length=1;
        while (tmp.next!=null){
            tmp=tmp.next;
            length++;
        }

        ListNode last = tmp;
        b = b%length;
        if(b==0){
            return a;
        }

        //else traverse  length-b-1;
        int traverse=1;
        tmp  = a;
        while (traverse<length-b){
            tmp=tmp.next;
            traverse++;
        }

        //Now do the swapping of pointers.
        ListNode head = tmp.next;
        tmp.next = null;
        last.next = a;
        return head;

    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.CreateListNode(new int[]{1,2,3,4,5});
        RotateList l = new RotateList();
        ListNode.print(l.rotateRight(l1,49));

    }
}
