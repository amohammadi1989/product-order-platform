package com.clone;

import java.net.InetAddress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {

  private static String getHostAddress() {
    try {
      return InetAddress.getLocalHost().getHostAddress();
    } catch (Exception ex) {
      return "";
    }
  }

  public static void main(String[] args) {

    SpringApplication.run(OrderApplication.class, args);
  }
}
