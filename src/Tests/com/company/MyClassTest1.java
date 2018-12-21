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
public class MyClassTest1{

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
                {"1","0","1"},
                {"F", "FFFF", "FFFFFFFFF"},
                {"24124124214","1","8E06E4DFFB37B6"},
                {"B42C28861FB57657E27A1D41D3E61730FAB712FB0E55728443D1A18C27DE41"
                        ,"5DAC08ABDA44199E807A4938658C6EC7CA27C558C226EE5E24E3CA8DA66A74E71"
                        , "111D3A9A9AD293D3770C9F1D7D3B54D2807A7BF2CF2CB2"
                },
                {"B30FD36D3B6706EC5A0EF57DD3E45"
                        ,"8FCAA5A2D5E40D532380B5F276C4"
                        ,"13F81407BF29A37B509"
                },
                {"B42C28861FB57657E2FAB712FB0E55728443D1A18C27DE41"
                        ,"5DA44199E807A4938658C6EC7CA27C558C226EE5E24E3CA8DA66A74E71"
                        , "1D3A9A9AD293D3770C9F1D7D3B54D2807A7BF2CF2CB2"
                },
                {"B42C28861FB57657E27A1D41D3E61730FAB712FD1A18C27DE41"
                        ,"5DAC08ABDA44199E807A497CA27C558C226EE5E24E3CA8DA66A74E71"
                        , "111D3A9A9AD293DF1D7D3B54D2807A7BF2CF2CB2"
                },
                {"B42C28861FB57657E27A1D41D3E61730FB0E55728443D1A18C27DE41"
                        ,"5DAC08ABDA44199E8058C6EC7CA27C558C226EE5E24E3CA8DA66A74E71"
                        , "111D3A9A9AD293D333370C9F1D7D3B54D2807A7BF2CF2CB2"
                }
        });
    }

    @Test
    public void main(){
        MyClass obj = new MyClass();
        String gen = "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000001";
        obj.rash = 191;
        boolean[] poly = obj.getBooleanArray(gen);
        obj.poly = poly;
        poly = obj.remove0(poly);
        obj.polyL = poly.length;
        boolean[] a = obj.getBooleanArray(this.valueA);
        boolean[] b = obj.getBooleanArray(this.valueB);
        boolean[] c = obj.getBooleanArray(this.valueC);
        boolean[] res_1 = obj.mul(obj.add(a,b),c);
        boolean[] res_2 = obj.add(obj.mul(a,c),obj.mul(b,c));
        assertArrayEquals(res_1,res_2);
    }
}