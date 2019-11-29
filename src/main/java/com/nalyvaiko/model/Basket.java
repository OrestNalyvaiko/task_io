package com.nalyvaiko.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

  private List<Fruit> fruitList;

  public Basket() {
    fruitList = new ArrayList<>();
  }

  public List<Fruit> getFruitList() {
    return fruitList;
  }

  public void setFruitList(List<Fruit> fruitList) {
    this.fruitList = fruitList;
  }
}
