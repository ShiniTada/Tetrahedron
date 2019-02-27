package com.epam.task.entity;

import com.epam.task.actions.TetrahedronAction;
import com.epam.task.idgenerator.IdGenerator;
import com.epam.task.observer.Observer;
import com.epam.task.observer.Observable;
import com.epam.task.observer.impl.ObserverImpl;

import java.util.Arrays;
import java.util.List;

public class Tetrahedron implements Observable {

  private long id;
  private Point pointOne;
  private Point pointTwo;
  private Point pointThree;
  private Point pointFour;
  private double edge;

  Observer observer = new ObserverImpl("Masha");

  public Tetrahedron(long id, List<Point> points) {
    this.id = id;
    this.pointOne = points.get(0);
    this.pointTwo = points.get(1);
    this.pointThree = points.get(2);
    this.pointFour = points.get(3);
    edge = TetrahedronAction.calculateEdge(pointOne, pointTwo);

  }


  public static Tetrahedron createTetrahedron(List<Point> points) {
    return new Tetrahedron(IdGenerator.nextId(), points);
  }

  public Tetrahedron(long id, Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
    this.id = id;
    this.pointOne = pointOne;
    this.pointTwo = pointTwo;
    this.pointThree = pointThree;
    this.pointFour = pointFour;
    edge = TetrahedronAction.calculateEdge(pointOne, pointTwo);

  }

  public static Tetrahedron createTetrahedron(Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
    return new Tetrahedron(IdGenerator.nextId(), pointOne, pointTwo, pointThree, pointFour);
  }

  public void setPointOne(Point pointOne) {
    this.pointOne = pointOne;
    notifyObserver();
  }


  public void setPointTwo(Point pointTwo) {
    this.pointTwo = pointTwo;
    notifyObserver();
  }

  public void setPointThree(Point pointThree) {
    this.pointThree = pointThree;
    notifyObserver();
  }




  public void setPointFour(Point pointFour) {
    this.pointFour = pointFour;
    notifyObserver();
  }

  public void setEdge(double edge) {
    this.edge = edge;
    notifyObserver();
  }

  public long getId() {
    return id;
  }

  public Point getPointOne() {
    return pointOne;
  }

  public Point getPointTwo() {
    return pointTwo;
  }

  public Point getPointThree() {
    return pointThree;
  }

  public Point getPointFour() {
    return pointFour;
  }

  public List<Point> getAllPoints() {
    return Arrays.asList(pointOne, pointTwo, pointThree, pointFour);
  }

  public double getEdge() {
    return edge;
  }


  @Override
  public String toString() {
    return "Tetrahedron{" +
            "id=" + id +
            ", pointOne=" + pointOne +
            ", pointTwo=" + pointTwo +
            ", pointThree=" + pointThree +
            ", pointFour=" + pointFour +
            ", edge=" + edge +
            '}';
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Tetrahedron that = (Tetrahedron) obj;
    return id == that.id &&
            pointOne.equals(that.pointOne) &&
            pointTwo.equals(that.pointTwo) &&
            pointThree.equals(that.pointThree) &&
            pointFour.equals(that.pointFour);
  }

  @Override
  public int hashCode() {
    int hash = 1;
    int PRIME = 31;
    hash *= PRIME + pointOne.hashCode();
    hash *= PRIME + pointTwo.hashCode();
    hash *= PRIME + pointThree.hashCode();
    hash *= PRIME + pointFour.hashCode();
    hash *= PRIME +  Long.valueOf(id).hashCode();
    return hash;
  }

  @Override
  public void notifyObserver() {
    edge = TetrahedronAction.calculateEdge(pointOne, pointTwo);
    observer.update(this);
  }
}
