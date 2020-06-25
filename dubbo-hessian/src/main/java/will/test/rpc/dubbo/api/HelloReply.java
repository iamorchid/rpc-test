package will.test.rpc.dubbo.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HelloReply implements Serializable {
    private String message;
}
