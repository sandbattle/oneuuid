package com.sandbattle.oneuuid;

import java.io.IOException;
import java.util.UUID;

public class __OneUUIDTesting {
    public static void main(String[] args) throws IOException {
        System.out.println(OneUUID.fromString("a190fd62-60bd-4b7c-a60b-5d41b62fe5e6"));
        System.out.println(OneUUID.fromUUID(UUID.fromString("a190fd62-60bd-4b7c-a60b-5d41b62fe5e6")));
        System.out.println(OneUUID.fromString("a190fd6260bd4b7ca60b5d41b62fe5e6"));
        System.out.println(OneUUID.fromString("a190fd6260bd4b7ca60b5d41b62fe5e6"));
        System.out.println("Player: " + OneUUID.fromPlayerName("wwwdotanna").toString());
    }
}