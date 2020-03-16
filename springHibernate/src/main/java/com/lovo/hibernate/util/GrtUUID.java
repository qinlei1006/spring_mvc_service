package com.lovo.hibernate.util;


import java.util.UUID;

public class GrtUUID {
    public static void main(String[] args) {
        for (int i =0 ;i< 10;i++){
//            得到员工uuid
            String str = UUID.randomUUID().toString();
            System.out.println(str);
//            去掉横杆
            System.out.println(str.replaceAll("-",""));
        }
    }
}
