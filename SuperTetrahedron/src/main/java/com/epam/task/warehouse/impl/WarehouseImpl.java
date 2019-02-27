package com.epam.task.warehouse.impl;

import com.epam.task.entity.TetraWarehouseRecord;
import com.epam.task.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseImpl implements Warehouse {

  private static final WarehouseImpl INSTANCE = new WarehouseImpl();

  private  WarehouseImpl() {}

  public static WarehouseImpl getInstance() {
    return INSTANCE;
  }



  List<TetraWarehouseRecord> records = new ArrayList<>();

  @Override
  public void addRecord(TetraWarehouseRecord record) {
    records.add(record);
  }

  @Override
  public void removeRecord(TetraWarehouseRecord record) {
    records.remove(record);
  }

  @Override
  public void updateRecord(TetraWarehouseRecord record) {
    for (TetraWarehouseRecord recordPrev : records){
      if(recordPrev.getId() == record.getId()) {
        removeRecord(recordPrev);
        break;
      }
    }

    addRecord(record);
  }

  @Override
  public List<TetraWarehouseRecord> getAllRecords() {
    return records;
  }


}
