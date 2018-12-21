package com.company;

import javax.swing.*;
import java.util.Arrays;


public class MyClass{

    public void polyvalue(boolean[] pol){
        polyL = pol.length;
        poly = pol;
        rash = pol.length - 1;
    }


    public boolean[] shifting(int k, boolean[] arrey){
        boolean[] arrz = new boolean[arrey.length + k];
        for(int i = arrey.length + k - 1; i > k - 1; i--){
            arrz[i] = arrey[i-k];
        }
        for(int i = k - 1; i > -1; i--){
            arrz[i] = false;
        }
        return arrz;
    }

    public boolean[] mod(boolean[] as){
        as = remove0(as);
        while(as.length - polyL >=0 ){
            boolean[] temp;
            temp = shifting(as.length - polyL,poly);
            as = add(as,temp);
            as = remove0(as);
        }
        return as;
    }

    public boolean[] add0( int k, boolean[] ar){
        int length = ar.length + k;
        boolean[] arrees = new boolean[ar.length + k];
        int i = 0;
        for( i = i; i < ar.length; i++){
            arrees[i] = ar[i];
        }
        int lim = i;
        for(i = lim; i < ar.length + k; i++){
            arrees[i] = false;
        }
        return arrees;
    }

    public boolean[] add(boolean[] a, boolean[] b){
        if(a.length != b.length){
            if(a.length > b.length ){
                b = add0(a.length - b.length,b);
            }
            else{
                a = add0(b.length - a.length, a);
            }
        }
        boolean[] rez_add = new boolean[b.length];
        for(int i = 0; i < b.length; i ++){
            rez_add[i] = (a[i])^(b[i]);
        }
        return rez_add;
    }

    public boolean[] remove0(boolean[] ar){
        int i = ar.length - 1;
        while(!ar[i] && i > 0){
            i--;
        }
        boolean[] rez_arr = new boolean[i+1];
        for(int j = 0; j < i + 1; j++){
            rez_arr[j] = ar[j];
        }
        return rez_arr;
    }

    public boolean[] themainadd(boolean[] a, boolean[] b){
        b = mod(b);
        a = mod(a);
        boolean[] arrres = add(a,b);
        return arrres;
    }

    public boolean[] mul(boolean[] a,boolean[] b){
        if(a.length != b.length){
            if(a.length > b.length ){
                b = add0(a.length - b.length,b);
            }
            else{
                a = add0(b.length - a.length, a);
            }
        }
        boolean[] rez_arr = new boolean[1];
        rez_arr[0] = false;
        for (int i = 0; i < a.length; i++){
            if(b[i] == true){
                boolean[] temp;
                temp = shifting(i,a);
                rez_arr = themainadd(rez_arr,temp);
            }
        }
        return rez_arr;
    }

    public boolean[] themainmul(boolean[] a,boolean[] b){
        boolean[] prod = mul(a,b);
        prod = mod(prod);
        return prod;
    }

    public long[] hexToDecimal(String basic_str){
        int k = 4;
        int str_len = basic_str.length();
        int arr_len = str_len/k + ( str_len%k>0 ? 1:0 ) ;
        StringBuffer str_buf = new StringBuffer(basic_str);
        long[] arr = new long [arr_len];
        for(int i = k, j = 0; i<=str_len && j <arr_len; i+=k, j++){
            arr[j] = Long.parseLong(str_buf.substring(str_len-i,str_len-i+k),16);
        }
        if (str_len%k!=0) {
            arr[arr_len - 1] = Long.parseLong(str_buf.substring(0, str_len % k), 16);
        }
        return arr;
    }

    public String getBinString(String arg){
        long[] arr = hexToDecimal(arg);
        int len = arr.length; StringBuffer str = new StringBuffer("");
        for(int i = len - 1; i > -1; i--){
            str.append(Long.toBinaryString(arr[i]));
        }
        String ret_str = str.toString();
        return ret_str;
    }

    public boolean[] getBooleanArray(String basic){
        int string_len = basic.length();
        boolean[] arr = new boolean[string_len]; char chr;
        for(int i = string_len - 1; i > -1; i--){
            chr = basic.charAt(i);
            if(chr == '1'){
                arr[i] = true;
                continue;
            }
            arr[i] = false;
        }
        return arr;
    }


    public boolean[] quadrat(boolean[] a){
        boolean[] prod = new boolean[2*a.length];
        for(int i = 0; i < a.length; i++){
            if(a[i]){
                prod[2*i] = a[i];
            }
        }
        prod = mod(prod);
        return prod;
    }

    public boolean[] obratka(boolean[] perpetuum_mobile){
        boolean[] arres = new boolean[rash];
        arres[0] = true;
        for(int i = 1; i < rash; i++){
            perpetuum_mobile = quadrat(perpetuum_mobile);
            arres = themainmul(arres,perpetuum_mobile);
        }
        return arres;
    }

    public boolean[] gopwr(boolean[] pw,boolean[] perpetuum_modile){
        boolean[] arres = new boolean[rash];
        arres[0] = true;
        boolean bool;
        for(int i = pw.length - 1; i > -1 ; i--){
            bool = pw[i];
            if(bool){
                arres = themainmul(arres,perpetuum_modile);
            }
            if(i!=0) {
                perpetuum_modile = quadrat(perpetuum_modile);
            }
        }
        return arres;
    }

    public boolean[] itsatrap(boolean[] v){
        boolean[] arres = new boolean[rash];
        v = remove0(v);
        for(int i = 0; i < rash; i++){
            arres = add(v,arres);
            v = quadrat(v);
        }
        return arres;
    }

    public int rash;
    public boolean[] poly;
    public int polyL;

}
