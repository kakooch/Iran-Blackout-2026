package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.e42, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12118e42 {
    private boolean a;
    private String b;
    private boolean c;

    public C12118e42(boolean z, String str, boolean z2) {
        AbstractC13042fc3.i(str, "prevPushType");
        this.a = z;
        this.b = str;
        this.c = z2;
    }

    public final String a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12118e42)) {
            return false;
        }
        C12118e42 c12118e42 = (C12118e42) obj;
        return this.a == c12118e42.a && AbstractC13042fc3.d(this.b, c12118e42.b) && this.c == c12118e42.c;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "EditPush(isFirst=" + this.a + ", prevPushType=" + this.b + ", isNewest=" + this.c + Separators.RPAREN;
    }
}
