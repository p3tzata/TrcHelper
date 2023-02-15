package org.example.util.common.pub;

import org.example.util.common.BlockType;
import org.example.util.common.model.BlockTypeEntity;

public interface TrcBlockingStack {

  void add(BlockType blockType, boolean isExpectExit);
  BlockTypeEntity pop();
  BlockTypeEntity peek();
}
