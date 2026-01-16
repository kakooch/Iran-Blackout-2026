package ir.nasim;

import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes3.dex */
public abstract class D0 implements InterfaceC4984Hk0 {
    private static MI3 i = MI3.a(D0.class);
    protected String a;
    private byte[] b;
    private InterfaceC12511ek1 c;
    private ByteBuffer f;
    long g = -1;
    private ByteBuffer h = null;
    boolean e = true;
    boolean d = true;

    protected D0(String str) {
        this.a = str;
    }

    private void d(ByteBuffer byteBuffer) {
        if (j()) {
            AbstractC5869Le3.g(byteBuffer, f());
            byteBuffer.put(AbstractC5401Je3.l(e()));
        } else {
            AbstractC5869Le3.g(byteBuffer, 1L);
            byteBuffer.put(AbstractC5401Je3.l(e()));
            AbstractC5869Le3.i(byteBuffer, f());
        }
        if (CommonUrlParts.UUID.equals(e())) {
            byteBuffer.put(h());
        }
    }

    private boolean j() {
        int i2 = CommonUrlParts.UUID.equals(e()) ? 24 : 8;
        if (!this.e) {
            return this.g + ((long) i2) < 4294967296L;
        }
        if (!this.d) {
            return ((long) (this.f.limit() + i2)) < 4294967296L;
        }
        long jC = c();
        ByteBuffer byteBuffer = this.h;
        return (jC + ((long) (byteBuffer != null ? byteBuffer.limit() : 0))) + ((long) i2) < 4294967296L;
    }

    private synchronized void m() {
        try {
            if (!this.e) {
                try {
                    i.b("mem mapping " + e());
                    throw null;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    protected abstract void a(ByteBuffer byteBuffer);

    protected abstract void b(ByteBuffer byteBuffer);

    protected abstract long c();

    public String e() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC4984Hk0
    public long f() {
        long jLimit;
        if (!this.e) {
            jLimit = this.g;
        } else if (this.d) {
            jLimit = c();
        } else {
            ByteBuffer byteBuffer = this.f;
            jLimit = byteBuffer != null ? byteBuffer.limit() : 0;
        }
        return jLimit + (jLimit >= 4294967288L ? 8 : 0) + 8 + (CommonUrlParts.UUID.equals(e()) ? 16 : 0) + (this.h != null ? r0.limit() : 0);
    }

    @Override // ir.nasim.InterfaceC4984Hk0
    public void g(WritableByteChannel writableByteChannel) throws IOException {
        if (!this.e) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((j() ? 8 : 16) + (CommonUrlParts.UUID.equals(e()) ? 16 : 0));
            d(byteBufferAllocate);
            writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
            throw null;
        }
        if (!this.d) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((j() ? 8 : 16) + (CommonUrlParts.UUID.equals(e()) ? 16 : 0));
            d(byteBufferAllocate2);
            writableByteChannel.write((ByteBuffer) byteBufferAllocate2.rewind());
            writableByteChannel.write((ByteBuffer) this.f.position(0));
            return;
        }
        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(CH0.a(f()));
        d(byteBufferAllocate3);
        b(byteBufferAllocate3);
        ByteBuffer byteBuffer = this.h;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            while (this.h.remaining() > 0) {
                byteBufferAllocate3.put(this.h);
            }
        }
        writableByteChannel.write((ByteBuffer) byteBufferAllocate3.rewind());
    }

    public byte[] h() {
        return this.b;
    }

    public boolean i() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC4984Hk0
    public void k(InterfaceC12511ek1 interfaceC12511ek1) {
        this.c = interfaceC12511ek1;
    }

    public final synchronized void l() {
        try {
            m();
            i.b("parsing details of " + e());
            ByteBuffer byteBuffer = this.f;
            if (byteBuffer != null) {
                this.d = true;
                byteBuffer.rewind();
                a(byteBuffer);
                if (byteBuffer.remaining() > 0) {
                    this.h = byteBuffer.slice();
                }
                this.f = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
