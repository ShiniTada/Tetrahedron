package com.epam.task.actions;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;
import com.epam.task.idgenerator.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateTetrahedronDivideXOZTest {

  CalculateTetrahedronDivideXOZ calculator;
  private final static double DELTA = 0.02;

  @BeforeClass
  public void setUp() { calculator = new CalculateTetrahedronDivideXOZ(); }


  private final static Tetrahedron TETRAHEDRON_NOT_INTERACTION_XOZ = new Tetrahedron(
          IdGenerator.nextId(),
          new Point(1,2,2),
          new Point(5,2,5),
          new Point(3,4,4),
          new Point(1,2,7));
  private final static Tetrahedron TETRAHEDRON_INTERACTION_XOZ = new Tetrahedron(
          IdGenerator.nextId(),
          new Point(1, -2, 2),
          new Point(9, -2, 2),
          new Point(5, -2, 8.928),
          new Point(5, 4.532,4.31));

  @Test
  public void isNotInteractionXOZ(){
    //when
    boolean actual= calculator.isInteractionXOZ(TETRAHEDRON_NOT_INTERACTION_XOZ);
    //then
    Assert.assertFalse(actual);
  }

  @Test
  public void testCalculateRatioVolumes() {
    //given
    double expected = 0.5;
    //when
    double actual = calculator.calculateRatioVolumes(TETRAHEDRON_INTERACTION_XOZ);
    //then
    Assert.assertEquals(actual, expected, DELTA);
  }
}