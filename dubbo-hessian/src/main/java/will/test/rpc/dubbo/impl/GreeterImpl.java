package will.test.rpc.dubbo.impl;

import will.test.rpc.dubbo.api.HelloReply;
import will.test.rpc.dubbo.api.HelloRequest;
import will.test.rpc.dubbo.api.IGreeter;

public class GreeterImpl implements IGreeter {

    @Override
    public HelloReply sayHello(HelloRequest req) {
        return new HelloReply("You're welcome, " + req.getName());
    }

}
