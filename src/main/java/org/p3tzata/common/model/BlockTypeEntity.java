package org.p3tzata.common.model;

import org.p3tzata.common.BlockType;

public class BlockTypeEntity {

  private BlockType blockType;
  private boolean isExpectExit;
  public BlockTypeEntity(BlockType blockType, boolean isExpectExit) {

    this.blockType = blockType;
    this.isExpectExit = isExpectExit;
  }

  public BlockType getBlockType() {

    return blockType;
  }

  public boolean isExpectExit() {

    return isExpectExit;
  }

  @Override
  public String toString() {

    return "BlockTypeEntity{" +
        "blockType=" + blockType +
        ", isExpectExit=" + isExpectExit +
        '}';
  }
}
