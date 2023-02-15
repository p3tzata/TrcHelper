package org.example.util.common.impl;

import org.example.util.common.pub.ILogicExp;
import org.example.util.common.pub.ILogicOper;
import org.example.util.common.pub.TrcStringFormatter;

public class LogicExpImpl implements ILogicExp {

  private TrcStringFormatter trcStringFormatter;
  private ILogicOper[] logicOpers;

  public LogicExpImpl(TrcStringFormatter trcStringFormatter, ILogicOper[] logicOpers) {

    this.trcStringFormatter = trcStringFormatter;
    this.logicOpers = logicOpers;
  }

  @Override
  public String getString() {

    return trcStringFormatter.logicExpToString(logicOpers);
  }
}
