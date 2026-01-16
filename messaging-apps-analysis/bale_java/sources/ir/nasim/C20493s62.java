package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.s62, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20493s62 {
    private final int a;
    private final int b;
    private final CharSequence c;

    public C20493s62(int i, int i2, CharSequence charSequence) {
        this.a = i;
        this.b = i2;
        this.c = charSequence;
    }

    public final CharSequence a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20493s62)) {
            return false;
        }
        C20493s62 c20493s62 = (C20493s62) obj;
        return this.a == c20493s62.a && this.b == c20493s62.b && AbstractC13042fc3.d(this.c, c20493s62.c);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31;
        CharSequence charSequence = this.c;
        return iHashCode + (charSequence == null ? 0 : charSequence.hashCode());
    }

    public String toString() {
        return "EmojiRange(start=" + this.a + ", end=" + this.b + ", code=" + ((Object) this.c) + Separators.RPAREN;
    }
}
