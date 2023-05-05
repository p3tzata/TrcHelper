package org.p3tzata.common.impl.logicOper;

import org.p3tzata.common.pub.ILogicOper;
import org.p3tzata.common.pub.TrcStringFormatter;

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
