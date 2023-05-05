package org.p3tzata.util.common.impl.logicOper;

import org.p3tzata.util.common.pub.ILogicOper;
import org.p3tzata.util.common.pub.TrcStringFormatter;

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
