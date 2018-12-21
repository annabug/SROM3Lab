package com.company;

import com.company.MyClass;
import com.sun.jdi.Value;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class MyClassTest2 {

    private String valueA;

    public MyClassTest2(String valueA){
        this.valueA=valueA;
    }
    @Parameterized.Parameters(name = "{index}: {1} ^(p-1) = 1 mod p ")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"1"},
                {"24124124214"},
                {"3786D3A85E62EC763A05A73A7F08D21EEE3CBCAE207E40854121BFF8258F7B2B293B0D30277CD"},
                {"B42C28861FB57657E27A1D41D3E61730FAB712FB0E55728443D1A18C27DE41"},
                {"BED6162E30FD36D3B6F960A67E1129706EC5A0EF57DD3E45"},
                {"2D3A852D3A852D3A852D3A851"},
                {"2412412D3A852D3A852D3A852D3A852D3A8524214"},
                {"3786D3A85E62EC763A05A73A7F08D21EEE3CBCAE207E40854121BFF8258F7B2B293B0D30277CD"},
                {"B42C28861FB57657E27A1D41D3E61730FAB712FB0E55728443D1A18C27DE41"},
                {"BED6162E30FD36D3E1129706EC5A0EF57DD3E45"},
                {"3786D3A85E623A05A73A7F08D21EEE3CBCAE207E40854121BFF8258F7B2B293B0D30277CD"},
                {"B42C28861FB57657E27A1B712FB0E55728443D1A18C27DE41"},
                {"BED6162E30FD36D3B6F960A67E1129706EC5A0EF57DD3E45"}
        });
    }

    private boolean Correctness(boolean[] arr){
        int len = arr.length;
        if(!arr[0]){ return false; }
        for(int i = 1; i < len; i++){
            if(arr[i]){return !arr[i];}
        }
        return true;
    }

    @Test
    public void main(){
        MyClass obj = new MyClass();
        String gen = "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000001";
        String power_str = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        boolean[] power = obj.getBooleanArray(power_str);
        obj.rash = 191;
        boolean[] poly = obj.getBooleanArray(gen);
        obj.poly = poly;
        poly = obj.remove0(poly);
        obj.polyL = poly.length;
        boolean[] a = obj.getBooleanArray(this.valueA);
        boolean[] res = obj.power(a,power);
        assertEquals(Correctness(res),true);
    }
}