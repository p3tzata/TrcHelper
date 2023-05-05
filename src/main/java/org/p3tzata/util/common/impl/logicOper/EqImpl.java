package org.p3tzata.util.common.impl.logicOper;

import org.p3tzata.util.common.pub.ILogicOper;
import org.p3tzata.util.common.pub.TrcStringFormatter;

public class EqImpl implements ILogicOper {
  TrcStringFormatter trcStringFormatter;
  public EqImpl(TrcStringFormatter trcStringFormatter) {
    this.trcStringFormatter=trcStringFormatter;
  }

  @Override
  public String getString() {

    return trcStringFormatter.eqToString();
  }
}