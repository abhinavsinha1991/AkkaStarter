package com.abhinav.akka.actors;

import akka.actor.AbstractActor;
import com.abhinav.akka.models.Employee;

public class PrintMsgActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Employee.class, a-> System.out.println(a))
                .matchAny(b-> System.out.println("Unsupported message received by PrintMsgActor!!"))
                .build();
    }
}
