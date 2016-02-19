package com.level4;

/**
 * Created by anshul on 15/02/16.
 */
public class Lpalin {

    public int lPalin(ListNode A) {
        if(A==null || A.next==null){
            return 1;
        }
        //save A in some method.
        //find length of node.
        int l=0;
        ListNode ptr1=A,ptr2=A.next;
        while(ptr2!=null){
            ptr2 = ptr2.next;
            if(ptr2!=null){
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        ListNode reverse = reverseList(ptr1);
        while(A!=null){
            if(A.val!=reverse.val){
                return 0;
            }
            A = A.next;
            reverse = reverse.next;
        }
        return 1;
    }



    public ListNode reverseList(ListNode A) {

        ListNode node, prev, temp;

        node = A;

        if (node == null)
            return null;
        if(node.next==null){
            return node;
        }

        prev = null;

        while (node != null) {

            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;

        }
        return prev;
    }

    public ListNode reverseLinkList(ListNode node) {
        ListNode a=node;
        ListNode prev=a, current = a;
        if(a==null){
            return a;
        }
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
        ListNode in = ListNode.CreateListNode(new int[]{1,2,3,4,2,1});
        Lpalin lp = new Lpalin();
        System.out.print(lp.lPalin(in));
    }
}
