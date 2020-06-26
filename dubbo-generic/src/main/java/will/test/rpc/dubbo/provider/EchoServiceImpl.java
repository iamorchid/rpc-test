package will.test.rpc.dubbo.provider;

public class EchoServiceImpl implements IEchoService {

    public String echo(String arg) {
        return "echo " + arg;
    }

}
