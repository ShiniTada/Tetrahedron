package com.epam.task.parser.impl;

import com.epam.task.entity.Point;
import com.epam.task.exception.IncorrectDataException;
import com.epam.task.parser.DataParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserImplTest {

  DataParser parser;

  @BeforeTest
  public void setUp() {
    parser = DataParserImpl.getInstance();
  }

  @Test(description = "data is valid")
  public void testParseCorrectData() throws IncorrectDataException {
    //given
    List<Point> expected = new ArrayList<>();
    expected.add(new Point(1,2, -2));
    expected.add(new Point(9,2, -2));
    expected.add(new Point(5,8.93, -2));
    expected.add(new Point(5,4.31, 4.532));
    //when
    List<Point> actual = parser.parse( "1 2 -2; 9 2 -2; 5 8.93 -2; 5 4.31 4.532;");
    //then
    Assert.assertEquals(actual,expected);
  }

  @Test(description = "data is incorrect", expectedExceptions =  IncorrectDataException.class)
  public void testParseIncorrectData() throws IncorrectDataException {
    List<Point> actual = parser.parse( "0.577 0 1.634wwe; 0 -1 0; 1.732 0 0; 0 1 0");

  }
}