package com.nalyvaiko.serialization;

import com.nalyvaiko.model.Fruit;

import java.io.*;
import java.util.List;

public class Serialization {

  private String fileName;

  public Serialization(String fileName) {
    this.fileName = fileName;
  }

  public void serialize(List<Fruit> fruitList) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            fileOutputStream)) {
      objectOutputStream.writeObject(fruitList);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public List<Fruit> deserialize() {
    try (FileInputStream fileInputStreamStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(
            fileInputStreamStream)) {
      return (List<Fruit>) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException ex) {
      ex.printStackTrace();
      return null;
    }
  }
}
