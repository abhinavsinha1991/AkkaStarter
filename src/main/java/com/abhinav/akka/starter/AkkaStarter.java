package com.abhinav.akka.starter;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.abhinav.akka.actors.SampleActor;

public class AkkaStarter {

    public static void main(String[] args) {

        ActorSystem actorSystem=ActorSystem.create("first-actor-system");

        ActorRef sampleActor=actorSystem.actorOf(Props.create(SampleActor.class));

        sampleActor.tell("Hello World",sampleActor);


    }
}
