package com.foodspring.utils;
/*
IntelliJ IDEA 2022.2.2 (Community Edition)
Build #IC-222.4167.29, built on September 13, 2022
Runtime version: 17.0.4+7-b469.53 amd64
@Author hakim a.k.a. Hakim Amarullah
Java Developer
Created on 8/25/2023 2:12 PM
@Last Modified 8/25/2023 2:12 PM
Version 1.0
*/

import com.foodspring.exceptions.ResourceNotFoundException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ReadTextFileSB {
    private FileInputStream fInput;
    private BufferedInputStream bInput;
    private String[] exceptionString = new String[2];
    private String contentFile;
    private byte[] contentOfFile;
    private String filePath;

    public ReadTextFileSB(String pathFiles) throws ResourceNotFoundException {
        setContentFile(pathFiles);
    }


    public void setContentFile(String pathFile) throws ResourceNotFoundException {

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            inputStream = classLoader.getResourceAsStream(pathFile);

            if (inputStream == null) {
                throw new ResourceNotFoundException("Resource not found: " + pathFile);
            }

            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bdata = bufferedInputStream.readAllBytes();
            String data = new String(bdata, StandardCharsets.UTF_8);
            this.contentOfFile = bdata;
            this.contentFile = new String(contentOfFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ResourceNotFoundException(e.getMessage());
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new ResourceNotFoundException(e.getMessage());
            }
        }
    }


    public String getContentFile() {
        return contentFile;
    }

    public byte[] getByteOfFile() {
        return contentOfFile;
    }

}

