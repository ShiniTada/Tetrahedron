package com.epam.task.repository;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;
import com.epam.task.repository.impl.TetraRepositoryImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TetraRepositoryQueryTest {

  TetraRepository repository;

  @BeforeTest
  public void setUp() {
    repository = new TetraRepositoryImpl();
    repository.addTetrahedron(ONE);
    repository.addTetrahedron(TWO);
    repository.addTetrahedron(THREE);
    repository.addTetrahedron(FOUR);
    repository.addTetrahedron(FIVE);
    repository.addTetrahedron(SIX);
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
  public void testQueryMinId() {
      //given
      SearchTetraSpecification specification = new SearchTetraSpecification();
      specification.setMinId(104);
      List<Tetrahedron> expected = Arrays.asList(FOUR, FIVE, SIX);
      //when
      List<Tetrahedron> actual = repository.query(specification.MORE_THEN_MIN_ID);
      //then
      Assert.assertEquals(actual, expected);
  }

  @Test
  public void testQueryMaxId() {
    //given
    SearchTetraSpecification specification = new SearchTetraSpecification();
    specification.setMaxId(104);
    List<Tetrahedron> expected = Arrays.asList(ONE, TWO, THREE, FOUR);
    //when
    List<Tetrahedron> actual = repository.query(specification.LESS_THEN_MAX_ID);
    //then
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testQueryMinSquare() {
    //given
    SearchTetraSpecification specification = new SearchTetraSpecification();
    specification.setMinSquare(60);
    List<Tetrahedron> expected = Arrays.asList(TWO, THREE, FIVE);
    //when
    List<Tetrahedron> actual = repository.query(specification.MORE_THEN_MIN_SQUARE);
    //then
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testQueryMinVolume() {
    //given
    SearchTetraSpecification specification = new SearchTetraSpecification();
    specification.setMinVolume(20);
    List<Tetrahedron> expected = Arrays.asList( TWO, THREE, FIVE);
    //when
    List<Tetrahedron> actual = repository.query(specification.MORE_THEN_MIN_VOLUME);
    //then
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testQueryMinEdge() {
    //given
    SearchTetraSpecification specification = new SearchTetraSpecification();
    specification.setMinEdge(3);
    List<Tetrahedron> expected = Arrays.asList(TWO, THREE, FOUR, FIVE);
    //when
    List<Tetrahedron> actual = repository.query(specification.MORE_THEN_MIN_EDGE);
    //then
    Assert.assertEquals(actual, expected);
  }

  @Test
  public void testQueryInTheFirstQuadrant() {
    //given
    SearchTetraSpecification specification = new SearchTetraSpecification();
    specification.setMinId(104);
    List<Tetrahedron> expected = Arrays.asList(SIX);
    //when
    List<Tetrahedron> actual = repository.query(specification.IN_THE_FIRST_QUADRANT);
    //then
    Assert.assertEquals(actual, expected);
  }

}