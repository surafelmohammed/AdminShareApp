package com.example.surafel.junittest;

public class presenter {

    int add(int first,int second){
        return first+second;
    }

    int multiply(int first,int second){
        return first*second;
    }

    int divide(int first, int second){
        int result = 0;
        if(second!=0){
            result = first/second;
        }
        return result;
    }
    int substruct(int first, int second){
        return first-second;
    }

}
