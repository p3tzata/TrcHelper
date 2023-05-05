package org.p3tzata.common;

public interface TrcHelperLogger {

   void appendEdge(String edges);

   void appendNode(String node);
   void appendNodeToTop(String node);

   void clearCurrent();
   void exitNode();

}
