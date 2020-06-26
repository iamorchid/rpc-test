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

package will.test.rpc.dubbo.consumer;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.common.serialize.Serialization;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.apache.dubbo.common.constants.CommonConstants.GENERIC_SERIALIZATION_NATIVE_JAVA;

public class BasicConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/dubbo-demo-consumer.xml");
        context.start();

        GenericService helloService = (GenericService) context.getBean("helloService");
        Object result = helloService.$invoke("sayHello",
                new String[]{String.class.getName()},
                new String[]{"hi"});
        System.out.println("sayHello result: " + result);



        GenericService echoService = (GenericService) context.getBean("echoService");
        Object echoResult = echoService.$invoke("echo",
                new String[]{String.class.getName()},
                new String[]{"my sound"});
        System.out.println("echo result: " + echoResult);



        Serialization serialization = ExtensionLoader.getExtensionLoader(Serialization.class).getExtension(GENERIC_SERIALIZATION_NATIVE_JAVA);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        serialization.serialize(null, os).writeObject("my native sound");

        GenericService nativeEchoService = (GenericService) context.getBean("nativeJavaEchoService");
        Object nativeEchoResult = nativeEchoService.$invoke("echo",
                new String[]{String.class.getName()},
                new Object[]{os.toByteArray()});
        String myEchoResult = serialization.deserialize(null, new ByteArrayInputStream((byte[]) nativeEchoResult)).readObject(String.class);
        System.out.println("native echo result: " + myEchoResult);
    }

}
