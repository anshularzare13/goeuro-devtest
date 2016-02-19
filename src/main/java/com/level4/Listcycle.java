package com.level4;

/**
 * Created by MyMac on 15/02/16.
 */
public class Listcycle {

    public ListNode detectCycle(ListNode a) {

        if(a==null||a.next==null){
            return a;
        }
        ListNode ptr1 =a,ptr2=a.next;
        boolean isCyclic =false;
        while (ptr2!=null){
            if(ptr1==ptr2){
                isCyclic = true;
                break;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            if(ptr1==ptr2){
                isCyclic = true;
                break;
            }
            if(ptr2!=null){
                ptr2=ptr2.next;
            }
        }

        if(isCyclic) {
            ptr1=a;
            ptr2=ptr2.next;
            while(ptr1!=ptr2){
                ptr1=ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;

        }
        return null;

    }

    public static void main(String[] args) {
        ListNode l = ListNode.CreateListNode(new int[]{1,2,3,4,5 });
        //to create cylic node, point 5 to any of the node.
        ListNode tmp = l.next.next;
        ListNode end = l.next.next.next.next;
        end.next=tmp;
        Listcycle lc = new Listcycle();
        System.out.print(lc.detectCycle(l));

    }
}
