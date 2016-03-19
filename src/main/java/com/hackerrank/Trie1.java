package com.hackerrank;

/**
 * Created by MyMac on 19/03/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node{
    int value;
    Node[] arrayNode;
}

class Root{
    Node root;
    int count;
}

public class Trie1{
    private static Node getNode(){
        Node node = new Node();
        node.value = 0;
        node.arrayNode = new Node[26];
        for(int i=0;i<26;i++){
            node.arrayNode[i]=null;
        }
        return node;
    }


    private static void add(Root head, String key){
        Node tmp;
        head.count++;
        tmp = head.root;

        for(int i=0;i<key.length();i++)
        {
            int ind = key.charAt(i)-97;
            if(tmp.arrayNode[ind]!=null){
                tmp = tmp.arrayNode[ind];
                tmp.value++;
            }
            else{
                tmp.arrayNode[ind] = getNode();
                tmp = tmp.arrayNode[ind];
                tmp.value = 1;
            }
        }

        return;
    }

    private static int find(Root head, String key){

        Node tmp = head.root;
        for(int i=0;i<key.length();i++){
            int ind=  key.charAt(i)-97;
            if(tmp.arrayNode[ind]==null){
                return 0;
            }
            tmp = tmp.arrayNode[ind];
        }

        return tmp!=null?tmp.value : 0;


    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        if(N<=0){
            return;
        }

        Root head = new Root();
        head.root = getNode();
        head.count = 0;
        while(N-->0){
            String op = sc.nextLine();
            String[] arr = op.split(" ");
            if(arr[0].equals(new String("add"))){
                add(head, arr[1]);
            }
            else if(arr[0].equals(new String("find"))){
                System.out.println(find(head, arr[1]));
            }
        }
    }
}
