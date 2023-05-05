package org.p3tzata.util.common.impl;

import org.p3tzata.util.common.pub.ILogicExp;
import org.p3tzata.util.common.pub.ILogicOper;
import org.p3tzata.util.common.pub.TrcStringFormatter;

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
