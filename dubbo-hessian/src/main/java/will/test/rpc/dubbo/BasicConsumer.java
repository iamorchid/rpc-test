/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package will.test.rpc.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import will.test.rpc.dubbo.api.HelloReply;
import will.test.rpc.dubbo.api.HelloRequest;
import will.test.rpc.dubbo.api.IGreeter;

import java.util.concurrent.CountDownLatch;

public class BasicConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/dubbo-demo-consumer.xml");
        context.start();

        IGreeter greeter = (IGreeter) context.getBean("greeterRefId");

        System.out.println("-------- Start simple unary call test -------- ");
        HelloReply reply = greeter.sayHello(new HelloRequest("hessian-consumer#0"));
        System.out.println("Result: " + reply.getMessage());

        new CountDownLatch(1).await();
    }

}
