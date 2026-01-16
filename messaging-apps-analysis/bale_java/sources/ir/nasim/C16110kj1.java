package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kj1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16110kj1 {
    private Exception a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;

    public C16110kj1(Exception exc, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = exc;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
    }

    public static /* synthetic */ C16110kj1 b(C16110kj1 c16110kj1, Exception exc, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            exc = c16110kj1.a;
        }
        if ((i & 2) != 0) {
            z = c16110kj1.b;
        }
        boolean z5 = z;
        if ((i & 4) != 0) {
            z2 = c16110kj1.c;
        }
        boolean z6 = z2;
        if ((i & 8) != 0) {
            z3 = c16110kj1.d;
        }
        boolean z7 = z3;
        if ((i & 16) != 0) {
            z4 = c16110kj1.e;
        }
        return c16110kj1.a(exc, z5, z6, z7, z4);
    }

    public final C16110kj1 a(Exception exc, boolean z, boolean z2, boolean z3, boolean z4) {
        return new C16110kj1(exc, z, z2, z3, z4);
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16110kj1)) {
            return false;
        }
        C16110kj1 c16110kj1 = (C16110kj1) obj;
        return AbstractC13042fc3.d(this.a, c16110kj1.a) && this.b == c16110kj1.b && this.c == c16110kj1.c && this.d == c16110kj1.d && this.e == c16110kj1.e;
    }

    public final boolean f() {
        return this.c;
    }

    public final C16110kj1 g() {
        return new C16110kj1(null, false, false, true, false, 23, null);
    }

    public final C16110kj1 h(Exception exc) {
        AbstractC13042fc3.i(exc, "e");
        return new C16110kj1(exc, false, false, false, false, 30, null);
    }

    public int hashCode() {
        Exception exc = this.a;
        return ((((((((exc == null ? 0 : exc.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public final C16110kj1 i() {
        return new C16110kj1(null, false, false, false, true, 15, null);
    }

    public final C16110kj1 j() {
        return new C16110kj1(null, true, false, false, false, 29, null);
    }

    public final C16110kj1 k() {
        return new C16110kj1(null, false, true, false, false, 27, null);
    }

    public final C16110kj1 l(C16110kj1 c16110kj1) {
        AbstractC13042fc3.i(c16110kj1, "newState");
        if (c16110kj1.c) {
            return b(this, null, false, true, false, false, 24, null);
        }
        if (c16110kj1.d && this.b) {
            return b(this, null, (this.c || this.e) ? false : true, false, true, false, 20, null);
        }
        if (c16110kj1.e && this.b) {
            return b(this, null, (this.c || this.d) ? false : true, false, false, true, 13, null);
        }
        return null;
    }

    public String toString() {
        return "ContactsRefreshSyncState(failed=" + this.a + ", loading=" + this.b + ", uiTimeOut=" + this.c + ", allContactsImported=" + this.d + ", firstUpdateReceived=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C16110kj1(Exception exc, boolean z, boolean z2, boolean z3, boolean z4, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : exc, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) == 0 ? z4 : false);
    }
}
