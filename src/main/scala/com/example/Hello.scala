package com.example

import akka.actor.Actor
import akka.event.Logging
import com.example.message.SetRequest
import scala.collection.mutable.HashMap

class Hello extends Actor{
  val map = new HashMap[String, String]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info("key: {} value: {}", key, value)
      map.put(key, value)
    }
    case o => log.info("Error: {}", o);
  }
}

//object Hello {
//  def main(args: Array[String]): Unit = {
//    println("Hello, world!")
//  }
//}
