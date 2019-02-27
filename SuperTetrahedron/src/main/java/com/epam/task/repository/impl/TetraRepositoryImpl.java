package com.epam.task.repository.impl;

import com.epam.task.entity.Tetrahedron;
import com.epam.task.repository.TetraRepository;
import com.epam.task.repository.TetraSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TetraRepositoryImpl implements TetraRepository {
  List<Tetrahedron> tetras = new ArrayList<>();

  @Override
  public void addTetrahedron(Tetrahedron tetrahedron) {
    tetras.add(tetrahedron);
  }

  @Override
  public void removeTetrahedron(Tetrahedron tetrahedron) {
    tetras.remove(tetrahedron);
  }

  @Override
  public List<Tetrahedron> sortTetrahedron(Comparator<Tetrahedron> comparator){
    List<Tetrahedron> tetrahedrons = new ArrayList<>(tetras);
    tetrahedrons.sort(comparator);
    return  tetrahedrons;
  }

  @Override
  public List<Tetrahedron> query(TetraSpecification specification) {
    return tetras.stream()
            .filter(specification::specified)
            .collect(Collectors.toList());
  }

  @Override
  public Tetrahedron getTetrahedron(int index) {
    return tetras.get(index);
  }

  @Override
  public List<Tetrahedron> getAllTetrahedrons() {
    return tetras;
  }
}
