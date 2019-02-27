package com.epam.task.creator;

import com.epam.task.entity.Point;
import com.epam.task.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
public class CreatorTest {

  @Test
  public void testCreateTetrahedrons() {
    //when
    Creator creator = Creator.getInstance();
    List<Tetrahedron> actual = creator.createListOfTetrahedronsFromFile("src\\main\\resources\\shortData.txt");
    List<Long> IDs = new ArrayList<>();
    for(Tetrahedron tetra : actual){
      IDs.add(tetra.getId());
    }
    //given
    List<Tetrahedron> expected = new ArrayList<>();
    Tetrahedron tetrahedronOne = new Tetrahedron( IDs.get(0),
                                                  new Point(0.577, 0, 1.634),
                                                  new Point(0,-1, 0),
                                                  new Point(1.732, 0, 0),
                                                  new Point(0, 1, 0));
    expected.add(tetrahedronOne);

    Tetrahedron tetrahedronTwo =  new Tetrahedron( IDs.get(1),
                                                   new Point(0.577, 0, 1.634),
                                                   new Point(0,-1, 0),
                                                   new Point(1.732, 0, 0),
                                                   new Point(0, 1, 0));
    expected.add(tetrahedronTwo);

    //then
    Assert.assertEquals(actual, expected);
  }
}