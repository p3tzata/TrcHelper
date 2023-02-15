package org.example;

import static org.example.util.TrcHelperFactory.*;

import org.example.util.TrcHelper;

public class Main {

  public static void main(String[] args) {

    System.out.println("Hello world!");
    TrcHelper.clearCurrent();
    TrcHelper.CALL("main", _var("ss", 4), _var("user", "Pepi"));
    factorial(3);

    TrcHelper.RETURN();


  }
  static int factorial(int n) {

    TrcHelper.CALL("factorial",_var("n",n));
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
