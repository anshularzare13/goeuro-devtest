package com.level4;

/**
 * Created by MyMac on 14/02/16.
 */
public class Addnum {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        if(a==null){
            return b;
        }
        else if(b==null){
            return a;
        }
        ListNode res = new ListNode(0);
        ListNode tmp,prev= res;
        int carry=0;
        while(a!=null && b!=null) {
            int num = a.val + b.val + carry;
            int mod = num % 10;
            carry = num / 10;
            tmp = new ListNode(mod);
            prev.next = tmp;
            prev=tmp;
            a = a.next;
            b = b.next;
        }
        while(a!=null){
            int num = a.val + carry;
            int mod = num%10;
            carry = num/10;
            tmp = new ListNode(mod);
            prev.next = tmp;
            prev=tmp;
            a=a.next;
        }
        while(b!=null) {
            int num = b.val + carry;
            int mod = num % 10;
            carry = num / 10;
            tmp = new ListNode(mod);
            prev.next = tmp;
            prev = tmp;
            b = b.next;
        }

        if(carry!=0){
            tmp = new ListNode(carry);
            prev.next = tmp;
        }
        return res.next;
    }

    public static void main(String[] args) {

//        ListNode num1 = ListNode.CreateListNode(new int[]{2,3});
//        ListNode num2 = ListNode.CreateListNode(new int[]{5,6,4});
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode L2 = new ListNode(1);
        Addnum addnum = new Addnum();
        ListNode res = addnum.addTwoNumbers(l1, L2);
        ListNode.print(res);
    }
}
