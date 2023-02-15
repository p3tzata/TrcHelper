package org.example.util;


import java.util.Stack;
import org.example.util.common.impl.DirectoryStringFormatterImpl;
import org.example.util.common.impl.DirectoryTrcHelperLoggerImp;
import org.example.util.common.impl.LogicExpImpl;
import org.example.util.common.impl.NumImpl;
import org.example.util.common.impl.VariableImpl;
import org.example.util.common.impl.logicOper.AndImpl;
import org.example.util.common.impl.logicOper.EqImpl;
import org.example.util.common.impl.logicOper.GtImpl;
import org.example.util.common.impl.logicOper.LtImpl;
import org.example.util.common.impl.logicOper.OrImpl;
import org.example.util.common.pub.ILogicExp;
import org.example.util.common.pub.ILogicOper;
import org.example.util.common.pub.IVariable;
import org.example.util.common.pub.TrcStringFormatter;

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
