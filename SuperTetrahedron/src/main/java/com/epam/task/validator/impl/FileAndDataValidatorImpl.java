package com.epam.task.validator.impl;

import com.epam.task.validator.FileAndDataValidator;

import java.io.File;

public class FileAndDataValidatorImpl implements FileAndDataValidator {

  private static final String NORMAL_STRING = "\\s*((-?\\d+(.\\d+)?\\s+){2}(-?\\d+(.\\d+)?;\\s*)){4}";

  private static final FileAndDataValidatorImpl INSTANCE = new FileAndDataValidatorImpl();

  private FileAndDataValidatorImpl() {}

  public static FileAndDataValidatorImpl getInstance() {
    return INSTANCE;
  }


  public boolean checkData(String string) {
    return string.matches(NORMAL_STRING);
  }


  public boolean checkFile(File file){
    if(file == null || !file.exists() || file.isDirectory() || file.length() == 0 ) {
      return false;
    }
    return true;
  }
}
