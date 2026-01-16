package ir.nasim;

/* renamed from: ir.nasim.pa3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC18977pa3 {
    public int[] a;
    public int b;

    public /* synthetic */ AbstractC18977pa3(int i, ED1 ed1) {
        this(i);
    }

    public static /* synthetic */ int b(AbstractC18977pa3 abstractC18977pa3, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: binarySearch");
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = abstractC18977pa3.b;
        }
        return abstractC18977pa3.a(i, i2, i3);
    }

    public static /* synthetic */ String g(AbstractC18977pa3 abstractC18977pa3, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        return abstractC18977pa3.f(charSequence, charSequence5, charSequence6, i3, charSequence4);
    }

    public final int a(int i, int i2, int i3) {
        if (i2 < 0 || i2 >= i3 || i3 > this.b) {
            AbstractC22970w76.c("");
        }
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = this.a[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public final boolean c(int i) {
        int[] iArr = this.a;
        int i2 = this.b;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] == i) {
                return true;
            }
        }
        return false;
    }

    public final int d() {
        if (this.b == 0) {
            AbstractC22970w76.d("IntList is empty.");
        }
        return this.a[0];
    }

    public final int e(int i) {
        if (i < 0 || i >= this.b) {
            AbstractC22970w76.c("Index must be between 0 and size");
        }
        return this.a[i];
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC18977pa3) {
            AbstractC18977pa3 abstractC18977pa3 = (AbstractC18977pa3) obj;
            int i = abstractC18977pa3.b;
            int i2 = this.b;
            if (i == i2) {
                int[] iArr = this.a;
                int[] iArr2 = abstractC18977pa3.a;
                C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, i2);
                int iO = c24411ya3Y.o();
                int iT = c24411ya3Y.t();
                if (iO > iT) {
                    return true;
                }
                while (iArr[iO] == iArr2[iO]) {
                    if (iO == iT) {
                        return true;
                    }
                    iO++;
                }
                return false;
            }
        }
        return false;
    }

    public final String f(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.a;
        int i2 = this.b;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            int i4 = iArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            sb.append(i4);
            i3++;
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public final int h() {
        if (this.b == 0) {
            AbstractC22970w76.d("IntList is empty.");
        }
        return this.a[this.b - 1];
    }

    public int hashCode() {
        int[] iArr = this.a;
        int i = this.b;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += Integer.hashCode(iArr[i2]) * 31;
        }
        return iHashCode;
    }

    public String toString() {
        return g(this, null, "[", "]", 0, null, 25, null);
    }

    private AbstractC18977pa3(int i) {
        this.a = i == 0 ? AbstractC4180Ea3.a() : new int[i];
    }
}
