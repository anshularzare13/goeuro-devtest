package com.level6;

import com.level4.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MyMac on 06/03/16.
 */
public class MergeKSortedList {

    //this is an easy problem.
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        //Take pointers equals to size of array list.
        //Now take the minimum of all these pointers and move that particular pointer forward.
        // keep on doing these till all expect one are null.
        int size = a.size();
        ListNode[] arr = new ListNode[size];
        for(int i=0;i<size;i++){
            arr[i] = a.get(i);
        }

        //Start the looping.
        int min = Integer.MAX_VALUE;
        ListNode head = new ListNode(min);
        head.next=null;
        ListNode tmp =head;
        boolean isEnd;
        int j=0;
        while(true) {
            min = Integer.MAX_VALUE;
            isEnd = true;
            for (int i = 0; i < size; i++) {
                if(arr[i]!=null){
                    isEnd = false;
                    if(arr[i].val<min){
                        j=i;
                        min = arr[i].val;
                    }
                }
            }
            if(!isEnd) {
                ListNode l = new ListNode(min);
                l.next = null;
                tmp.next = l;
                tmp = tmp.next;
                arr[j]=arr[j].next;
            }else {
                break;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.CreateListNode(new int[]{1,10,20});
        ListNode l2 = ListNode.CreateListNode(new int[]{4,11,13});
        ListNode l3 = ListNode.CreateListNode(new int[]{3,8,9});

        MergeKSortedList m = new MergeKSortedList();
        ListNode.print(m.mergeKLists(new ArrayList<ListNode>(Arrays.asList(l1,l2,l3))));

    }
}
