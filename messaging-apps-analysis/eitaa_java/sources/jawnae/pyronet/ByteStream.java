package jawnae.pyronet;

import ir.eitaa.tgnet.BuffersStorage;
import ir.eitaa.tgnet.NativeByteBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ByteStream {
    private final ArrayList<NativeByteBuffer> queue = new ArrayList<>();

    public void append(NativeByteBuffer buf) {
        buf.getClass();
        this.queue.add(buf);
    }

    public boolean hasData() {
        this.queue.size();
        Iterator<NativeByteBuffer> it = this.queue.iterator();
        while (it.hasNext()) {
            if (it.next().hasRemaining()) {
                return true;
            }
        }
        return false;
    }

    public void get(ByteBuffer dst) {
        dst.getClass();
        Iterator<NativeByteBuffer> it = this.queue.iterator();
        while (it.hasNext()) {
            ByteBuffer byteBufferSlice = it.next().buffer.slice();
            if (byteBufferSlice.remaining() > dst.remaining()) {
                byteBufferSlice.limit(dst.remaining());
                dst.put(byteBufferSlice);
                return;
            } else {
                dst.put(byteBufferSlice);
                if (!dst.hasRemaining()) {
                    return;
                }
            }
        }
    }

    public void discard(int count) {
        int iRemaining = count;
        while (true) {
            if (iRemaining <= 0) {
                break;
            }
            NativeByteBuffer nativeByteBuffer = this.queue.get(0);
            if (iRemaining < nativeByteBuffer.buffer.remaining()) {
                nativeByteBuffer.position(nativeByteBuffer.position() + iRemaining);
                iRemaining = 0;
                break;
            } else {
                this.queue.remove(0);
                BuffersStorage.getInstance().reuseFreeBuffer(nativeByteBuffer);
                iRemaining -= nativeByteBuffer.buffer.remaining();
            }
        }
        if (iRemaining == 0) {
            return;
        }
        throw new PyroException("discarded " + (count - iRemaining) + "/" + count + " bytes");
    }
}
