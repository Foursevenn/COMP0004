package uk.ac.ucl.model;

import java.io.File;
import java.io.IOException;

// Calling the static method getModel returns an initialised Model object.
// This version limits the program to one model object, which is returned whenever getModel is called.
public class ModelFactory {
  private static Model model;

  public static Model getModel() throws IOException {
    if (model == null) {
      model = new Model();
      model.loadFile(new File("./src/main/webapp/data/data.csv"));
    }

    return model;
  }
}
