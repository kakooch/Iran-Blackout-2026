package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class I5 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;

    public I5(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = z7;
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public final boolean d() {
        return this.f;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I5)) {
            return false;
        }
        I5 i5 = (I5) obj;
        return this.a == i5.a && this.b == i5.b && this.c == i5.c && this.d == i5.d && this.e == i5.e && this.f == i5.f && this.g == i5.g;
    }

    public final boolean f() {
        return this.e;
    }

    public final boolean g() {
        return this.b;
    }

    public int hashCode() {
        return (((((((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g);
    }

    public String toString() {
        return "ActionModeItems(edit=" + this.a + ", reply=" + this.b + ", copy=" + this.c + ", copyTranscript=" + this.d + ", forward=" + this.e + ", delete=" + this.f + ", askAI=" + this.g + Separators.RPAREN;
    }

    public /* synthetic */ I5(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6, (i & 64) != 0 ? false : z7);
    }
}
