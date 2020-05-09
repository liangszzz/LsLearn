package pool;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
@AllArgsConstructor
public class VirtualBuffer {

    private final int start;

    private final int end;

    private final ByteBuffer buffer;

}
