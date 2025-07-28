package com.example.betterreads.Connection;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;
@Data
@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {
    private File SecureConnectBundle;

}
