package ir.nasim;

import java.io.InputStream;

/* renamed from: ir.nasim.tG5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C21193tG5 extends C8526Wi5 {
    private final long c;

    public C21193tG5(InputStream inputStream, long j, long j2) {
        super(inputStream, j);
        this.c = j + j2;
    }

    public long b() {
        return this.c - a();
    }

    @Override // ir.nasim.C8526Wi5, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (a() == this.c) {
            return -1;
        }
        return super.read();
    }

    @Override // ir.nasim.C8526Wi5, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long jA = a() + j;
        long j2 = this.c;
        if (jA > j2) {
            j = (int) (j2 - a());
        }
        return super.skip(j);
    }

    @Override // ir.nasim.C8526Wi5, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        long jA = a() + i2;
        long j = this.c;
        if (jA <= j || (i2 = (int) (j - a())) != 0) {
            return super.read(bArr, i, i2);
        }
        return -1;
    }
}
