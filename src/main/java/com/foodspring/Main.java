package com.foodspring;

import com.foodspring.constant.EmailType;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Enum<EmailType>, String> test = new HashMap<>();
        test.put(EmailType.VER_NEW_TOKEN_EMAIL, "hei");
        System.out.println(test.get(EmailType.VER_NEW_TOKEN_EMAIL));
    }
}