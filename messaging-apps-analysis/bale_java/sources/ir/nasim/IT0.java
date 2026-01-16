package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class IT0 {
    private final int a;
    private final byte[] b;
    private final int c;
    private final C24411ya3 d;

    public IT0(int i, byte[] bArr, int i2, C24411ya3 c24411ya3) {
        AbstractC13042fc3.i(bArr, "body");
        AbstractC13042fc3.i(c24411ya3, "bytesRange");
        this.a = i;
        this.b = bArr;
        this.c = i2;
        this.d = c24411ya3;
    }

    public final byte[] a() {
        return this.b;
    }

    public final C24411ya3 b() {
        return this.d;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.c;
    }

    public String toString() {
        return "Chunk(number=" + this.a + ", totalChunks=" + this.c + ", bytesRange=" + this.d + Separators.RPAREN;
    }
}
