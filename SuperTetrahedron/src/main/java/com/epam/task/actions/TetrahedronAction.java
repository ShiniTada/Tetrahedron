package com.epam.task.actions;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;

public class TetrahedronAction {


  public static double calculateEdge(Point first, Point second){
    return Math.sqrt(Math.pow(first.getX()-second.getX(),2) +
            Math.pow(first.getY()-second.getY(),2) +
            Math.pow(first.getZ()-second.getZ(),2));
  }

  public static double calculateEdge(Tetrahedron tetrahedron){
    Point first = tetrahedron.getPointOne();
    Point second = tetrahedron.getPointTwo();
    return Math.sqrt(Math.pow(first.getX()-second.getX(),2) +
            Math.pow(first.getY()-second.getY(),2) +
            Math.pow(first.getZ()-second.getZ(),2));
  }


  public double calculateSquare(Tetrahedron tetrahedron){
    double edge = tetrahedron.getEdge();
    return Math.sqrt(3)*Math.pow(edge,2);
  }

  public double  calculateSquare(double edge ){
    return Math.sqrt(3)*Math.pow(edge,2);
  }

  public double calculateVolume(Tetrahedron tetrahedron){
    double edge = tetrahedron.getEdge();
    return Math.sqrt(2)/12*Math.pow(edge,3);
  }

  public double calculateVolume(double edge ){
    return Math.sqrt(2)/12*Math.pow(edge,3);
  }

  public static double calculateHeight(Tetrahedron tetrahedron){
    double edge = tetrahedron.getEdge();
    double TwoOnThree = 0.6666666667;
    double height = Math.sqrt(TwoOnThree)*edge;
    return  height;
  }

  public double calculatePerimeter(Tetrahedron tetrahedron){
    double edge = tetrahedron.getEdge();
    return edge*6;
  }

  public double calculatePerimeter(double edge){
    return edge*6;
  }
}
