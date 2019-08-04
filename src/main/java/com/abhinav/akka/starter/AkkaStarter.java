package com.abhinav.akka.starter;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.abhinav.akka.actors.SampleActor;
import com.abhinav.akka.models.Employee;
import com.abhinav.akka.models.EmployeeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AkkaStarter {

    public static void main(String[] args) {

        ActorSystem actorSystem = ActorSystem.create("first-actor-system");

        ActorRef sampleActor = actorSystem.actorOf(Props.create(SampleActor.class), "myfirstactor");

        System.out.println(sampleActor.path());

        //send message to SampleActor without expecting acknowledgement/reply
        sampleActor.tell("Hello World", sampleActor);
        //send message of a diff. type to SampleActor without expecting acknowledgement/reply
        sampleActor.tell(Integer.valueOf(50), ActorRef.noSender());

        //get actor reference using heirarchy
        ActorSelection actorSelection = actorSystem.actorSelection("/user/myfirstactor/print-msg-actor");

        Employee employee1 = new EmployeeBuilder().setId(1).setDept("HR").setName("ABC").createEmployee();
        Employee employee2 = new EmployeeBuilder().setId(2).setDept("FIN").setName("CDE").createEmployee();

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        sampleActor.tell(employees,ActorRef.noSender());

        actorSelection.tell("Demo of ActorSelection using actor heirarchy successful", ActorRef.noSender());

        actorSystem.terminate();
    }
}
