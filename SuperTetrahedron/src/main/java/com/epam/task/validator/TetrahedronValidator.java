package com.epam.task.validator;

import com.epam.task.entity.Point;

import java.util.List;

public interface TetrahedronValidator {

  boolean isTetrahedron(List<Point> points);

  boolean isAllEdgesAreEquals(List<Double> allEdges);
}
