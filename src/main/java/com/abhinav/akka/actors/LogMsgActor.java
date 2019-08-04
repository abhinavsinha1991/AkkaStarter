package com.abhinav.akka.actors;

import akka.actor.AbstractActor;
import com.abhinav.akka.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMsgActor extends AbstractActor {

    Logger LOGGER= LoggerFactory.getLogger(LogMsgActor.class);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Employee.class, a-> LOGGER.info(a.toString()))
                .matchAny(b-> LOGGER.error("Unsupported message received!!"))
                .build();
    }
}
