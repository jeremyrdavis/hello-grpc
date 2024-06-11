package io.arrogantprogrammer;

import io.quarkus.grpc.GrpcService;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        Log.infof("HelloGrpcService.sayHello: %s", request.getName());
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }

}
