package com.abhinav.akka.starter;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.abhinav.akka.actors.SampleActor;

public class AkkaStarter {

    public static void main(String[] args) {

        ActorSystem actorSystem=ActorSystem.create("first-actor-system");

        ActorRef sampleActor=actorSystem.actorOf(Props.create(SampleActor.class),"myfirstactor");

        //send message to SampleActor without expecting acknowledgement/reply
        sampleActor.tell("Hello World",sampleActor);
        //send message of a diff. type to SampleActor without expecting acknowledgement/reply
        sampleActor.tell(Integer.valueOf(50),ActorRef.noSender());

        //get actor reference using heirarchy
        ActorSelection actorSelection= actorSystem.actorSelection("/user/myfirstactor");

        actorSelection.tell("Demo of ActorSelection using actor heirarchy successful",ActorRef.noSender());

        actorSystem.terminate();
    }
}
