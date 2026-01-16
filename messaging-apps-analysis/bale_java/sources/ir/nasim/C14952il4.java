package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.il4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C14952il4 {
    private final int a;
    private final String b;
    private final String c;

    public C14952il4(int i, String str, String str2) {
        AbstractC13042fc3.i(str, "userText");
        AbstractC13042fc3.i(str2, "userName");
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14952il4)) {
            return false;
        }
        C14952il4 c14952il4 = (C14952il4) obj;
        return this.a == c14952il4.a && AbstractC13042fc3.d(this.b, c14952il4.b) && AbstractC13042fc3.d(this.c, c14952il4.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "MultiAccountBottomSheetUserState(userId=" + this.a + ", userText=" + this.b + ", userName=" + this.c + Separators.RPAREN;
    }
}
