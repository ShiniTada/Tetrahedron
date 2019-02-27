package com.epam.task.actions;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class CalculateTetrahedronDivideYOZ {
  private static final TetrahedronAction CALCULATOR = new TetrahedronAction();

  public boolean isInteractionYOZ(Tetrahedron tetrahedron){
    return !(isAllNegativeX(tetrahedron.getAllPoints()) || isAllPositiveX(tetrahedron.getAllPoints()));
  }

  private boolean isAllPositiveX(List<Point> points){
    for(Point point : points){
      if(point.getX() < 0){
        return false;
      }
    }
    return  true;
  }
  private boolean isAllNegativeX(List<Point> points){
    for(Point point : points){
      if(point.getX()> 0){
        return false;}
    }
    return  true;
  }

  private Point getTetrahedronTop(Tetrahedron tetrahedron) {
    List<Point> positiveX = new ArrayList<>();
    List<Point> negativeX = new ArrayList<>();
    for (Point point : tetrahedron.getAllPoints()) {
      if (point.getX() >= 0) {
        positiveX.add(point);
      } else {
        negativeX.add(point);
      }
    }
    if(positiveX.size()==1) {
      return positiveX.get(0);
    }else{
      return negativeX.get(0);
    }
  }
  public double calculateRatioVolumes(Tetrahedron tetrahedron){
    if(this.isInteractionYOZ(tetrahedron)) {
      Point topOfTetrahedron = getTetrahedronTop(tetrahedron);
      double bigEdge = CALCULATOR.calculateEdge(tetrahedron);
      double bigHeight = CALCULATOR.calculateHeight(tetrahedron);
      double smallEdge = (bigEdge * topOfTetrahedron.getX()) / bigHeight;
      double bigTetrahedronVolume = CALCULATOR.calculateVolume(bigEdge);
      double smallTetrahedronVolume = CALCULATOR.calculateVolume(smallEdge);
      return smallTetrahedronVolume / (bigTetrahedronVolume - smallTetrahedronVolume);
    }
    else return 0.;
  }
}
