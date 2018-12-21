package com.company;

import javax.swing.*;
import java.util.Arrays;

public class MyClass{

    public boolean[] add(boolean[] a, boolean[] b){
        if(a.length != b.length){
            if(b.length > a.length){
                a = aidzero(a,b.length - a.length);
            }
            else {
                b = aidzero(b,a.length - b.length);
            }
        }
        boolean[] arres = new boolean[a.length];
        for(int i = 0; i < a.length; i ++){
            arres[i] = (a[i])^(b[i]);
        }
        arres = mod(arres);
        return arres;
    }

    private boolean[] shifting(boolean[] a, int l){
        boolean[] ar = new boolean[a.length + l];
        for(int i = a.length + l - 1; i > l - 1; i--){
            ar[i] = a[i-l];
        }
        for(int i = l - 1; i > -1; i--){
            ar[i] = false;
        }
        return ar;
    }


    public boolean[] aidzero(boolean[] a, int k){
        boolean[] arres = new boolean[a.length+k];
        int i = 0;
        for( i = i; i < a.length; i++){
            arres[i] = a[i];
        }
        for(i = i; i < a.length + k; i++){
            arres[i] = false;
        }
        return arres;
    }

    private boolean[] mod(boolean[] a){
        boolean[] rga = new boolean[1];
        rga = remove0(a);
        if(rga.length < this.polyL){
            return rga;
        }
        int lendiff = rga.length - this.polyL;
        while(lendiff>=0 ){
            boolean[] temp;
            temp = shifting(poly,lendiff);
            rga = add(rga,temp);
            lendiff = rga.length - this.polyL;
            rga = remove0(rga);
        }
        return rga;
    }

    public boolean[] mul(boolean[] a,boolean[] b){
        if(a.length != b.length){
            if(b.length > a.length){
                a = aidzero(a,b.length - a.length);
            }
            else {
                b = aidzero(b,a.length - b.length);
            }
        }
        boolean[] arres = new boolean[rash];
        for (int i = 0; i < a.length; i++){
            if(b[i]){
                boolean[] temp;
                temp = shifting(a,i);
                arres = add(arres,temp);
            }
        }
        arres = mod(arres);
        return arres;
    }

    public boolean[] remove0(boolean[] bl){
        int i = bl.length - 1;
        while(bl[i] == false){
            if( i == 0 ){
                break;
            }
            i--;
        }
        boolean[] arres = new boolean[i+1];
        for(int j = 0; j < i + 1; j++){
            arres[j] = bl[j];
        }
        return arres;
    }


    public boolean[] arrofboolean(String str){
        char symb;
        boolean[] arres = new boolean[str.length()];
        for(int i = str.length() - 1; i > -1; i--){
            symb = str.charAt(i);
            if(symb == '0'){
                arres[i] = false;
            }
            else{
                arres[i] = true;
            }
        }
        return arres;
    }

    public boolean[] power(boolean[] arrp,boolean[] argumentum){
        boolean[] arres = new boolean[1];
        boolean bool;
        arres[0] =true;
        for(int i = arrp.length - 1; i > -1 ; i--){
            bool = arrp[i];
            if(bool){
                arres = mul(arres,argumentum);
            }
            if(i!=0) {
                argumentum = quadrat(argumentum);
            }
        }
        return arres;
    }

    public boolean[] obratka(boolean[] argumentum_ad_baculum){
        boolean[] arres = new boolean[1];
        arres[0] = true;
        for(int i = 1; i < rash; i++){
            argumentum_ad_baculum = quadrat(argumentum_ad_baculum);
            arres = mul(arres,argumentum_ad_baculum);
        }
        return arres;
    }


    public long[] from_hex_to_string(String srt){
        // взяла у Санька
        int k = 4;
        int str_len = srt.length();
        int arr_len = str_len/k + ( str_len%k>0 ? 1:0 ) ;
        StringBuffer str_buf = new StringBuffer(srt);
        long[] arr = new long [arr_len];
        for(int i = k, j = 0; i<= str_len && j <arr_len; i+=k, j++){
            arr[j] = Long.parseLong(str_buf.substring(str_len-i,str_len-i+k),16);
        }
        if (str_len%k!=0) {
            arr[arr_len - 1] = Long.parseLong(str_buf.substring(0, str_len % k), 16);
        }
        return arr;
    }



    public String getBinString(String arg){
        // і це трохи
        long[] arr = from_hex_to_string(arg);
        int len = arr.length; StringBuffer str = new StringBuffer("");
        for(int i = len - 1; i > -1; i--){
            str.append(Long.toBinaryString(arr[i]));
        }
        String ret_str = str.toString();
        return ret_str;
    }

    public boolean[] getBooleanArray(String basic){
        // і це трохи
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

    // конец

    public boolean[] quadrat(boolean[] p){
        boolean[] arres = new boolean[2* p.length];
        for(int i = 0; i < p.length; i++){
            if(p[i]){
                arres[2*i] = p[i];
            }
        }
        arres = mod(arres);
        return arres;
    }

    public boolean[] itsatrap(boolean[] p){
        boolean[] temp = new boolean[1];
        boolean[] arres = new boolean[rash];
        arres = remove0(arres);
        for(int i = 0; i < rash; i++){
            temp = add(arres,temp);
            arres = quadrat(arres);
        }
        return temp;
    }


    public int polyL;
    public boolean[] poly;
    public int rash;

}
