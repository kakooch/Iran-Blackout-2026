package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.lB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16391lB6 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final String f;

    public C16391lB6(String str, String str2, String str3, String str4, boolean z, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = z;
        this.f = str5;
    }

    public static /* synthetic */ C16391lB6 b(C16391lB6 c16391lB6, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c16391lB6.a;
        }
        if ((i & 2) != 0) {
            str2 = c16391lB6.b;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = c16391lB6.c;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = c16391lB6.d;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            z = c16391lB6.e;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str5 = c16391lB6.f;
        }
        return c16391lB6.a(str, str6, str7, str8, z2, str5);
    }

    public final C16391lB6 a(String str, String str2, String str3, String str4, boolean z, String str5) {
        return new C16391lB6(str, str2, str3, str4, z, str5);
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16391lB6)) {
            return false;
        }
        C16391lB6 c16391lB6 = (C16391lB6) obj;
        return AbstractC13042fc3.d(this.a, c16391lB6.a) && AbstractC13042fc3.d(this.b, c16391lB6.b) && AbstractC13042fc3.d(this.c, c16391lB6.c) && AbstractC13042fc3.d(this.d, c16391lB6.d) && this.e == c16391lB6.e && AbstractC13042fc3.d(this.f, c16391lB6.f);
    }

    public final String f() {
        return this.a;
    }

    public final String g() {
        return this.f;
    }

    public final boolean h() {
        return this.e;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.e)) * 31;
        String str5 = this.f;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "ShowkaseBrowserScreenMetadata(currentGroup=" + this.a + ", currentComponentName=" + this.b + ", currentComponentStyleName=" + this.c + ", currentComponentKey=" + this.d + ", isSearchActive=" + this.e + ", searchQuery=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ C16391lB6(String str, String str2, String str3, String str4, boolean z, String str5, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str5);
    }
}
