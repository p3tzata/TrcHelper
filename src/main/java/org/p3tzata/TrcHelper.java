package org.p3tzata;


import org.p3tzata.common.BlockType;
import org.p3tzata.common.TrcHelperLogger;
import org.p3tzata.common.impl.DirectoryStringFormatterImpl;
import org.p3tzata.common.impl.DirectoryTrcHelperLoggerImp;
import org.p3tzata.common.impl.TrcBlockingStackImp;
import org.p3tzata.common.model.BlockTypeEntity;
import org.p3tzata.common.pub.ILogicOper;
import org.p3tzata.common.pub.IString;
import org.p3tzata.common.pub.IVariable;
import org.p3tzata.common.pub.TrcBlockingStack;
import org.p3tzata.common.pub.TrcStringFormatter;

public class TrcHelper {

  private static TrcHelperLogger trcHelperLogger;
  private static TrcStringFormatter trcStringFormatter;
  private static TrcBlockingStack trcBlockingStack;


  static {
    trcHelperLogger = new DirectoryTrcHelperLoggerImp();
    trcStringFormatter = new DirectoryStringFormatterImpl();
    trcBlockingStack = new TrcBlockingStackImp();
  }

  public static void clearCurrent() {

    trcHelperLogger.clearCurrent();

  }

  public static void CALL(String methodName, IVariable... variables) {

    trcHelperLogger.appendNode(trcStringFormatter.callToString(methodName, variables));
    trcBlockingStack.add(BlockType.METHOD, true);

  }

  public static void IF(boolean ifExpression, String label) {

    trcHelperLogger.appendNode(trcStringFormatter.ifToString(label));
    trcBlockingStack.add(BlockType.IF, true);
    if (ifExpression) {
      trcHelperLogger.appendNodeToTop("THEN");
      trcBlockingStack.add(BlockType.THEN, false);
    }
    else {
      trcHelperLogger.appendNodeToTop("ELSE");
      trcBlockingStack.add(BlockType.ELSE, false);
    }

  }

  public static void IF(boolean ifExpression, ILogicOper... logicOpers) {

    IF(ifExpression, trcStringFormatter.logicExpToString(logicOpers));

  }

  public static void WHILE(String label) {

    trcHelperLogger.appendNode(trcStringFormatter.whileToString(label));
    trcBlockingStack.add(BlockType.WHILE, true);
  }

  public static void WHILE(ILogicOper... logicOpers) {

    WHILE(trcStringFormatter.logicExpToString(logicOpers));
  }

  public static void LOOP(String label) {

    if (trcBlockingStack.peek().getBlockType() == BlockType.LOOP_BLOCK) {
      trcBlockingStack.pop();
      trcHelperLogger.exitNode();
    }

    trcHelperLogger.appendNode(trcStringFormatter.loopBlockToString(label));
    trcBlockingStack.add(BlockType.LOOP_BLOCK, false);
  }

  public static void LOOP(ILogicOper... logicOpers) {

    LOOP(trcStringFormatter.logicExpToString(logicOpers));

  }


  public static void LINE(IString object) {

    trcHelperLogger.appendEdge(object.getString());
  }

  /**
   * Exit current block
   */
  public static void EXIT() {

    BlockTypeEntity be = trcBlockingStack.pop();
    while (!be.isExpectExit()) {
      trcHelperLogger.exitNode();
      be = trcBlockingStack.pop();
    }
    trcHelperLogger.exitNode();
  }

  public static void RETURN() {

    trcHelperLogger.appendEdge(trcStringFormatter.returnToString());
    BlockTypeEntity be = trcBlockingStack.pop();
    while (!(be.getBlockType() == BlockType.METHOD && be.isExpectExit())) {
      trcHelperLogger.exitNode();
      be = trcBlockingStack.pop();
    }
    trcHelperLogger.exitNode();
  }

  public static TrcStringFormatter getTrcStringFormatter() {

    return trcStringFormatter;
  }


}
