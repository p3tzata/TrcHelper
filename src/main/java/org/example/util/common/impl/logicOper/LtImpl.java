package org.example.util.common.impl.logicOper;

import org.example.util.common.pub.ILogicOper;
import org.example.util.common.pub.TrcStringFormatter;

public class LtImpl implements ILogicOper {
  TrcStringFormatter trcStringFormatter;
  public LtImpl(TrcStringFormatter trcStringFormatter) {
    this.trcStringFormatter=trcStringFormatter;
  }

  @Override
  public String getString() {

    return trcStringFormatter.ltToString();
  }
}
