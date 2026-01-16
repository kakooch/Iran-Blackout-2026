package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C16187kq8 extends AbstractC15596jq8 {
    private final Object a;

    C16187kq8(Object obj) {
        this.a = obj;
    }

    @Override // ir.nasim.AbstractC15596jq8
    public final Object a() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC15596jq8
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C16187kq8) {
            return this.a.equals(((C16187kq8) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.a + Separators.RPAREN;
    }
}
