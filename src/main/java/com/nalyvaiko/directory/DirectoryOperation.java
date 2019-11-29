package com.nalyvaiko.directory;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class DirectoryOperation {

  private File file;

  public DirectoryOperation(String path) {
    this.file = new File(path);
  }

  public Map<String, String> directoryContent() {
    File[] files = file.listFiles();
    Map<String, String> directoryContent = new LinkedHashMap<>();
    if (!Objects.isNull(files)) {
      for (File file : files) {
        String name = file.getName();
        String attribute;
        if (file.isFile()) {
          attribute = "File";
        } else {
          attribute = "Path";
        }
        directoryContent.put(name, attribute);
      }
    }
    return directoryContent;
  }

  public void changeDirectory(String path) {
    file.renameTo(new File(path));
  }
}
