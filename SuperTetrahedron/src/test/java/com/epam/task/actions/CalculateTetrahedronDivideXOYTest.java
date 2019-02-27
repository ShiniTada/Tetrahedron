package com.epam.task.actions;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;
import com.epam.task.idgenerator.IdGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculateTetrahedronDivideXOYTest {

  CalculateTetrahedronDivideXOY calculator;
  private final static double DELTA = 0.02;

  @BeforeClass
  public void setUp() { calculator = new CalculateTetrahedronDivideXOY(); }


  private final static Tetrahedron TETRAHEDRON_NOT_INTERACTION_XOY = new Tetrahedron(
          IdGenerator.nextId(),
          new Point(1,2,2),
          new Point(5,8,5),
          new Point(3,2,4),
          new Point(1,2,7));
  private final static Tetrahedron TETRAHEDRON_INTERACTION_XOY = new Tetrahedron(
          IdGenerator.nextId(),
          new Point(1, 2, -2),
          new Point(9, 2, -2),
          new Point(5, 8.93, -2),
          new Point(5,  4.31,4.532));

  @Test
  public void isNotInteractionXOZ(){
    //when
    boolean actual= calculator.isInteractionXOY(TETRAHEDRON_NOT_INTERACTION_XOY);
    //then
    Assert.assertFalse(actual);
  }



  @Test
  public void testCalculateRatioVolumes() {
    //given
    double expected = 0.5;
    //when
    double actual = calculator.calculateRatioVolumes(TETRAHEDRON_INTERACTION_XOY);
    //then
    Assert.assertEquals(actual, expected, DELTA);


  }
}