package com.epam.task.actions;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.List;

public class CalculateTetrahedronDivideXOZ {

  private static final TetrahedronAction CALCULATOR = new TetrahedronAction();

  public boolean isInteractionXOZ(Tetrahedron tetrahedron){
    return !(isAllNegativeY(tetrahedron.getAllPoints()) || isAllPositiveY(tetrahedron.getAllPoints()));
  }

  private boolean isAllPositiveY(List<Point> points){
    for(Point point : points){
      if(point.getY() < 0){
        return false;
      }
    }
    return  true;
  }
  private boolean isAllNegativeY(List<Point> points){
    for(Point point : points){
      if(point.getY()> 0){
        return false;}
    }
    return  true;
  }

  private Point getTetrahedronTop(Tetrahedron tetrahedron) {
    List<Point> positiveY = new ArrayList<>();
    List<Point> negativeY = new ArrayList<>();
    for (Point point : tetrahedron.getAllPoints()) {
      if (point.getY() >= 0) {
        positiveY.add(point);
      } else {
        negativeY.add(point);
      }
    }
    if(positiveY.size()==1) {
      return positiveY.get(0);
    }else{
      return negativeY.get(0);
    }
  }
  public double calculateRatioVolumes(Tetrahedron tetrahedron){
    if(this.isInteractionXOZ(tetrahedron)) {
      Point topOfTetrahedron = getTetrahedronTop(tetrahedron);
      double bigEdge = CALCULATOR.calculateEdge(tetrahedron);
      double bigHeight = CALCULATOR.calculateHeight(tetrahedron);
      double smallEdge = (bigEdge * topOfTetrahedron.getY()) / bigHeight;
      double bigTetrahedronVolume = CALCULATOR.calculateVolume(bigEdge);
      double smallTetrahedronVolume = CALCULATOR.calculateVolume(smallEdge);
      return smallTetrahedronVolume / (bigTetrahedronVolume - smallTetrahedronVolume);
    }
    else return 0.;
  }

}