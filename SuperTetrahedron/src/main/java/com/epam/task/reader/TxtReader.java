package com.epam.task.reader;

import com.epam.task.exception.ReadDataException;

import java.util.List;

public interface TxtReader {
  public List<String> readDataTxt(String path) throws ReadDataException;

}
