package com.abhinav.akka.actors;

import akka.actor.AbstractActor;
import akka.actor.Actor;

public class SampleActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class,a-> System.out.println(a))
                .matchAny(b-> System.out.println("Unsupported message received!!"))
                .build();
    }
}
