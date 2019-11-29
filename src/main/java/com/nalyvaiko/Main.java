package com.nalyvaiko;

import com.nalyvaiko.directory.DirectoryOperation;
import com.nalyvaiko.model.Basket;
import com.nalyvaiko.model.Fruit;
import com.nalyvaiko.parser.CommentParser;
import com.nalyvaiko.performance.WritingReadingFilePerformance;
import com.nalyvaiko.serialization.Serialization;

public class Main {

  public static void main(String[] args) {
    testSerialization();
    testPerformance();
    testCommentsCheck(args[0]);
    displayDirectoryContent();
    changeDirectory();
  }

  public static void testSerialization() {
    Basket basket = new Basket();
    basket.getFruitList().add(new Fruit("Red", 20));
    basket.getFruitList().add(new Fruit("Yellow", 25));
    Serialization serialization = new Serialization("serialize.txt");
    serialization.serialize(basket.getFruitList());
    basket.getFruitList().add(new Fruit("Green", 30));
    basket.setFruitList(serialization.deserialize());
    basket.getFruitList().forEach(System.out::println);
  }

  public static void testPerformance() {
    WritingReadingFilePerformance writingReadingFilePerformance = new WritingReadingFilePerformance(
        "performanceFile.txt");
    writingReadingFilePerformance.performanceReadingFileWithoutBuffer();
    writingReadingFilePerformance.performanceReadingFileWithBuffer();
    writingReadingFilePerformance.performancWritingFileWithoutBuffer();
    writingReadingFilePerformance.performancWritingFileWithBuffer();
  }

  public static void testCommentsCheck(String args) {
    CommentParser commentParser = new CommentParser(args);
    commentParser.checkForComments().forEach(System.out::println);
  }

  public static void displayDirectoryContent() {
    DirectoryOperation directoryOperation = new DirectoryOperation(
        "D:\\EPAM\\Projects\\task_io_nio\\src\\main\\java\\com\\nalyvaiko");
    directoryOperation.directoryContent()
        .forEach((key, value) -> System.out.println(key + " " + value));
  }

  public static void changeDirectory() {
    DirectoryOperation directoryOperation = new DirectoryOperation(
        "D:\\EPAM\\Projects\\task_io_nio\\src\\main\\java\\com\\nalyvaiko");
    directoryOperation.directoryContent()
        .forEach((key, value) -> System.out.println(key + " " + value));
    directoryOperation.changeDirectory(
        "D:\\EPAM\\Projects\\task_io_nio\\src\\main\\java\\com\\nalyvaiko\\directory");
    directoryOperation.directoryContent()
        .forEach((key, value) -> System.out.println(key + " " + value));
  }
}
