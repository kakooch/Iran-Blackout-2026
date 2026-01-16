package ir.nasim;

/* renamed from: ir.nasim.gJ3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC13487gJ3 {
    public long[] a;
    public int b;

    public /* synthetic */ AbstractC13487gJ3(int i, ED1 ed1) {
        this(i);
    }

    public static /* synthetic */ String c(AbstractC13487gJ3 abstractC13487gJ3, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
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
        return abstractC13487gJ3.b(charSequence, charSequence5, charSequence6, i3, charSequence4);
    }

    public final long a(int i) {
        if (i < 0 || i >= this.b) {
            AbstractC22970w76.c("Index must be between 0 and size");
        }
        return this.a[i];
    }

    public final String b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.a;
        int i2 = this.b;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            long j = jArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            sb.append(j);
            i3++;
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC13487gJ3) {
            AbstractC13487gJ3 abstractC13487gJ3 = (AbstractC13487gJ3) obj;
            int i = abstractC13487gJ3.b;
            int i2 = this.b;
            if (i == i2) {
                long[] jArr = this.a;
                long[] jArr2 = abstractC13487gJ3.a;
                C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, i2);
                int iO = c24411ya3Y.o();
                int iT = c24411ya3Y.t();
                if (iO > iT) {
                    return true;
                }
                while (jArr[iO] == jArr2[iO]) {
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

    public int hashCode() {
        long[] jArr = this.a;
        int i = this.b;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += Long.hashCode(jArr[i2]) * 31;
        }
        return iHashCode;
    }

    public String toString() {
        return c(this, null, "[", "]", 0, null, 25, null);
    }

    private AbstractC13487gJ3(int i) {
        this.a = i == 0 ? AbstractC21218tJ3.a() : new long[i];
    }
}
