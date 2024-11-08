package com.example.demo.shop;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Date;

@Component
public class Cashier {
    @Value("checkout")
    private String fileName;

    @Value("/Users/jangjeonghun/cashier")
    private String path;

    private BufferedWriter bufferedWriter;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @PostConstruct
    public void openFile() throws IOException {
        File targetDir = new File(this.path);
        if(!targetDir.exists()) {
            targetDir.mkdir();
        }

        File checkoutFile = new File(this.path, this.fileName + ".txt");
        if(!checkoutFile.exists()) {
            checkoutFile.createNewFile();
        }

        this.bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(checkoutFile, true))
        );

        System.out.println("@PostConstruct 호출됨.");
    }

    public void checkout() throws IOException {
        this.bufferedWriter.write(new Date() + "\t");
        this.bufferedWriter.flush();
    }

    @PreDestroy
    public void closeFile() throws IOException {
        this.bufferedWriter.close();
        System.out.println("@PreDestroy 호출됨");
    }

}
