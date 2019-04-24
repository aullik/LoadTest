package de.htwg.loadTest

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ReceiptLoadTest extends Simulation {

  val httpProtocol = http
    .baseUrl("http://193.196.52.68") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("default")
      .get("/"))
    .pause(2) // Note that Gatling has recorder real time pauses
    .exec(http("view")
      .get("/view"))

  //    .pause(2) // Note that Gatling has recorder real time pauses
  //    .exec(http("post") // Here's an example of a POST request
  //      .post("/computers")
  //      .formParam("""name""", """Beautiful Computer""") // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
  //      .formParam("""introduced""", """2012-05-30""")
  //      .formParam("""discontinued""", """""")
  //      .formParam("""company""", """37"""))


  setUp(scn.inject(
    constantUsersPerSec(100) during(1 minute)
  ).protocols(httpProtocol))
}
