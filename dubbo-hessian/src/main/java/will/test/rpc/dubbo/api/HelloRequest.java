package will.test.rpc.dubbo.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HelloRequest implements Serializable {
    private String name;
}
