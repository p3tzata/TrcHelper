package org.p3tzata.common.impl;


import org.p3tzata.common.pub.IVariable;
import org.p3tzata.common.pub.TrcStringFormatter;

public class VariableImpl implements IVariable {

  String name;
  Object value;
  TrcStringFormatter trcStringFormatter;

  public VariableImpl(TrcStringFormatter trcStringFormatter,String name, Object value) {

    this.name = name;
    this.value = value;
    this.trcStringFormatter = trcStringFormatter;
  }

  @Override
  public String getString() {

    return trcStringFormatter.variableToString(name, value);

  }
}
