package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.Ng5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6361Ng5 {
    private int a;
    private long[] b = new long[2];

    private final long[] i(int i) {
        long[] jArr = this.b;
        long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i, jArr.length * 2));
        AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
        this.b = jArrCopyOf;
        return jArrCopyOf;
    }

    public final boolean a(long j) {
        if (c(j)) {
            return false;
        }
        j(this.a, j);
        return true;
    }

    public final void b() {
        this.a = 0;
    }

    public final boolean c(long j) {
        int i = this.a;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b[i2] == j) {
                return true;
            }
        }
        return false;
    }

    public final long d(int i) {
        return AbstractC6122Mg5.a(this.b[i]);
    }

    public final int e() {
        return this.a;
    }

    public final boolean f() {
        return this.a == 0;
    }

    public final boolean g(long j) {
        int i = this.a;
        int i2 = 0;
        while (i2 < i) {
            if (j == this.b[i2]) {
                int i3 = this.a - 1;
                while (i2 < i3) {
                    long[] jArr = this.b;
                    int i4 = i2 + 1;
                    jArr[i2] = jArr[i4];
                    i2 = i4;
                }
                this.a--;
                return true;
            }
            i2++;
        }
        return false;
    }

    public final boolean h(int i) {
        int i2 = this.a;
        if (i >= i2) {
            return false;
        }
        int i3 = i2 - 1;
        while (i < i3) {
            long[] jArr = this.b;
            int i4 = i + 1;
            jArr[i] = jArr[i4];
            i = i4;
        }
        this.a--;
        return true;
    }

    public final void j(int i, long j) {
        long[] jArrI = this.b;
        if (i >= jArrI.length) {
            jArrI = i(i + 1);
        }
        jArrI[i] = j;
        if (i >= this.a) {
            this.a = i + 1;
        }
    }
}
