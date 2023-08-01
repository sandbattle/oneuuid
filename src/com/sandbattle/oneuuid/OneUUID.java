package com.sandbattle.oneuuid;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class OneUUID {
    public static HashMap<String, OneUUID> raw_map = new HashMap<>();

    public static OneUUID fromString(String string) {
        string = string.toLowerCase().replaceAll("-", "");
        System.out.println(string + " -> " + string.hashCode());
        if(!raw_map.containsKey(string)) return _generate(string);
        return raw_map.get(string);
    }

    public static OneUUID fromUUID(UUID uuid) {
        return fromString(uuid.toString());
    }
    public static OneUUID fromPlayerName(String playerName) throws IOException {
        URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + playerName);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        StringBuilder response = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) response.append(line);
        JsonObject responseJsonObj = JsonParser.parseString(response.toString()).getAsJsonObject();
        if(responseJsonObj.get("id") != null) {
            return fromString(responseJsonObj.get("id").getAsString());
        } else {
            return null;
        }
    }
    public static OneUUID fromIntegration(String type, String name) throws IOException {
        URL url = new URL("https://api.sandbattle.com/players?from=" + type + "&name=" + URLEncoder.encode(name, "utf-8"));
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        StringBuilder response = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) response.append(line);
        JsonObject responseJsonObj = JsonParser.parseString(response.toString()).getAsJsonObject();
        if(responseJsonObj.get("result") != null && responseJsonObj.get("result").getAsString().equalsIgnoreCase("false")) {
            return fromString(responseJsonObj.getAsJsonObject("result").get("minecraft").getAsString());
        } else {
            return null;
        }
    }
    public static OneUUID fromDiscord(String discordName) throws IOException {
        return fromIntegration("discord", discordName);
    }
    public static OneUUID fromForumName(String forumName) throws IOException {
        return fromIntegration("forum", forumName);
    }

    protected static OneUUID _generate(String inspiration) {
        String string = inspiration.toLowerCase().replaceAll("-", "");
        OneUUID oU = new OneUUID(string);
        raw_map.put(string, oU);
        return oU;
    }

    public String string;
    private OneUUID(String string) {
        this.string = string;
    }
}