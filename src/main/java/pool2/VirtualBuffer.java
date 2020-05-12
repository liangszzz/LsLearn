package pool2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.nio.ByteBuffer;

@ToString
@Getter
@AllArgsConstructor
public class VirtualBuffer {

    private BufferPage bufferPage;

    private int start;

    private int end;

    private ByteBuffer buffer;

    private boolean isDirect;

    public void release() {
        if (bufferPage != null)
            bufferPage.release(this);
    }
}
