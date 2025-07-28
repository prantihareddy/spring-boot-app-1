package com.example.betterreads;

import com.datastax.oss.driver.api.core.CqlSession;

import java.nio.file.Paths;

public class AstraTest {

    public static void main(String[] args) {
        try (CqlSession session = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get("src/main/resources/secure-connect-dataloader.zip"))
                .withAuthCredentials("token", "AstraCS:FKJxhllNLGGRFKGslbBorRhE:b23f78da1313f92068a7d0fc7dfd9da66b79431ad3e411603365f20728ec6e09")
                .withKeyspace("goodreadsdataloader")
                .build()) {
            System.out.println("Connected to Astra DB!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
