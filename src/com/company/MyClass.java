package com.company;

public class MyClass {

    public void setExtension(int extension){
        this.m = extension;
    }

    public void setGenerator(boolean[] poly){
        this.polynom = poly;
        this.polynomL = poly.length;
    }

    private boolean[] erKill(boolean[] a){
        int i = a.length - 1;
        while(!a[i] && i > 0){
            i--;
        }
        boolean[] rez_arr = new boolean[i+1];
        for(int j = 0; j < i + 1; j++){
            rez_arr[j] = a[j];
        }
        return rez_arr;
    }

    public boolean[] add0(boolean[] x, int m){
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
        boolean[] arres = new boolean[al < bl ? bl: al];
        if(al != bl){
            if(al < bl){
                a = add0(a,al -bl);
            }
            else{
                b = add0(b,bl - al);
            }
        }
        for(int i = 0; i < a.length; i ++){
            arres[i] = (b[i])^(a[i]);
        }
        return arres;
    }

    public boolean[] obratka(boolean[] a){
        boolean[] sr = new boolean[a.length];
        sr[0] = true;
        for(int i = 1; i < m; i++){
            a = quadrat(a);
            sr = mul(sr,a);
        }
        return sr;
    }

    public boolean[] shifting(boolean[] a, int m){
        int n = a.length;
        boolean[] arrres = new boolean[a.length + m];
        for(int i = 0; i < n; i++){
            arrres[i+m] = a[i];
        }
        return arrres;
    }

    private boolean[] modElement(boolean[] a){
        a = erKill(a);
        int al = a.length;
        int len = al - polynomL;
        if(al < polynomL){
            return a;
        }
        boolean[] temp;
        while(true){
            if(len<0){
                break;
            }
            temp = shifting(polynom,len);
            a = add(a,temp);
            a = erKill(a);
            len = a.length - this.polynomL;
        }
        return a;
    }

    public boolean[] mul(boolean[] a, boolean[] b){
        int al = a.length;
        int bl = b.length;
        if(al != bl){
            if(al < bl){
                a = add0(a,al -bl);
            }
            else{
                b = add0(b,bl - al);
            }
        }
        boolean[] ares = new boolean[a.length];
        boolean[] temp;
        for(int i = 0; i < b.length; i ++){
            if(b[i] == true) {
                temp = shifting(a, i);
                ares = add(ares, temp);
            }
        }
        return ares;

    }


    public boolean[] horner(boolean[] a, boolean[] stepen6){
        boolean bool;
        boolean[] arr = new boolean[a.length];
        int len = stepen6.length;
        arr[0] = true;
        for(int i = len - 1; i > -1 ; i--){
            bool = stepen6[i];
            if(true == bool){
                arr = mul(arr,a);
            }
            if(i!=0) {
                a = quadrat(a);
            }
        }
        return arr;
    }

    public boolean[] quadrat(boolean[] a){
        int al = a.length;
        boolean[] arres = new boolean[2*a.length];
        int i = 0;
        for(i = i; i < al; i++){
            if(a[i]){
                arres[2*i] = a[i];
            }
        }
        arres = modElement(arres);
        return arres;
    }

    public boolean[] itsatrap(boolean[] a){
        boolean[] tempor = new boolean[a.length];
        for(int i = 0; i < m; i++){
            tempor = add(tempor,a);
            a = quadrat(a);
        }
        return tempor;
    }




    private int m;
    private boolean[] polynom;
    private int polynomL;
}
