package ir.nasim;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/* renamed from: ir.nasim.Co0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3835Co0 implements ByteChannel {
    ByteBuffer a;

    public C3835Co0(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (this.a.remaining() <= 0) {
            return -1;
        }
        byteBuffer.put((ByteBuffer) this.a.duplicate().limit(this.a.position() + byteBuffer.remaining()));
        ByteBuffer byteBuffer2 = this.a;
        byteBuffer2.position(byteBuffer2.position() + iRemaining);
        return iRemaining;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        this.a.put(byteBuffer);
        return iRemaining;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
