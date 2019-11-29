package com.nalyvaiko.model;

import java.io.Serializable;

public class Fruit implements Serializable {

  private transient String color;
  private int weight;

  public Fruit(String color, int weight) {
    this.color = color;
    this.weight = weight;
  }

  public String getColor() {
    return color;
  }

  public int getWeight() {
    return weight;
  }

  @Override
  public String toString() {
    return "Color " + color + ", Weight " + weight;
  }
}
