package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.Qf6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C7091Qf6 {
    private final List a;
    private final byte[] b;
    private final int c;

    public C7091Qf6(List list, byte[] bArr, int i) {
        AbstractC13042fc3.i(list, "contents");
        this.a = list;
        this.b = bArr;
        this.c = i;
    }

    public final List a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final byte[] c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7091Qf6)) {
            return false;
        }
        C7091Qf6 c7091Qf6 = (C7091Qf6) obj;
        return AbstractC13042fc3.d(this.a, c7091Qf6.a) && AbstractC13042fc3.d(this.b, c7091Qf6.b) && this.c == c7091Qf6.c;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        byte[] bArr = this.b;
        return ((iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "SearchContent(contents=" + this.a + ", loadState=" + Arrays.toString(this.b) + ", fullSize=" + this.c + Separators.RPAREN;
    }
}
