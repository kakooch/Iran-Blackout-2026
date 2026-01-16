package ir.nasim;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
final class Xg8 implements InterfaceC19663qj8 {
    private final ByteBuffer a;

    public Xg8(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    @Override // ir.nasim.InterfaceC19663qj8
    public final void a(MessageDigest[] messageDigestArr, long j, int i) {
        ByteBuffer byteBufferSlice;
        synchronized (this.a) {
            int i2 = (int) j;
            this.a.position(i2);
            this.a.limit(i2 + i);
            byteBufferSlice = this.a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }

    @Override // ir.nasim.InterfaceC19663qj8
    public final long zza() {
        return this.a.capacity();
    }
}
