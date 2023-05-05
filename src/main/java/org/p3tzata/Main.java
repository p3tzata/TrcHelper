package org.p3tzata;

import org.p3tzata.util.TrcHelper;
import org.p3tzata.util.TrcHelperFactory;

public class Main {

  public static void main(String[] args) {

    System.out.println("Hello world!");
    TrcHelper.clearCurrent();
    TrcHelper.CALL("main", TrcHelperFactory._var("ss", 4), TrcHelperFactory._var("user", "Pepi"));
    factorial(3);

    TrcHelper.RETURN();


  }
  static int factorial(int n) {

    TrcHelper.CALL("factorial", TrcHelperFactory._var("n",n));
    if (n != 0)  // termination condition
    {
      int result = n * factorial(n - 1); // recursive call
      TrcHelper.RETURN();
      return result;
    }
    else {
      TrcHelper.RETURN();
      return 1;

    }

  }
}
