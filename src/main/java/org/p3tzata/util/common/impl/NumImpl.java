package org.p3tzata.util.common.impl;


import org.p3tzata.util.common.pub.IVariable;
import org.p3tzata.util.common.pub.TrcStringFormatter;

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
