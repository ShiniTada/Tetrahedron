package com.epam.task.parser.impl;

import com.epam.task.entity.Point;
import com.epam.task.exception.IncorrectDataException;
import com.epam.task.parser.DataParser;
import com.epam.task.validator.FileAndDataValidator;
import com.epam.task.validator.impl.FileAndDataValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataParserImpl implements DataParser {

  private static final Logger LOGGER = LogManager.getLogger(DataParserImpl.class);
  private static final String SEPARATOR_FOR_POINTS = ";\\s+|;";
  private static final String SEPARATOR_FOR_COORDINATES = "\\s+";

  private static final DataParserImpl INSTANCE = new DataParserImpl();

  private DataParserImpl() {}

  public static DataParserImpl getInstance() {
    return INSTANCE;
  }


  public List<Point> parse(String string) throws IncorrectDataException {
    FileAndDataValidator fileAndDataValidator = FileAndDataValidatorImpl.getInstance();
    boolean resultValidator = fileAndDataValidator.checkData(string);
    try {
      if (resultValidator) {
        List<Point> listPoints = parseToPointList(string);
        LOGGER.info("Parse was successful complete");
        return listPoints;
      } else {
        LOGGER.warn("Incorrect input data:" + string);
        throw new IncorrectDataException("Incorrect input data:" + string);
      }
    } catch (IncorrectDataException e) {
      throw e;
    }
  }

  private List<Point> parseToPointList(String string){
    List<Point> pointList = new ArrayList<>();
    List<String> pointsInStrings = Arrays.asList(string.split(SEPARATOR_FOR_POINTS));
    List<Double> coordinatesList;
    for(String pointInString : pointsInStrings){
      coordinatesList = new ArrayList<>();
      for(String dot : pointInString.split(SEPARATOR_FOR_COORDINATES)){
        coordinatesList.add(Double.parseDouble(dot));
      }
      pointList.add(new Point(coordinatesList));
      coordinatesList.clear();
    }
    return pointList;
  }
}
