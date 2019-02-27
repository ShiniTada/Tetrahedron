package com.epam.task.parser;

import com.epam.task.entity.Point;
import com.epam.task.exception.IncorrectDataException;

import java.util.List;

public interface DataParser {
  List<Point> parse(String string) throws IncorrectDataException;
}

