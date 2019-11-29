package com.nalyvaiko.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommentParser {

  private String fileName;

  public CommentParser(String fileName) {
    this.fileName = fileName;
  }

  public List<String> checkForComments() {
    String line;
    List<String> comments = new ArrayList<>();
    try (Reader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      while (bufferedReader.ready()) {
        line = bufferedReader.readLine();
        if (line.startsWith("//")) {
          comments.add(line.substring(2));
        }
      }

    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return comments;
  }
}
