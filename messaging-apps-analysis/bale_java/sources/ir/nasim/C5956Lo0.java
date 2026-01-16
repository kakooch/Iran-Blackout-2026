package ir.nasim;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* renamed from: ir.nasim.Lo0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C5956Lo0 extends FilterOutputStream {
    final OutputStream a;
    private ByteOrder b;

    C5956Lo0(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.a = outputStream;
        this.b = byteOrder;
    }

    public void a(ByteOrder byteOrder) {
        this.b = byteOrder;
    }

    public void b(int i) throws IOException {
        this.a.write(i);
    }

    public void c(int i) throws IOException {
        ByteOrder byteOrder = this.b;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.a.write(i & 255);
            this.a.write((i >>> 8) & 255);
            this.a.write((i >>> 16) & 255);
            this.a.write((i >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.a.write((i >>> 24) & 255);
            this.a.write((i >>> 16) & 255);
            this.a.write((i >>> 8) & 255);
            this.a.write(i & 255);
        }
    }

    public void d(short s) throws IOException {
        ByteOrder byteOrder = this.b;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.a.write(s & 255);
            this.a.write((s >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.a.write((s >>> 8) & 255);
            this.a.write(s & 255);
        }
    }

    public void e(long j) throws IOException {
        c((int) j);
    }

    public void g(int i) throws IOException {
        d((short) i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.a.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
    }
}
