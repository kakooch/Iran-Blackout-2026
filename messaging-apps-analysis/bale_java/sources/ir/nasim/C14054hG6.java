package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.hG6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14054hG6 {
    public static final int c = AbstractC13463gG6.a;
    private final AbstractC13463gG6 a;
    private final String b;

    public C14054hG6(AbstractC13463gG6 abstractC13463gG6, String str) {
        AbstractC13042fc3.i(abstractC13463gG6, "snackBarStyle");
        AbstractC13042fc3.i(str, "title");
        this.a = abstractC13463gG6;
        this.b = str;
    }

    public final AbstractC13463gG6 a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14054hG6)) {
            return false;
        }
        C14054hG6 c14054hG6 = (C14054hG6) obj;
        return AbstractC13042fc3.d(this.a, c14054hG6.a) && AbstractC13042fc3.d(this.b, c14054hG6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SnackBarVisuals(snackBarStyle=" + this.a + ", title=" + this.b + Separators.RPAREN;
    }
}
