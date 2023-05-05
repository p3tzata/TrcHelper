package org.p3tzata.util.common.pub;

import org.p3tzata.util.common.BlockType;
import org.p3tzata.util.common.model.BlockTypeEntity;

public interface TrcBlockingStack {

  void add(BlockType blockType, boolean isExpectExit);
  BlockTypeEntity pop();
  BlockTypeEntity peek();
}
