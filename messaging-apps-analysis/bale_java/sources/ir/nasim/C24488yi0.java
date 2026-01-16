package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.yi0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24488yi0 {
    public static final int d = 0;
    private final String a;
    private final String b;
    private final String c;

    public C24488yi0(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "slashCommand");
        AbstractC13042fc3.i(str2, "description");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24488yi0)) {
            return false;
        }
        C24488yi0 c24488yi0 = (C24488yi0) obj;
        return AbstractC13042fc3.d(this.a, c24488yi0.a) && AbstractC13042fc3.d(this.b, c24488yi0.b) && AbstractC13042fc3.d(this.c, c24488yi0.c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BotCommand(slashCommand=" + this.a + ", description=" + this.b + ", locKey=" + this.c + Separators.RPAREN;
    }
}
