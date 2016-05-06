package com.Misc;

import java.util.Scanner;

/**
 * Created by MyMac on 12/04/16.
 */
class Day{
    public  String name;

    public  String storesHours;

    Day(int i, String s){
        if(i==0){
            this.name = "Mon";
        }
        else if(i==1){
            this.name = "Tues";
        }else if(i==2){
            this.name = "Wed";
        }else if(i==3){
            this.name = "Thurs";
        }else if(i==4){
            this.name = "Fri";
        }else if(i==5){
            this.name = "Sat";
        }else if(i==6){
            this.name = "Sun";
        }

        this.storesHours = s;
    }

}


public class Stores {




    public static void main(String[] args) {
        int No_of_days = 7;
        int[] openinghrs = new int[No_of_days];
        int[] closinghrs = new int[No_of_days];
        Scanner sc = new Scanner(System.in);

        for(int i=0;i < 7;i++){
            openinghrs[i] = sc.nextInt();
        }

        for(int i=0; i < 7;i++){
            closinghrs[i] = sc.nextInt();
        }
        Day[] days = new Day[No_of_days];
        String storehours = "";
        for(int i=0; i<7;i++){
            if(openinghrs[i]>2400 || openinghrs[i] < 0 || closinghrs[i] >2400 || closinghrs[i] < 0 || openinghrs[i] > closinghrs[i]){
                storehours = "Closed";
            }
            else if(closinghrs[i] == openinghrs[i]){
                storehours = "Open 24 Hours";
            }
            else if(closinghrs[i] > openinghrs[i]){
                StringBuilder str = new StringBuilder();
                str.append(openinghrs[i]).append("-").append(closinghrs[i]);
                storehours = str.toString();
            }

            Day d = new Day(i, storehours);
            days[i] = d;
        }

        storehours = days[0].storesHours;
        StringBuilder str = new StringBuilder();

        str.append(days[0].name);
        int start = 0;
        int end = 0;
        for(int i=1;i<7;i++){
            if(days[i].storesHours.equals(storehours)){
                end = i;
            }else{
                //print here
                if(start!=end) {
                    str.append("-").append(days[end].name);
                }
                start = i;
                end=i;
                System.out.println(str + ":" + storehours);
                str = new StringBuilder();
                str.append(days[i].name);
                storehours = days[i].storesHours;
            }
        }
        if(start!=end){
            str.append("-").append(days[end].name);
        }
        System.out.println(str+ ":" + storehours);
    }
}
