package com.abhinav.akka.actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.abhinav.akka.models.Employee;
import sun.rmi.runtime.Log;

import java.util.List;

public class SampleActor extends AbstractActor {

    private ActorRef logMsgActor;
    private ActorRef printMsgActor;


    @Override
    public void preStart() throws Exception {
        logMsgActor=getContext().actorOf(Props.create(LogMsgActor.class),"log-msg-actor");
        printMsgActor=getContext().actorOf(Props.create(PrintMsgActor.class),"print-msg-actor");

        System.out.println(logMsgActor.path());
        System.out.println(printMsgActor.path());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Employee.class, a-> logMsgActor.tell(a,ActorRef.noSender()))
                .match(List.class, elements ->
                        elements.forEach(
                        element -> printMsgActor.tell(element,ActorRef.noSender())
                ))
                .matchAny(b-> System.out.println("Unsupported message received!!"))
                .build();
    }
}
