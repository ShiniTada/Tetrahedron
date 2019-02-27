package com.epam.task.validator.impl;

import com.epam.task.actions.TetrahedronAction;
import com.epam.task.entity.Point;
import com.epam.task.validator.TetrahedronValidator;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronValidatorImpl implements TetrahedronValidator {

  public static final double PRESISION = 0.2;

  private static final TetrahedronValidatorImpl INSTANCE = new TetrahedronValidatorImpl();

  private TetrahedronValidatorImpl() {}

  public static TetrahedronValidatorImpl getInstance() {
    return INSTANCE;
  }



  public boolean isTetrahedron(List<Point> points){
    TetrahedronAction action = new TetrahedronAction();
    Double edge;
    List<Double> allEdges = new ArrayList<>();
    for(int i = 0; i < points.size(); i++){
      for(int j = 1; j < points.size(); j++){
        if( i>= j){
          continue;
        }
        edge = action.calculateEdge(points.get(i), points.get(j));
        allEdges.add(edge);
      }
    }
    return this.isAllEdgesAreEquals(allEdges);
  }

  public boolean isAllEdgesAreEquals(List<Double> allEdges){
    for(int i = 0; i < allEdges.size(); i++) {
      for (int j = 1; j < allEdges.size(); j++) {
        if (i >= j) {
          continue;
        }
        if(allEdges.get(0) - allEdges.get(j) >= PRESISION){
          return false;
        }
      }
    }
    return true;
  }
}
