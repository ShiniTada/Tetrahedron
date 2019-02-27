package com.epam.task.warehouse;

import com.epam.task.entity.TetraWarehouseRecord;

import java.util.List;

public interface Warehouse {

  void addRecord(TetraWarehouseRecord record);

  void removeRecord(TetraWarehouseRecord record);

  void updateRecord(TetraWarehouseRecord record);

  List<TetraWarehouseRecord> getAllRecords();



}
