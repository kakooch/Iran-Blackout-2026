package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.tn4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C21586tn4 {
    private final int a;
    private final String b;
    private final int c;
    private final int d;

    public C21586tn4(int i, String str, int i2, int i3) {
        AbstractC13042fc3.i(str, "title");
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
    }

    public final int a() {
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
        if (!(obj instanceof C21586tn4)) {
            return false;
        }
        C21586tn4 c21586tn4 = (C21586tn4) obj;
        return this.a == c21586tn4.a && AbstractC13042fc3.d(this.b, c21586tn4.b) && this.c == c21586tn4.c && this.d == c21586tn4.d;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "MutualGroup(peerId=" + this.a + ", title=" + this.b + ", members=" + this.c + ", onlineMembers=" + this.d + Separators.RPAREN;
    }
}
