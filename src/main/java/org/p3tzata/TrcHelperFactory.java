package org.p3tzata;


import org.p3tzata.TrcHelper;
import org.p3tzata.common.impl.LogicExpImpl;
import org.p3tzata.common.impl.NumImpl;
import org.p3tzata.common.impl.VariableImpl;
import org.p3tzata.common.impl.logicOper.AndImpl;
import org.p3tzata.common.impl.logicOper.EqImpl;
import org.p3tzata.common.impl.logicOper.GtImpl;
import org.p3tzata.common.impl.logicOper.LtImpl;
import org.p3tzata.common.impl.logicOper.OrImpl;
import org.p3tzata.common.pub.ILogicExp;
import org.p3tzata.common.pub.ILogicOper;
import org.p3tzata.common.pub.IVariable;
import org.p3tzata.common.pub.TrcStringFormatter;

public class TrcHelperFactory {

  private static TrcStringFormatter trcStringFormatter;

  static {
    trcStringFormatter = TrcHelper.getTrcStringFormatter();
  }

  public static IVariable _var(String name, Object value) {

    return new VariableImpl(trcStringFormatter, name, value);
  }
  public static IVariable _num(Object value) {

    return new NumImpl(trcStringFormatter, value);
  }


  public static ILogicOper _eq() {

    return new EqImpl(trcStringFormatter);
  }
  public static ILogicOper _lt() {

    return new LtImpl(trcStringFormatter);
  }
  public static ILogicOper _gt() {

    return new GtImpl(trcStringFormatter);
  }

  public static ILogicOper _or() {

    return new OrImpl(trcStringFormatter);
  }
  public static ILogicOper _and() {

    return new AndImpl(trcStringFormatter);
  }

  public static ILogicExp _logExp(ILogicOper... iLogicOpers) {

    return new LogicExpImpl(trcStringFormatter, iLogicOpers);
  }


}
