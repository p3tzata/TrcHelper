package org.p3tzata.util.common.impl;

import java.util.Stack;
import org.p3tzata.util.common.BlockType;
import org.p3tzata.util.common.model.BlockTypeEntity;
import org.p3tzata.util.common.pub.TrcBlockingStack;

public class TrcBlockingStackImp implements TrcBlockingStack {
  private static Stack<BlockTypeEntity> stackBlockType;

  public TrcBlockingStackImp() {
    stackBlockType = new Stack<>();
  }

  public void add(BlockType blockType,boolean isExpectExit) {

    stackBlockType.add(new BlockTypeEntity(blockType, isExpectExit));
  }
  @Override
  public BlockTypeEntity pop(){

    return stackBlockType.pop();
  }

  @Override
  public BlockTypeEntity peek(){

    return stackBlockType.peek();
  }

  @Override
  public String toString() {

    return stackBlockType.toString();
  }
}
