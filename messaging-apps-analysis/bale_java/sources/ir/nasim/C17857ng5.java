package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ng5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17857ng5 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final C12372eV7 d;
    private final int e;

    public C17857ng5(boolean z, boolean z2, boolean z3, C12372eV7 c12372eV7, int i) {
        AbstractC13042fc3.i(c12372eV7, "videoSize");
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = c12372eV7;
        this.e = i;
    }

    public static /* synthetic */ C17857ng5 b(C17857ng5 c17857ng5, boolean z, boolean z2, boolean z3, C12372eV7 c12372eV7, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = c17857ng5.a;
        }
        if ((i2 & 2) != 0) {
            z2 = c17857ng5.b;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            z3 = c17857ng5.c;
        }
        boolean z5 = z3;
        if ((i2 & 8) != 0) {
            c12372eV7 = c17857ng5.d;
        }
        C12372eV7 c12372eV72 = c12372eV7;
        if ((i2 & 16) != 0) {
            i = c17857ng5.e;
        }
        return c17857ng5.a(z, z4, z5, c12372eV72, i);
    }

    public final C17857ng5 a(boolean z, boolean z2, boolean z3, C12372eV7 c12372eV7, int i) {
        AbstractC13042fc3.i(c12372eV7, "videoSize");
        return new C17857ng5(z, z2, z3, c12372eV7, i);
    }

    public final boolean c() {
        return this.c;
    }

    public final int d() {
        return this.e;
    }

    public final C12372eV7 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17857ng5)) {
            return false;
        }
        C17857ng5 c17857ng5 = (C17857ng5) obj;
        return this.a == c17857ng5.a && this.b == c17857ng5.b && this.c == c17857ng5.c && AbstractC13042fc3.d(this.d, c17857ng5.d) && this.e == c17857ng5.e;
    }

    public final boolean f() {
        return this.a;
    }

    public final boolean g() {
        return this.b;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "PlayerState(isMute=" + this.a + ", isPlaying=" + this.b + ", firstFrameRendered=" + this.c + ", videoSize=" + this.d + ", playbackState=" + this.e + Separators.RPAREN;
    }
}
