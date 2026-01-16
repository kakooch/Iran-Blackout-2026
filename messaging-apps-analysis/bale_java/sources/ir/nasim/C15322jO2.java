package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.jO2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15322jO2 {
    private long a;
    private String b;
    private int c;
    private Avatar d;
    private boolean e;

    public C15322jO2(long j, String str, int i, Avatar avatar, boolean z) {
        AbstractC13042fc3.i(str, "name");
        this.a = j;
        this.b = str;
        this.c = i;
        this.d = avatar;
        this.e = z;
    }

    public final Avatar a() {
        return this.d;
    }

    public final boolean b() {
        return this.e;
    }

    public final long c() {
        return this.a;
    }

    public final int d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15322jO2)) {
            return false;
        }
        C15322jO2 c15322jO2 = (C15322jO2) obj;
        return this.a == c15322jO2.a && AbstractC13042fc3.d(this.b, c15322jO2.b) && this.c == c15322jO2.c && AbstractC13042fc3.d(this.d, c15322jO2.d) && this.e == c15322jO2.e;
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        Avatar avatar = this.d;
        return ((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "Group_Channel(id=" + this.a + ", name=" + this.b + ", membersCount=" + this.c + ", avatar=" + this.d + ", canSendMessage=" + this.e + Separators.RPAREN;
    }
}
