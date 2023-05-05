package org.p3tzata.util.common.pub;

public interface TrcStringFormatter {

  String callToString(String callName, IVariable... variables);

  String ifToString(String label);

  String whileToString(String label);

  String loopBlockToString(String label);
  String ifToString(ILogicOper... logicOpers);

  String variableToString(String varName, Object value);
  String numToString(Object value);

  String logicExpToString(ILogicOper[] logicOpers);

  String orToString();
  String andToString();
  String eqToString();
  String ltToString();
  String gtToString();

  String returnToString();
}
