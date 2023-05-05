package org.p3tzata.util.common.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;
import org.p3tzata.util.common.TrcHelperLogger;

public class DirectoryTrcHelperLoggerImp implements TrcHelperLogger {

  private String dirBase = "trcDebugHelper";
  private String dirWorker = "current";
  private String dirArch = "arch";

  final private String indexSplitter = "_";
  final private String appendOnTopPrefix = "+";
  private Path currentPathPosition;

  public DirectoryTrcHelperLoggerImp() {

    if (!Files.exists(Paths.get(dirBase))) {

      createDir(Paths.get(dirBase));
      createDir(Paths.get(dirBase).resolve(dirWorker));
      createDir(Paths.get(dirBase).resolve(dirArch));


    }

    deleteDirRecursive(Paths.get(dirBase).resolve(dirWorker));
    createDir(Paths.get(dirBase).resolve(dirWorker));
    currentPathPosition = Paths.get(dirBase).resolve(dirWorker);
  }

  private void deleteDirRecursive(Path path) {

    try (Stream<Path> walk = Files.walk(path)) {
      walk.sorted(Comparator.reverseOrder())
          .map(Path::toFile)
          // .peek(System.out::println)
          .forEach(File::delete);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void createDir(Path path) {

    try {
      Files.createDirectory(path);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void createFile(Path path) {

    try {
      Files.createFile(path);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void handleAppendNode(String node, boolean isOnTop) {

    if (isOnTop) {
      node = appendOnTopPrefix + node;
    }
    else {
      int nextIndex = this.getMaxIndex();
      node = nextIndex + this.indexSplitter + node;
    }

    Path tryAddNodePath = this.currentPathPosition.resolve(node);
    this.createDir(tryAddNodePath);
    this.currentPathPosition = tryAddNodePath;
  }

  private void handleAppendEdge(String edge) {

    int nextIndex = this.getMaxIndex();

    this.createFile(this.currentPathPosition.resolve(nextIndex + this.indexSplitter + edge));
  }

  private Integer getMaxIndex() {

    try (Stream<Path> walk = Files.walk(this.currentPathPosition, 1)) {

      Integer nextIndex = walk.sorted(Comparator.reverseOrder())
          .filter(x -> x != this.currentPathPosition)
          .map(Path::getFileName)
          .map(x -> Integer.valueOf(x.toString().split(indexSplitter)[0]) + 1)
          .findFirst().orElse(1);
      return nextIndex;

    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public void appendEdge(String edge) {

    this.handleAppendEdge(edge);
  }

  @Override
  public void appendNode(String node) {

    this.handleAppendNode(node, false);
  }
  @Override
  public void appendNodeToTop(String node) {

    this.handleAppendNode(node, true);
  }
  @Override
  public void clearCurrent() {

    if (Files.exists(Paths.get(dirBase).resolve(dirWorker))) {
      deleteDirRecursive(Paths.get(dirBase).resolve(dirWorker));
      createDir(Paths.get(dirBase).resolve(dirWorker));
    }
  }

  @Override
  public void exitNode() {

    this.currentPathPosition = this.currentPathPosition.getParent();
  }


}
