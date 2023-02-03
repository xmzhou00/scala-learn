package com.xmzhou.programinginscala.chapter9

import java.io.{File, PrintWriter}
import java.util.Date

/**
 * 控制抽象
 */
object FileMatcher {

  private def fileHere = new File("D:/").listFiles

  def fileEnding(query: String) = {

    for (file <- fileHere; if file.getName.endsWith(query)) yield file
  }


  def fileMatching(query: String,
                   matcher: (String, String) => Boolean): Array[File] = {
    for (file <- fileHere; if matcher(file.getName, query))
      yield file
  }

  def fileEnding2(query: String) = {
    // _.endsWith(_) 等价于 (fileName: String, query: String) => fileName.endsWith(query)
    fileMatching(query, _.endsWith(_))

  }

  def fileMatching2(matcher: String => Boolean): Array[File] = {
    for (file <- fileHere; if matcher(file.getName))
      yield file
  }

  def fileEnding3(query: String) = {
    //    fileMatching2((fileName:String)=>fileName.endsWith(query))
    fileMatching2(_.endsWith(query))
  }

  def main(args: Array[String]): Unit = {

    //    val files = fileEnding("scala")
    //    files.foreach(file => println(file.getName))

    //    withPrintWriter(
    //      new File("data.txt"),
    //      (writer:PrintWriter) => writer.println( new Date())
    //    )

    val file = new File("data.txt")
    withPrintWriter2(file) { writer =>
      writer.println(new Date())
    }

  }


  /**
   * 案例：
   * 贷出模式
   * 使用这种方式的好处是，确保文件在最后被关闭的是withPrintWriter而不是用户代码，因此不可能出现使用者忘记关闭文件的情况
   */
  def withPrintWriter(file: File, op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }


  /**
   * 使用柯里化函数转换
   */

  def withPrintWriter2(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

}
