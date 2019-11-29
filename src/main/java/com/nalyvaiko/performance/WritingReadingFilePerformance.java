package com.nalyvaiko.performance;

import java.io.*;
import java.time.LocalDateTime;

public class WritingReadingFilePerformance {
    private String fileName;

    public WritingReadingFilePerformance(String fileName) {
        this.fileName = fileName;
    }

    public void performanceReadingFileWithoutBuffer() {
        try (InputStream inputStream = new FileInputStream(fileName)) {
            System.out.println("Time of start reading 10MB file without buffer "
                + LocalDateTime.now());
            int data = inputStream.read();
            while (data != -1) {
                data = inputStream.read();
            }
            System.out.println(
                "Time of end reading 10MB file without buffer " + LocalDateTime
                    .now() + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void performanceReadingFileWithBuffer() {
        try (InputStream inputStream = new FileInputStream(fileName);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            System.out.println("Time of start reading 10MB file with buffer " + LocalDateTime.now());
            int data = bufferedInputStream.read();
            while (data != -1) {
                data = bufferedInputStream.read();
            }
            System.out.println("Time of end reading 10MB file with buffer " + LocalDateTime.now());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void performancWritingFileWithoutBuffer() {
        try (OutputStream outputStream = new FileOutputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            System.out.println("Time of start writing in file without buffer " + LocalDateTime.now());
            for(int i = 0; i < 500000; i++){
                dataOutputStream.writeUTF("Orest Nalyvaiko");
            }
            System.out.println("Time of end writing in file without buffer " + LocalDateTime.now());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void performancWritingFileWithBuffer() {
        try (OutputStream outputStream = new FileOutputStream(fileName);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
             DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)) {
            System.out.println("Time of start writing in file with buffer " + LocalDateTime.now());
            for(int i = 0; i < 500000; i++){
                dataOutputStream.writeUTF("Orest Nalyvaiko");
            }
            System.out.println("Time of end writing in file with buffer " + LocalDateTime.now());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
