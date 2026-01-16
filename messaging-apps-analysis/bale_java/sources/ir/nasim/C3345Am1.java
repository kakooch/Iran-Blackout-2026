package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Am1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3345Am1 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public C3345Am1(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
    }

    public static /* synthetic */ C3345Am1 b(C3345Am1 c3345Am1, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c3345Am1.a;
        }
        if ((i & 2) != 0) {
            z2 = c3345Am1.b;
        }
        boolean z7 = z2;
        if ((i & 4) != 0) {
            z3 = c3345Am1.c;
        }
        boolean z8 = z3;
        if ((i & 8) != 0) {
            z4 = c3345Am1.d;
        }
        boolean z9 = z4;
        if ((i & 16) != 0) {
            z5 = c3345Am1.e;
        }
        boolean z10 = z5;
        if ((i & 32) != 0) {
            z6 = c3345Am1.f;
        }
        return c3345Am1.a(z, z7, z8, z9, z10, z6);
    }

    public final C3345Am1 a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return new C3345Am1(z, z2, z3, z4, z5, z6);
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3345Am1)) {
            return false;
        }
        C3345Am1 c3345Am1 = (C3345Am1) obj;
        return this.a == c3345Am1.a && this.b == c3345Am1.b && this.c == c3345Am1.c && this.d == c3345Am1.d && this.e == c3345Am1.e && this.f == c3345Am1.f;
    }

    public final boolean f() {
        return this.f;
    }

    public final boolean g() {
        return this.b;
    }

    public final boolean h() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "ControllerState(isVisible=" + this.a + ", isSeeking=" + this.b + ", contextMenuIsOpen=" + this.c + ", isCaptionExpanded=" + this.d + ", userHavingInteraction=" + this.e + ", isCaptionInterferenceWithPlayPauseButton=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ C3345Am1(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) == 0 ? z6 : false);
    }
}
