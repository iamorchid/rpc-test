package will.test.rpc.dubbo.impl;

import io.grpc.stub.StreamObserver;
import will.test.rpc.dubbo.proto.DubboGreeterGrpc;
import will.test.rpc.dubbo.proto.HelloReply;
import will.test.rpc.dubbo.proto.HelloRequest;

public class GrpcGreeterImpl extends DubboGreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("Executing thread is " + Thread.currentThread().getName());
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
