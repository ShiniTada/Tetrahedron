package com.epam.task.entity;

import java.util.List;

public class Point {
  private double x;
  private double y;
  private double z;


  public Point(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  public Point(List<Double> coordinates) {
    this.x = coordinates.get(0);
    this.y = coordinates.get(1);
    this.z= coordinates.get(2);
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void setZ(double z) {
    this.z = z;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getZ() {
    return z;
  }

  @Override
  public String toString() {
    return "Point{" +
            "x=" + x +
            ", y=" + y +
            ", z=" + z +
            '}';
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Point point = (Point) other;
    return x == point.x &&
            y == point.y &&
            z == point.z;
  }
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int hash = 1;
    hash *= PRIME +  Double.valueOf(x).hashCode();
    hash *= PRIME +  Double.valueOf(y).hashCode();
    hash *= PRIME +  Double.valueOf(z).hashCode();
    return hash;
  }

}


