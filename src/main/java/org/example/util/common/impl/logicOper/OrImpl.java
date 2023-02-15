package org.example.util.common.impl.logicOper;

import org.example.util.common.pub.ILogicOper;
import org.example.util.common.pub.TrcStringFormatter;

public class OrImpl implements ILogicOper {
  TrcStringFormatter trcStringFormatter;
  public OrImpl(TrcStringFormatter trcStringFormatter) {
    this.trcStringFormatter=trcStringFormatter;
  }

  @Override
  public String getString() {

    return trcStringFormatter.orToString();
  }
}
