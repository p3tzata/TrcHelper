package org.example.util.common.impl.logicOper;

import org.example.util.common.pub.ILogicOper;
import org.example.util.common.pub.TrcStringFormatter;

public class GtImpl implements ILogicOper {
  TrcStringFormatter trcStringFormatter;
  public GtImpl(TrcStringFormatter trcStringFormatter) {
    this.trcStringFormatter=trcStringFormatter;
  }

  @Override
  public String getString() {

    return trcStringFormatter.gtToString();
  }
}
