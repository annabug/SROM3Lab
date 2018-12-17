package com.company;

public class MyClass {

    public boolean[] zadd0(boolean[] x, int m){
        int al = x.length;
        int index = 0;
        int len = al + m;
        boolean[] rez_arr = new boolean[len];
        for( int i  = 0; i < al; i++){
            index = i;
            rez_arr[i] = x[i];
        }
        for(int i = index; i < len; i++){
            rez_arr[i] = false;
        }
        return rez_arr;
    }

    public boolean[] add(boolean[] a, boolean[] b){
        int al = a.length;
        int bl = b.length;
        int length = a.length;
        boolean[] arres = new boolean[length];
        if(al != bl){
            if(al < bl){
                a = zadd0(a,al -bl);
            }
            else{
                b = zadd0(b,bl - al);
            }
        }
        for(int i = 0; i < length; i ++){
            arres[i] = (b[i])^(a[i]);
        }
        return arres;
    }
}
