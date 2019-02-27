package com.epam.task.entity;

import com.epam.task.actions.TetrahedronAction;

public class TetraWarehouseRecord {
  private long id;
  private double square;
  private double volume;
  private double perimeter;

  public TetraWarehouseRecord(long id, double square, double volume, double perimeter) {
    this.id = id;
    this.square = square;
    this.volume = volume;
    this.perimeter = perimeter;
  }

  public TetraWarehouseRecord (Tetrahedron tetrahedron){
    TetrahedronAction action = new TetrahedronAction();
    this.id = tetrahedron.getId();
    this.square = action.calculateSquare(tetrahedron);
    this.volume = action.calculateVolume(tetrahedron);
    this.perimeter = action.calculatePerimeter(tetrahedron);
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setSquare(double square) {
    this.square = square;
  }

  public void setVolume(double volume) {
    this.volume = volume;
  }

  public void setPerimeter(double perimeter) {
    this.perimeter = perimeter;
  }

  public long getId() {
    return id;
  }

  public double getSquare() {
    return square;
  }

  public double getVolume() {
    return volume;
  }

  public double getPerimeter() {
    return perimeter;
  }


  @Override
  public String toString() {
    return "TetraWarehouseRecord{" +
            "id=" + id +
            ", square=" + square +
            ", volume=" + volume +
            ", perimeter=" + perimeter +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TetraWarehouseRecord that = (TetraWarehouseRecord) o;
    return  Double.compare(that.square, square) == 0 &&
            Double.compare(that.volume, volume) == 0 &&
            Double.compare(that.perimeter, perimeter) == 0;
  }

  @Override
  public int hashCode() {
    int hash = 1;
    int PRIME = 31;
    hash *= PRIME + Double.valueOf(square);
    hash *= PRIME + Double.valueOf(volume);
    hash *= PRIME + Double.valueOf(perimeter);
    return hash;
  }

}
