package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.km4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16143km4 extends AbstractC18977pa3 {
    public C16143km4(int i) {
        super(i, null);
    }

    public final void i(int i, int i2) {
        if (i < 0 || i > this.b) {
            AbstractC22970w76.c("Index must be between 0 and size");
        }
        l(this.b + 1);
        int[] iArr = this.a;
        int i3 = this.b;
        if (i != i3) {
            AbstractC9648aK.j(iArr, iArr, i + 1, i, i3);
        }
        iArr[i] = i2;
        this.b++;
    }

    public final boolean j(int i) {
        l(this.b + 1);
        int[] iArr = this.a;
        int i2 = this.b;
        iArr[i2] = i;
        this.b = i2 + 1;
        return true;
    }

    public final boolean k(int i, int[] iArr) {
        AbstractC13042fc3.i(iArr, "elements");
        if (i < 0 || i > this.b) {
            AbstractC22970w76.c("");
        }
        if (iArr.length == 0) {
            return false;
        }
        l(this.b + iArr.length);
        int[] iArr2 = this.a;
        int i2 = this.b;
        if (i != i2) {
            AbstractC9648aK.j(iArr2, iArr2, iArr.length + i, i, i2);
        }
        AbstractC9648aK.o(iArr, iArr2, i, 0, 0, 12, null);
        this.b += iArr.length;
        return true;
    }

    public final void l(int i) {
        int[] iArr = this.a;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(i, (iArr.length * 3) / 2));
            AbstractC13042fc3.h(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
        }
    }

    public final int m(int i) {
        if (i < 0 || i >= this.b) {
            AbstractC22970w76.c("Index must be between 0 and size");
        }
        int[] iArr = this.a;
        int i2 = iArr[i];
        int i3 = this.b;
        if (i != i3 - 1) {
            AbstractC9648aK.j(iArr, iArr, i, i + 1, i3);
        }
        this.b--;
        return i2;
    }

    public final int n(int i, int i2) {
        if (i < 0 || i >= this.b) {
            AbstractC22970w76.c("Index must be between 0 and size");
        }
        int[] iArr = this.a;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    public final void o() {
        int i = this.b;
        if (i == 0) {
            return;
        }
        AbstractC9648aK.I(this.a, 0, i);
    }

    public /* synthetic */ C16143km4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 16 : i);
    }
}
