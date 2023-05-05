package org.p3tzata.common.impl;


import java.util.Arrays;
import org.p3tzata.common.pub.ILogicOper;
import org.p3tzata.common.pub.IVariable;
import org.p3tzata.common.pub.TrcStringFormatter;

public class DirectoryStringFormatterImpl implements TrcStringFormatter {

  @Override
  public String callToString(String callName, IVariable... variables) {

    String varString;
    StringBuilder strVarBuilder = new StringBuilder();
    Arrays.stream(variables).forEach(x -> strVarBuilder.append(x.getString() + ","));
    varString = strVarBuilder.toString();
    if (strVarBuilder.length() > 0) {
      varString = strVarBuilder.substring(0, strVarBuilder.length() - 1);
    }

    return "CALL_" + callName + "(" + varString + ")";
  }

  @Override
  public String ifToString(String label) {

    return String.format("IF(%s)", label);
  }

  @Override
  public String whileToString(String label) {

    return String.format("WHILE(%s)", label);
  }

  @Override
  public String loopBlockToString(String label) {

    return String.format("LOOP(%s)", label);
  }

  @Override
  public String ifToString(ILogicOper... logicOpers) {

    return ifToString(String.format("%s",this.logicExpToString(logicOpers)));
  }

  @Override
  public String variableToString(String varName, Object value) {

    return String.format("[%s=%s]", varName, value.toString());
  }

  @Override
  public String numToString(Object value) {

    return String.format("[%s]", value.toString());
  }

  @Override
  public String logicExpToString(ILogicOper[] logicOpers) {

    String varString;
    StringBuilder strVarBuilder = new StringBuilder();
    Arrays.stream(logicOpers).forEach(x -> strVarBuilder.append(x.getString()));
    varString = strVarBuilder.toString();

    return varString;
  }

  @Override
  public String orToString() {

    return "||";
  }

  @Override
  public String andToString() {

    return "&&";
  }

  @Override
  public String eqToString() {

    return "==";
  }

  @Override
  public String ltToString() {

    return "<";
  }

  @Override
  public String gtToString() {

    return ">";
  }

  @Override
  public String returnToString() {

    return "RETURN()";
  }

}
