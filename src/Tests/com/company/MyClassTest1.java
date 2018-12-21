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
public class MyClassTest1 {

    private String valueA;
    private String valueB;
    private String valueC;

    public MyClassTest1(String valueA,String valueB,String valueC){
        this.valueA=valueA;
        this.valueB=valueB;
        this.valueC=valueC;
    }
    @Parameterized.Parameters(name = "{index}: Distributivus ({0}+{1})*{2} =   {0}*{2} + {1}*{2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {"FFF","0","FFFFFF"},
                {"0","1","1"},
                {"24124124214","51876571651","8E06E4DFFB37B6"},
                {"5467235482358452834","1","8E06E4248235423654862354823548523845DFFB37B1"},
                {"FFFFFFFFFFFFFFF","FFFF1","FFFFFFF54823548523845DFFB37B1"},
                {"54672352834","1","8E06E4248235423654FFFFFFFF523845DFFB37B1"},
                {"5467235482358452FFFF","1FFFFFFFF","8E06E424823554823548523845DFFB37B1"},
                {"5467235482358452834","AAAAAAAAAAAAA1","8E06E424823542FFFFFFFFFFFFFF48235485238451"},
                {"54672AAFFF358452834","AAAAAAAAA1","8E0642365486235482354852FFFFFFFFFFFB0"}


        });
    }

    @Test
    public void main(){
        MyClass obj = new MyClass();
        String gen = "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000001";
        obj.polyvalue(obj.getBooleanArray(gen));
        boolean[] a = obj.getBooleanArray(this.valueA);
        boolean[] b = obj.getBooleanArray(this.valueB);
        boolean[] c = obj.getBooleanArray(this.valueC);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        boolean[] res_1 = obj.themainmul(obj.themainadd(a,b),c);
        boolean[] res_2 = obj.themainmul(obj.themainadd(a,c),obj.themainmul(b,c));
        assertArrayEquals(res_1,res_2);
    }
}