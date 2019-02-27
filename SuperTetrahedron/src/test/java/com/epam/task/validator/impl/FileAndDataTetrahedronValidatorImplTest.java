package com.epam.task.validator.impl;


import com.epam.task.entity.Point;
import com.epam.task.validator.TetrahedronValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FileAndDataTetrahedronValidatorImplTest {

    private final static List<Point> LIST_ONE = Arrays.asList(
            new Point(1, -2, 2),
            new Point(9, -2, 2),
            new Point(5, -2, 8.928),
            new Point(5, 4.532,4.31));

    private final static List<Point> LIST_TWO = Arrays.asList(
            new Point(0.77, 6, 1.34),
            new Point(0,-6, 0),
            new Point(1.732, 0, 3),
            new Point(0, 2, 1));

    private final static List<Point> LIST_THREE = Arrays.asList(
            new Point(0, 0, 1.634),
            new Point(0,-1, 0),
            new Point(1.732, 0, 0),
            new Point(0, 1, 0));

    @DataProvider(name = "dataForValidationExistence")
    public Object[][] initData() {
      return new Object[][]{
              {true, LIST_ONE},
              {false, LIST_TWO},
              {true, LIST_THREE},
      };
    }


    @Test(dataProvider = "dataForValidationExistence")
    public void testIsTetrahedron(boolean expected, List<Point> tetrahedrons) {
      //when
      TetrahedronValidator validator = TetrahedronValidatorImpl.getInstance();
      boolean actual = validator.isTetrahedron(tetrahedrons);
      //then
      Assert.assertEquals(actual, expected);
    }
}

