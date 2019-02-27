package com.epam.task.creator;

import com.epam.task.entity.Point;
import com.epam.task.entity.TetraWarehouseRecord;
import com.epam.task.entity.Tetrahedron;
import com.epam.task.exception.IncorrectDataException;
import com.epam.task.exception.ReadDataException;
import com.epam.task.parser.DataParser;
import com.epam.task.parser.impl.DataParserImpl;
import com.epam.task.reader.TxtReader;
import com.epam.task.reader.impl.TxtReaderImpl;
import com.epam.task.repository.TetraRepository;
import com.epam.task.repository.impl.TetraRepositoryImpl;
import com.epam.task.validator.TetrahedronValidator;
import com.epam.task.validator.impl.TetrahedronValidatorImpl;
import com.epam.task.warehouse.Warehouse;
import com.epam.task.warehouse.impl.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Creator {
  private static final Logger LOGGER = LogManager.getLogger(Creator.class);

  private static final Creator INSTANCE = new Creator();

  private Creator() {}

  public static Creator getInstance() {
    return INSTANCE;
  }

  private TxtReader read = TxtReaderImpl.getInstance();
  private DataParser parser = DataParserImpl.getInstance();
  private TetrahedronValidator validator = TetrahedronValidatorImpl.getInstance();
  private Warehouse warehouse = WarehouseImpl.getInstance();
  private TetraRepository repository = new TetraRepositoryImpl();

  public List<Tetrahedron> createListOfTetrahedronsFromFile(String path) {
    List<String> strings = this.getDataFromFile(path);
    List<Tetrahedron> tetrahedrons = this.createListOfTetrahedronsFromStrings(strings);
    return tetrahedrons;
  }


  public List<String> getDataFromFile(String path) {
    try {
      List<String> strings = read.readDataTxt(path);
      return strings;
    } catch (ReadDataException e) {
      LOGGER.fatal(e);
      throw new RuntimeException(e);
    }
  }

  public List<Tetrahedron> createListOfTetrahedronsFromStrings(List<String> strings) {
    List<Point> pointList;
    Tetrahedron tetrahedron;
    List<Tetrahedron> tetrahedronList = new ArrayList<>();
    for (String string : strings) {
      try {
        pointList = parser.parse(string);
        if (validator.isTetrahedron(pointList)) {
          tetrahedron = Tetrahedron.createTetrahedron(pointList);
          tetrahedronList.add(tetrahedron);
          repository.addTetrahedron(tetrahedron);
        } else {
          LOGGER.warn("Tetrahedron with these points cannot exist:" + pointList);
        }
      } catch (IncorrectDataException e) {
        LOGGER.warn("Incorrect data:" + string);
      }
    }
    LOGGER.info("Tetrahedrons was created.");
    return tetrahedronList;
  }

  void addRecordToTheWarehouse(Tetrahedron tetrahedron){
    warehouse.addRecord(new TetraWarehouseRecord(tetrahedron));
  }
}

