package org.example.util.common.impl;


import org.example.util.common.pub.IVariable;
import org.example.util.common.pub.TrcStringFormatter;

public class NumImpl implements IVariable {

  Object value;
  TrcStringFormatter trcStringFormatter;

  public NumImpl(TrcStringFormatter trcStringFormatter, Object value) {


    this.value = value;
    this.trcStringFormatter = trcStringFormatter;
  }

  @Override
  public String getString() {

    return trcStringFormatter.numToString(value);

  }
}
