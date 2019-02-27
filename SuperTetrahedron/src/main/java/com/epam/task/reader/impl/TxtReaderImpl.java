package com.epam.task.reader.impl;

import com.epam.task.exception.ReadDataException;
import com.epam.task.reader.TxtReader;
import com.epam.task.validator.FileAndDataValidator;
import com.epam.task.validator.impl.FileAndDataValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Shift+Ctrl+F

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class TxtReaderImpl implements TxtReader {

  private static final Logger LOGGER = LogManager.getLogger(TxtReader.class);
  private static final TxtReaderImpl INSTANCE = new TxtReaderImpl();

  private  TxtReaderImpl() {}

  public static TxtReaderImpl getInstance() {
    return INSTANCE;
  }


  public List<String> readDataTxt(String path) throws ReadDataException{
    File file = new File(path);
    FileAndDataValidator fileFileAndDataValidator = FileAndDataValidatorImpl.getInstance();
    boolean resultValidator = fileFileAndDataValidator.checkFile(file);
    if(!resultValidator) {
      LOGGER.warn("File:" + path + "  is not exist or empty");
      throw new ReadDataException("File is not exist or empty - " + path);
    }
      try {
        List<String>  allLines =  Files.readAllLines(file.toPath());
       LOGGER.info("File:" + file + " was successfully read");
      return allLines;
    } catch(IOException e){
        LOGGER.warn("File:" + path + ". Exception with readAllLines method");
      throw new ReadDataException(e);
    }
  }

}
