package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.tV6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21346tV6 {
    private final int a;
    private final String b;
    private final String c;

    public C21346tV6(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.c;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21346tV6)) {
            return false;
        }
        C21346tV6 c21346tV6 = (C21346tV6) obj;
        return this.a == c21346tV6.a && AbstractC13042fc3.d(this.b, c21346tV6.b) && AbstractC13042fc3.d(this.c, c21346tV6.c);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "StoryTagUi(id=" + this.a + ", title=" + this.b + ", color=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C21346tV6(int i, String str, String str2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }
}
