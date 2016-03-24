package com.example
import org.scalatest._
import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.util.Timeout
import com.example.message.SetRequest
import scala.concurrent.duration._
//class HelloSpec extends FlatSpec with Matchers {
//  "Hello" should "have tests" in {
//    true should === (true)
//  }
//}

class HelloSpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)

  describe("First test") {
    describe("SetRequest"){
      it("key/value test"){
        val actorRef = TestActorRef(new Hello)
        actorRef ! SetRequest("key", "value")

        val hello = actorRef.underlyingActor
        hello.map.get("key") should equal(Some("value"))
      }
    }
  }
}

