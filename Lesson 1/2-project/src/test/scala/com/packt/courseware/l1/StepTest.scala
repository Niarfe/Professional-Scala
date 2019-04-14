package com.packt.courseware.l1

import org.scalatest.FunSuite
import java.time.{LocalDate, LocalTime}
import java.time.format.DateTimeFormatter

class StepTest extends FunSuite {

  test("step of unparded word must be interesting") {
    val r = Chatbot2.step("qqqq")
    assert(! r.timeToBye)
    assert(r.answer == "interesting...")
  }

  test("after bye, timeToBye should be set to true") {
    val r = Chatbot2.step("bye")
    assert(r.timeToBye)
  }

  test("local time must be parsed") {
    val r = Chatbot2.step("time")
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    val t = LocalTime.parse(r.answer, formatter)
    //assertion is not necessary
  }

  test("local date must be parsed") {
    val r = Chatbot2.step("date")
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    println(s"And the answer is ${r.answer}")
    val t = LocalDate.parse(r.answer, formatter)
    // assertion is not necessary
  }
}
