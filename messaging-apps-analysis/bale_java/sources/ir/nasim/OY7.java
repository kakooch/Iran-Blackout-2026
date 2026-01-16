package ir.nasim;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public final class OY7 extends G1 implements InterfaceC12511ek1 {
    private int l;
    private int m;
    private double n;
    private double o;
    private int p;
    private String q;
    private int r;
    private long[] s;

    public OY7(String str) {
        super(str);
        this.n = 72.0d;
        this.o = 72.0d;
        this.p = 1;
        this.q = "";
        this.r = 24;
        this.s = new long[3];
    }

    public void G(int i) {
        this.p = i;
    }

    public void H(int i) {
        this.m = i;
    }

    public void J(double d) {
        this.n = d;
    }

    public void K(double d) {
        this.o = d;
    }

    public void M(int i) {
        this.l = i;
    }

    @Override // ir.nasim.J0, ir.nasim.InterfaceC4984Hk0
    public long f() {
        long jC = c();
        return 78 + jC + ((this.j || jC + 86 >= 4294967296L) ? 16 : 8);
    }

    @Override // ir.nasim.J0, ir.nasim.InterfaceC4984Hk0
    public void g(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(l());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(78);
        byteBufferAllocate.position(6);
        AbstractC5869Le3.e(byteBufferAllocate, this.k);
        AbstractC5869Le3.e(byteBufferAllocate, 0);
        AbstractC5869Le3.e(byteBufferAllocate, 0);
        AbstractC5869Le3.g(byteBufferAllocate, this.s[0]);
        AbstractC5869Le3.g(byteBufferAllocate, this.s[1]);
        AbstractC5869Le3.g(byteBufferAllocate, this.s[2]);
        AbstractC5869Le3.e(byteBufferAllocate, getWidth());
        AbstractC5869Le3.e(byteBufferAllocate, getHeight());
        AbstractC5869Le3.b(byteBufferAllocate, s());
        AbstractC5869Le3.b(byteBufferAllocate, u());
        AbstractC5869Le3.g(byteBufferAllocate, 0L);
        AbstractC5869Le3.e(byteBufferAllocate, q());
        AbstractC5869Le3.j(byteBufferAllocate, PM7.c(n()));
        byteBufferAllocate.put(PM7.b(n()));
        int iC = PM7.c(n());
        while (iC < 31) {
            iC++;
            byteBufferAllocate.put((byte) 0);
        }
        AbstractC5869Le3.e(byteBufferAllocate, p());
        AbstractC5869Le3.e(byteBufferAllocate, 65535);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        e(writableByteChannel);
    }

    public int getHeight() {
        return this.m;
    }

    public int getWidth() {
        return this.l;
    }

    public String n() {
        return this.q;
    }

    public int p() {
        return this.r;
    }

    public int q() {
        return this.p;
    }

    public double s() {
        return this.n;
    }

    public double u() {
        return this.o;
    }

    public void y(String str) {
        this.q = str;
    }

    public void z(int i) {
        this.r = i;
    }
}
