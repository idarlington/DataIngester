package com.lunatech.collector

import akka.actor.Props

object collector extends App  {

	implicit val system = akka.actor.ActorSystem()

	val streamActor = system.actorOf(Props(new StreamActor()))

	import scala.language.postfixOps
	import scala.concurrent.duration._
	import system.dispatcher

	system.scheduler.schedule(0 milliseconds, 10 seconds, streamActor, "")
}
