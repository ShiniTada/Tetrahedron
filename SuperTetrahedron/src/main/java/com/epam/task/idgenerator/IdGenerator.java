package com.epam.task.idgenerator;

public class IdGenerator {
  private static long id = 321;

  public static long nextId() { return id++; }
}