package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.tm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21576tm4 extends AbstractC13487gJ3 {
    public C21576tm4(int i) {
        super(i, null);
    }

    public final boolean d(long j) {
        g(this.b + 1);
        long[] jArr = this.a;
        int i = this.b;
        jArr[i] = j;
        this.b = i + 1;
        return true;
    }

    public final boolean e(int i, long[] jArr) {
        AbstractC13042fc3.i(jArr, "elements");
        if (i < 0 || i > this.b) {
            AbstractC22970w76.c("");
        }
        if (jArr.length == 0) {
            return false;
        }
        g(this.b + jArr.length);
        long[] jArr2 = this.a;
        int i2 = this.b;
        if (i != i2) {
            AbstractC9648aK.k(jArr2, jArr2, jArr.length + i, i, i2);
        }
        AbstractC9648aK.p(jArr, jArr2, i, 0, 0, 12, null);
        this.b += jArr.length;
        return true;
    }

    public final void f() {
        this.b = 0;
    }

    public final void g(int i) {
        long[] jArr = this.a;
        if (jArr.length < i) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i, (jArr.length * 3) / 2));
            AbstractC13042fc3.h(jArrCopyOf, "copyOf(...)");
            this.a = jArrCopyOf;
        }
    }

    public final long h(int i) {
        if (i < 0 || i >= this.b) {
            AbstractC22970w76.c("Index must be between 0 and size");
        }
        long[] jArr = this.a;
        long j = jArr[i];
        int i2 = this.b;
        if (i != i2 - 1) {
            AbstractC9648aK.k(jArr, jArr, i, i + 1, i2);
        }
        this.b--;
        return j;
    }

    public final void i(int i, int i2) {
        int i3;
        if (i < 0 || i > (i3 = this.b) || i2 < 0 || i2 > i3) {
            AbstractC22970w76.c("Index must be between 0 and size");
        }
        if (i2 < i) {
            AbstractC22970w76.a("The end index must be < start index");
        }
        if (i2 != i) {
            int i4 = this.b;
            if (i2 < i4) {
                long[] jArr = this.a;
                AbstractC9648aK.k(jArr, jArr, i, i2, i4);
            }
            this.b -= i2 - i;
        }
    }

    public /* synthetic */ C21576tm4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 16 : i);
    }
}
