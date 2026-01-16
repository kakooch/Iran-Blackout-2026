package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.Mf0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6108Mf0 {
    private long a;
    private long b;
    private long[] c = AbstractC23036wE6.a;

    public final boolean a(int i) {
        int i2;
        if (i < 64) {
            return ((1 << i) & this.a) != 0;
        }
        if (i < 128) {
            return ((1 << (i - 64)) & this.b) != 0;
        }
        long[] jArr = this.c;
        int length = jArr.length;
        if (length != 0 && (i / 64) - 2 < length) {
            return ((1 << (i % 64)) & jArr[i2]) != 0;
        }
        return false;
    }

    public final int b() {
        return (this.c.length + 2) * 64;
    }

    public final int c(int i) {
        int iNumberOfTrailingZeros;
        if (i < 64 && (iNumberOfTrailingZeros = Long.numberOfTrailingZeros(((~this.a) >>> i) << i)) < 64) {
            return iNumberOfTrailingZeros;
        }
        if (i < 128) {
            int i2 = i - 64;
            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(((~this.b) >>> i2) << i2);
            if (iNumberOfTrailingZeros2 < 64) {
                return iNumberOfTrailingZeros2 + 64;
            }
        }
        int iMax = Math.max(i, 128);
        int i3 = (iMax / 64) - 2;
        long[] jArr = this.c;
        int length = jArr.length;
        for (int i4 = i3; i4 < length; i4++) {
            long j = ~jArr[i4];
            if (i4 == i3) {
                int i5 = iMax % 64;
                j = (j >>> i5) << i5;
            }
            int iNumberOfTrailingZeros3 = Long.numberOfTrailingZeros(j);
            if (iNumberOfTrailingZeros3 < 64) {
                return (i4 * 64) + 128 + iNumberOfTrailingZeros3;
            }
        }
        return Integer.MAX_VALUE;
    }

    public final void d(int i, boolean z) {
        if (i < 64) {
            this.a = ((z ? 1L : 0L) << i) | ((~(1 << i)) & this.a);
            return;
        }
        if (i < 128) {
            this.b = ((z ? 1L : 0L) << i) | ((~(1 << (i - 64))) & this.b);
            return;
        }
        int i2 = i / 64;
        int i3 = i2 - 2;
        int i4 = i % 64;
        long j = 1 << i4;
        long[] jArrCopyOf = this.c;
        if (i3 >= jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2 - 1);
            AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
            this.c = jArrCopyOf;
        }
        jArrCopyOf[i3] = ((z ? 1L : 0L) << i4) | ((~j) & jArrCopyOf[i3]);
    }

    public final void e(int i, int i2) {
        long j = i < i2 ? -1L : 0L;
        this.a = ((((i < 64 ? 1 : 0) * j) >>> (64 - (Math.min(64, i2) - i))) << i) | this.a;
        if (i2 > 64) {
            int iMax = Math.max(i, 64);
            this.b = (((j * (iMax < 128 ? 1 : 0)) >>> (128 - (Math.min(128, i2) - iMax))) << iMax) | this.b;
            if (i2 > 128) {
                for (int iMax2 = Math.max(iMax, 128); iMax2 < i2; iMax2++) {
                    d(iMax2, true);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BitVector [");
        int iB = b();
        boolean z = true;
        for (int i = 0; i < iB; i++) {
            if (a(i)) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i);
                z = false;
            }
        }
        sb.append(']');
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }
}
