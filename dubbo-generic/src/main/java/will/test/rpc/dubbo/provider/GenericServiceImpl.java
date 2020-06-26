package will.test.rpc.dubbo.provider;

import org.apache.dubbo.rpc.service.GenericException;
import org.apache.dubbo.rpc.service.GenericService;

public class GenericServiceImpl implements GenericService {

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        return "intercepted method " + method + " in " + getClass().getSimpleName();
    }

}
