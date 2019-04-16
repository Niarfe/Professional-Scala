package com.packt.courseware.l4

import math._

// using 'val phi' makes phi a class field also...
case class PolarPoint(val phi:Double, val radius:Double) extends Point2D
{
  // Like asserts...
  require(phi >= - Pi && phi < Pi )
  require(radius >= 0)

  // How to declare an optinal variable (one way at least)
  def this(phi:Double) = this(phi,1.0)

  override def length = radius

  def x: Double = radius*cos(phi)
  def y: Double = radius*sin(phi)

  def * (x:Double) = PolarPoint(phi,radius*x)

}

// companion object, used to allow creation without 'new'
object PolarPoint
{
  // this calls the class to create the object
  // appy is a special function... x.apply(y) is the same as x(y)
  def apply(phi:Double, r:Double) = new PolarPoint(phi,r)

  // the object companion is a good place for 'static' or utility functions.
  def test: Unit = {
    val p1 = PolarPoint(Pi,1)
    val p2 = p1.copy(phi=1)
  }
}
