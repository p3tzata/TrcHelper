package org.example.util;

import static org.p3tzata.util.TrcHelperFactory.*;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.p3tzata.util.TrcHelper;

class TrcHelperTest {

  private String dirBase = "trcDebugHelper";
  private String dirWorker = "current";
  private String dirArch = "arch";
  Path currentPath = Paths.get(dirBase).resolve(dirWorker);

  @BeforeEach
  void beforeEach() {

    TrcHelper.clearCurrent();
  }

  @Test
  void LINE() {

    TrcHelper.LINE(_var("test", 69));
    assertTrue(Files.exists(currentPath.resolve("1_[test=69]")));
  }

  @Test
  void IF_THEN_with_label() {

    TrcHelper.IF(1 == 1, "isEqual");
    if (1 == 1) {
      String t = "t";
    }
    else {
      String t = "t";
    }
    TrcHelper.EXIT();
    TrcHelper.LINE(_var("test", 69));
    assertTrue(Files.exists(currentPath.resolve("1_IF(isEqual)")));
    assertTrue(Files.exists(currentPath.resolve("1_IF(isEqual)").resolve("+THEN")));
    assertTrue(Files.exists(currentPath.resolve("2_[test=69]")));
  }

  @Test
  void IF_THEN_with_logicExp() {

    int i = 2;
    int j = 2;
    TrcHelper.IF(1 == 1, _var("i", i), _eq(), _var("j", j));
    if (1 == 1) {
      String t = "t";
      TrcHelper.LINE(_var("test", 69));
    }
    else {
      String t = "t";
    }
    TrcHelper.EXIT();
    TrcHelper.LINE(_var("test", 69));
    assertTrue(Files.exists(currentPath.resolve("1_IF([i=2]==[j=2])")));
    assertTrue(Files.exists(currentPath.resolve("1_IF([i=2]==[j=2])").resolve("+THEN")));
    assertTrue(Files.exists(currentPath.resolve("2_[test=69]")));
  }

  @Test
  void callMethodWithMiddleReturn() {

    someMethod_middleReturn();
    TrcHelper.LINE(_var("test", 69));
    assertTrue(Files.exists(currentPath.resolve("1_CALL_someMethod()")
        .resolve("1_IF(isEqual)")
        .resolve("+THEN")
        .resolve("1_RETURN()")
    ));
    assertTrue(Files.exists(currentPath.resolve("2_[test=69]")));

  }

  @Test
  void callMethodWithEndReturn() {

    someMethod_endReturn();
    TrcHelper.LINE(_var("test", 69));
    assertTrue(Files.exists(currentPath.resolve("1_CALL_someMethod()")
        .resolve("1_IF(isEqual)")
        .resolve("+THEN")
    ));
    assertTrue(Files.exists(currentPath.resolve("1_CALL_someMethod()")
        .resolve("2_RETURN()")
    ));
    assertTrue(Files.exists(currentPath.resolve("2_[test=69]")));

  }

  @Test
  void whileLoop(){

    int i = 0;
    TrcHelper.WHILE(_var("i",i),_lt(),_num(5));
    while(i++<5) {
      TrcHelper.LOOP(_var("i",i));
      int j = i;
      TrcHelper.LINE(_var("j",j));
    }
    TrcHelper.EXIT();
    TrcHelper.LINE(_var("test", 69));

    assertTrue(Files.exists(currentPath.resolve("1_WHILE([i=0]<[5])")
        .resolve("1_LOOP([i=1])")
        .resolve("1_[j=1]")
    ));
    assertTrue(Files.exists(currentPath.resolve("1_WHILE([i=0]<[5])")
        .resolve("5_LOOP([i=5])")
        .resolve("1_[j=5]")
    ));

    assertTrue(Files.exists(currentPath.resolve("2_[test=69]")));
  }

  void someMethod_middleReturn() {

    TrcHelper.CALL("someMethod");
    TrcHelper.IF(1 == 1, "isEqual");
    if (1 == 1) {
      String t = "t";
      TrcHelper.RETURN();
      return;
    }
    else {
      String t = "t";
    }
    TrcHelper.EXIT();
    TrcHelper.RETURN();
  }

  void someMethod_endReturn() {

    TrcHelper.CALL("someMethod");
    TrcHelper.IF(1 == 1, "isEqual");
    if (1 == 1) {
      String t = "t";
    }
    else {
      String t = "t";
    }
    TrcHelper.EXIT();
    TrcHelper.RETURN();
  }

}
