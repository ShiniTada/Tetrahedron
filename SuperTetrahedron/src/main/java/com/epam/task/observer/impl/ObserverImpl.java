package com.epam.task.observer.impl;

import com.epam.task.actions.TetrahedronAction;
import com.epam.task.entity.TetraWarehouseRecord;
import com.epam.task.entity.Tetrahedron;
import com.epam.task.observer.Observer;
import com.epam.task.warehouse.Warehouse;
import com.epam.task.warehouse.impl.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObserverImpl implements Observer {

  private static final Logger LOGGER = LogManager.getLogger(Observer.class);
  private String name;

  public ObserverImpl(String name) {
    this.name = name;
  }

  @Override
  public void update(Tetrahedron tetrahedron) {
    LOGGER.info("\n=======================================================================\n"
                               + name + ", we have some changes: " + tetrahedron
                     + "\n=======================================================================");

    TetrahedronAction action = new TetrahedronAction();
    long id = tetrahedron.getId();
    double square = action.calculateSquare(tetrahedron);
    double volume = action.calculateVolume(tetrahedron);
    double perimeter = action.calculatePerimeter(tetrahedron);

    Warehouse warehouse = WarehouseImpl.getInstance();
    warehouse.updateRecord(new TetraWarehouseRecord(id, square, volume, perimeter));

  }
}
