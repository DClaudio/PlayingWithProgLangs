package org.scalatra.example

import org.scalatra.test.scalatest.ScalatraSuite
import org.scalatest.{BeforeAndAfter, FunSuite}

// For more on Specs2, see http://etorreborre.github.com/specs2/guide/org.specs2.guide.QuickStart.html
class RiakControllerTest extends ScalatraSuite with RiakJavaClientInit with FunSuite with BeforeAndAfter  {

  addServlet(classOf[SimpleRiakController], "/*")

}
