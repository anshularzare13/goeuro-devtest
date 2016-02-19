package com.level4;

import java.util.List;

/**
 * Created by MyMac on 14/02/16.
 */
public class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
        ListNode() {next = null;val=0;}
        public void add(int x){val = x;}

    public static ListNode CreateListNode(int[] numbers){
        if(numbers.length==0){
            return null;
        }
        ListNode l2 = new ListNode(numbers[0]);
        ListNode tmp = l2;
        for(int i=1; i<numbers.length;i++){
            ListNode r = new ListNode(numbers[i]);
            tmp.next = r;
            tmp =r;
        }
        return l2;
    }


    public static void print(ListNode head){

        while (head!=null){
            System.out.println(head.val+" ");
            head = head.next;
        }
    }
}





