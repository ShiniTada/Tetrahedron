package com.epam.task.actions;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;
import com.epam.task.idgenerator.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetrahedronActionTest {

  TetrahedronAction action;
  private final static double DELTA = 0.01;

  @BeforeClass
  public void setUp() { action = new TetrahedronAction(); }

  private final static Tetrahedron TETRA = new Tetrahedron(
          IdGenerator.nextId(),
          new Point(0.577, 0, 1.634),
          new Point(0,-1, 0),
          new Point(1.732, 0, 0),
          new Point(0, 1, 0)
  );


  @Test
  public void testCalculateEdgeByPoints() {
    //given
    double expected = 8.0;
    //when
    double actual = action.calculateEdge( new Point(9,2, -2),  new Point(5,8.93, -2));
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }

  @Test
  public void testCalculateEdgeByTetrahedronObject() {
    //given
    double expected = 2.0;
    //when
    double actual = action.calculateEdge(TETRA);
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }

  @Test
  public void testCalculateSquareByEdge() {
    //given
    double expected = 6.93;
    //when
    double actual = action.calculateSquare(2.0);
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }

  @Test
  public void testCalculateSquareByTetrahedronObject() {
    //given
    double expected = 6.93;
    //when
    double actual = action.calculateSquare(TETRA);
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }

  @Test
  public void testCalculateVolumeByEdge() {
    //given
    double expected = 0.94;
    //when
    double actual = action.calculateVolume(2.0);
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }

  @Test
  public void testCalculateVolumeByTetrahedronObject() {
    //given
    double expected = 0.94;
    //when
    double actual = action.calculateVolume(TETRA);
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }

  @Test
  public void testCalculatePerimeterByEdge() {
    //given
    double expected = 48.0;
    //when
    double actual = action.calculatePerimeter(8.0);
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }

  @Test
  public void testCalculatePerimeterByTetrahedronObject() {
    //given
    double expected = 12.0;
    //when
    double actual = action.calculatePerimeter(TETRA);
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }
}