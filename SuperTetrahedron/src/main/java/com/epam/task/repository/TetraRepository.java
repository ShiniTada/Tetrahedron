package com.epam.task.repository;

import com.epam.task.entity.Tetrahedron;

import java.util.Comparator;
import java.util.List;

public interface TetraRepository {

  void addTetrahedron(Tetrahedron tetrahedron);

  void removeTetrahedron(Tetrahedron tetrahedron);

  List<Tetrahedron> sortTetrahedron(Comparator<Tetrahedron> comparator);

  List<Tetrahedron> query(TetraSpecification specification);

  Tetrahedron getTetrahedron(int index);

  List<Tetrahedron> getAllTetrahedrons();

}