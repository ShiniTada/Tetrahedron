package com.epam.task.repository;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;
import com.epam.task.repository.impl.TetraRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TetraRepositoryImplTest {
  TetraRepository repository;

  @BeforeTest
  public void setUp() {
    repository = new TetraRepositoryImpl();
    repository.addTetrahedron(ONE);
    repository.addTetrahedron(TWO);
    repository.addTetrahedron(THREE);
    repository.addTetrahedron(FOUR);
    repository.addTetrahedron(FIVE);
  }

  private final static Tetrahedron ONE = new Tetrahedron(
          101,
          new Point(0.577, 0, 1.634),
          new Point(0,-1, 0),
          new Point(1.732, 0, 0),
          new Point(0, 1, 0));


  private final static Tetrahedron TWO = new Tetrahedron(
          102,
          new Point(-2, 1, 2),
          new Point(-2, 9, 2),
          new Point(-2, 5, 8.928),
          new Point(4.532, 5,4.31));

  private final static Tetrahedron THREE = new Tetrahedron(
          103,
          new Point(1, 2, -2),
          new Point(9, 2, -2),
          new Point(5, 8.93, -2),
          new Point(5,  4.31,4.532));

  private final static Tetrahedron FOUR = new Tetrahedron(
          104,
          new Point(2.82,1.66,0),
          new Point(-2.15,0.41,0),
          new Point(0.7,-0.4, 4.19),
          new Point(1.42,-3.27,0)
  );

  private final static Tetrahedron FIVE = new Tetrahedron(
          105,
          new Point(-2.83,0.96,0),
          new Point(1.42,-3.27,0),
          new Point(1.3,1.57,0),
          new Point(-0.04,-0.89, 3.95)
  );

  private final static Tetrahedron SIX = new Tetrahedron(
          106,
          new Point(0.36,1.25,0),
          new Point(2.18,0.83,0),
          new Point(1.64,2.62,0),
          new Point(1.4,1.57, 1.53)
  );

  @Test
  public void tesAddTetrahedron() {
    //given
    List<Tetrahedron> expected = Arrays.asList(ONE, TWO, THREE, FOUR, FIVE, SIX);
    //when
    repository.addTetrahedron(SIX);
    List<Tetrahedron> actual = repository.getAllTetrahedrons();
    //then
    Assert.assertEquals(actual ,expected);
  }

  @Test
  public void testRemoveTetrahedron() {
    //given
    List<Tetrahedron> expected = Arrays.asList(ONE, TWO, FOUR, FIVE);
    //when
    repository.removeTetrahedron(THREE);
    repository.removeTetrahedron(SIX);
    List<Tetrahedron> actual = repository.getAllTetrahedrons();
    //then
    Assert.assertEquals(actual ,expected);
  }

  @Test(description = "update first point in first tetrahedron in repository")
  public void testUpdateTetrahedron() {
    //when
    ONE.setPointOne(new Point(0,0,0));
    Tetrahedron actual = repository.getTetrahedron(0);
    //then
    Assert.assertEquals(actual, ONE);
  }
}