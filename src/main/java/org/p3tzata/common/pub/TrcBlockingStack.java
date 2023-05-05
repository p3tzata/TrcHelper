package org.p3tzata.common.pub;

import org.p3tzata.common.BlockType;
import org.p3tzata.common.model.BlockTypeEntity;

public interface TrcBlockingStack {

  void add(BlockType blockType, boolean isExpectExit);
  BlockTypeEntity pop();
  BlockTypeEntity peek();
}
