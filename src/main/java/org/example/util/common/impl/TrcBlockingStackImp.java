package org.example.util.common.impl;

import java.util.Stack;
import org.example.util.common.BlockType;
import org.example.util.common.model.BlockTypeEntity;
import org.example.util.common.pub.TrcBlockingStack;

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
