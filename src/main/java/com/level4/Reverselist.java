package com.level4;

/**
 * Created by MyMac on 16/02/16.
 */
public class Reverselist {

    public ListNode reverseBetween(ListNode a, int m, int n) {
        if(a==null||a.next==null){
            return a;
        }

        if(m==n || m>n){
            return a;
        }
         //first traverse until m.
          ListNode prev=a,current=a;
          if(m==1){

          }
          int count=1;
          while(count!=m && current!=null){
              prev= current;
              current = current.next;
              count++;
          }
        if(m==1){
            prev = new ListNode(0);
            prev.next=current;
        }
        while(n-m>0){
            n--;
            ListNode tmp = current.next;
            current.next = tmp.next;
            tmp.next=prev.next;
            prev.next=tmp;
        }
        if(m==1){
            return prev.next;
        }
        return a;
    }


    public static void main(String[] args) {
        ListNode in = ListNode.CreateListNode(new int[]{1,2,3,4,5});
        Reverselist rev=new Reverselist();
        ListNode.print(rev.reverseBetween(in,1,4));

    }
}
