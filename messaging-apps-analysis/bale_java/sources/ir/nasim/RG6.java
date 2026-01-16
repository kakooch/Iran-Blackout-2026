package ir.nasim;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class RG6 {
    private final C21576tm4 a;

    public RG6(long[] jArr) {
        C21576tm4 c21576tm4;
        if (jArr != null) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
            c21576tm4 = new C21576tm4(jArrCopyOf.length);
            c21576tm4.e(c21576tm4.b, jArrCopyOf);
        } else {
            c21576tm4 = new C21576tm4(0, 1, null);
        }
        this.a = c21576tm4;
    }

    public final void a(long j) {
        this.a.d(j);
    }

    public final long[] b() {
        C21576tm4 c21576tm4 = this.a;
        int i = c21576tm4.b;
        if (i == 0) {
            return null;
        }
        long[] jArr = new long[i];
        long[] jArr2 = c21576tm4.a;
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = jArr2[i2];
        }
        return jArr;
    }
}
