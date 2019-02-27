package com.epam.task.warehouse.impl;

import com.epam.task.entity.Point;
import com.epam.task.entity.TetraWarehouseRecord;
import com.epam.task.entity.Tetrahedron;
import com.epam.task.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WarehouseImplTest {
  Warehouse warehouse;

  @BeforeTest
  public void setUp() {
    warehouse = WarehouseImpl.getInstance();
    warehouse.addRecord(new TetraWarehouseRecord(ONE));
    warehouse.addRecord(new TetraWarehouseRecord(TWO));
    warehouse.addRecord(new TetraWarehouseRecord(THREE));
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


  @Test
  public void testUpdateRecord() {
    //given
    List<TetraWarehouseRecord> expected = new ArrayList<>();
    TetraWarehouseRecord changedRecord = new TetraWarehouseRecord(new Tetrahedron(101,
                                                              new Point(0, -5, 0),
                                                              new Point(0,-1, 0),
                                                              new Point(1.732, 0, 0),
                                                              new Point(0, 1, 0)));
    expected.add(new TetraWarehouseRecord(TWO));
    expected.add(new TetraWarehouseRecord(THREE));
    expected.add(changedRecord);
    //when

    ONE.setPointOne(new Point(0,-5,0));
    List<TetraWarehouseRecord> actual =  warehouse.getAllRecords();
    //then
    Assert.assertEquals(actual ,expected);

  }
}