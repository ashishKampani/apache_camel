package com.apachecamel.camel1.routes.activemq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //time and put message in queue
//timer is endpoint which is already there in Apache Camel
        from("timer:active-mq-timer?period=10000")
                .transform().constant("My message for ActiveMq")
                .log("${body}")
                .to("activemq:my-activemq-queue");
    }
}
