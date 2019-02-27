package com.epam.task.repository;

import com.epam.task.entity.Tetrahedron;

import java.util.Comparator;

public class TetraComparator {

 public final static Comparator<Tetrahedron> TetrahedronIdComparator = Comparator.comparing(Tetrahedron::getId);

 public final static Comparator<Tetrahedron> TetrahedronNameComparator = Comparator.comparing(Tetrahedron::toString);

 public final static Comparator<Tetrahedron> TetrahedronFirstXComparator = Comparator.comparing(t -> t.getPointOne().getX());

 public final static Comparator<Tetrahedron> TetrahedronFirstYComparator = Comparator.comparing(t -> t.getPointOne().getY());

 public final static Comparator<Tetrahedron> TetrahedronFirstZComparator = Comparator.comparing(t -> t.getPointOne().getZ());


}
