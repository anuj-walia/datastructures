package com.digitextra.datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BasicStack<X> {
    private X data[];
    private int lastUnusedIndex=0;
    private int length = 1000;

    public BasicStack(){
        X data[] = (X[]) Array.newInstance(Object.class, length);
    }

    public Boolean push(X value){
        Boolean status= Boolean.FALSE;
        if (lastUnusedIndex<length){
            data[lastUnusedIndex]=value;
            status=Boolean.TRUE;
        }
        else{
           System.out.println("Stack is full");
           System.out.println("Increasing the length of Stack Dynamically");
            Arrays.copyOf(data,length*2);
            length=length*2;
            data[lastUnusedIndex]=value;
        }
        lastUnusedIndex= lastUnusedIndex+1;
        return status;
    }

    public X pop() throws NegativeArraySizeException{
        X value=null;
        if(lastUnusedIndex>0){
            value = data[lastUnusedIndex-1];
        }
        else{
            throw new NegativeArraySizeException("No element in the stack");
        }
        return value;
    }

    public int search(X value){
        int index=-1;
        for (int i=0; i<lastUnusedIndex-1; i++){
            if (value.equals(data[i])){
                index=i;
                break;
            }
        }
        return index;
    }
}
