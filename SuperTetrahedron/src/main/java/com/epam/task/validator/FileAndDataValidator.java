package com.epam.task.validator;

import java.io.File;

public interface FileAndDataValidator {

  boolean checkData(String string);

  boolean checkFile(File file);
}
