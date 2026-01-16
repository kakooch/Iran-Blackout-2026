package ir.nasim;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* renamed from: ir.nasim.nP, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17692nP extends G1 {
    private int l;
    private int m;
    private long n;
    private int o;
    private int p;
    private int q;
    private long r;
    private long s;
    private long t;
    private long u;
    private int v;
    private long w;
    private byte[] x;

    public C17692nP(String str) {
        super(str);
    }

    @Override // ir.nasim.J0, ir.nasim.InterfaceC4984Hk0
    public long f() {
        int i = this.o;
        int i2 = 16;
        long jC = (i == 1 ? 16 : 0) + 28 + (i == 2 ? 36 : 0) + c();
        if (!this.j && 8 + jC < 4294967296L) {
            i2 = 8;
        }
        return jC + i2;
    }

    @Override // ir.nasim.J0, ir.nasim.InterfaceC4984Hk0
    public void g(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(l());
        int i = this.o;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((i == 1 ? 16 : 0) + 28 + (i == 2 ? 36 : 0));
        byteBufferAllocate.position(6);
        AbstractC5869Le3.e(byteBufferAllocate, this.k);
        AbstractC5869Le3.e(byteBufferAllocate, this.o);
        AbstractC5869Le3.e(byteBufferAllocate, this.v);
        AbstractC5869Le3.g(byteBufferAllocate, this.w);
        AbstractC5869Le3.e(byteBufferAllocate, this.l);
        AbstractC5869Le3.e(byteBufferAllocate, this.m);
        AbstractC5869Le3.e(byteBufferAllocate, this.p);
        AbstractC5869Le3.e(byteBufferAllocate, this.q);
        if (this.i.equals("mlpa")) {
            AbstractC5869Le3.g(byteBufferAllocate, p());
        } else {
            AbstractC5869Le3.g(byteBufferAllocate, p() << 16);
        }
        if (this.o == 1) {
            AbstractC5869Le3.g(byteBufferAllocate, this.r);
            AbstractC5869Le3.g(byteBufferAllocate, this.s);
            AbstractC5869Le3.g(byteBufferAllocate, this.t);
            AbstractC5869Le3.g(byteBufferAllocate, this.u);
        }
        if (this.o == 2) {
            AbstractC5869Le3.g(byteBufferAllocate, this.r);
            AbstractC5869Le3.g(byteBufferAllocate, this.s);
            AbstractC5869Le3.g(byteBufferAllocate, this.t);
            AbstractC5869Le3.g(byteBufferAllocate, this.u);
            byteBufferAllocate.put(this.x);
        }
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        e(writableByteChannel);
    }

    public int n() {
        return this.l;
    }

    public long p() {
        return this.n;
    }

    public void q(int i) {
        this.l = i;
    }

    public void s(long j) {
        this.n = j;
    }

    @Override // ir.nasim.AbstractC20202rd0
    public String toString() {
        return "AudioSampleEntry{bytesPerSample=" + this.u + ", bytesPerFrame=" + this.t + ", bytesPerPacket=" + this.s + ", samplesPerPacket=" + this.r + ", packetSize=" + this.q + ", compressionId=" + this.p + ", soundVersion=" + this.o + ", sampleRate=" + this.n + ", sampleSize=" + this.m + ", channelCount=" + this.l + ", boxes=" + b() + '}';
    }

    public void u(int i) {
        this.m = i;
    }
}
