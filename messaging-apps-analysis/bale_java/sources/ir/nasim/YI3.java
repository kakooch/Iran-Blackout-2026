package ir.nasim;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class YI3 {
    private int a;
    private long[] b;

    public YI3() {
        this(32);
    }

    public void a(long j) {
        int i = this.a;
        long[] jArr = this.b;
        if (i == jArr.length) {
            this.b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.b;
        int i2 = this.a;
        this.a = i2 + 1;
        jArr2[i2] = j;
    }

    public long b(int i) {
        if (i >= 0 && i < this.a) {
            return this.b[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.a);
    }

    public int c() {
        return this.a;
    }

    public long[] d() {
        return Arrays.copyOf(this.b, this.a);
    }

    public YI3(int i) {
        this.b = new long[i];
    }
}
