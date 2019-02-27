package com.epam.task.validator.impl;

import com.epam.task.validator.FileAndDataValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileAndDataValidatorImplTest {

  @DataProvider(name = "dataForValidation")
  public Object[][] initData() {
    return new Object[][]{
            {true, "0 0 1.634;  0 -1 0;  1.732 0 0;  0 1 0;"},
            {true,"0.77 6 1.34; 0 -6 0; 1.732 0 3; 0 2 1;"},
            {false, "0.577 0 qwe; 0 -1 0; 1.732 0 0; 0 1 0"},
            {true, "1 2 -2; 9 2 -2; 5 8.93 -2; 5 4.31 4.532;"}
    };

  }

  @Test(dataProvider = "dataForValidation")
  public void correctAndIncorrectData(boolean expected, String toValidate){
    //when
    FileAndDataValidator fileAndDataValidator = FileAndDataValidatorImpl.getInstance();
    boolean actual = fileAndDataValidator.checkData(toValidate);
    //then
    Assert.assertEquals(actual, expected);
  }
}
