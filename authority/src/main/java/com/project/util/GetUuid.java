package com.project.util;


import java.util.UUID;

public class GetUuid {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
