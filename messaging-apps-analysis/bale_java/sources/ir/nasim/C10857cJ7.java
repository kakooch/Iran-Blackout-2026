package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.cJ7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10857cJ7 {
    private final EnumC21689ty0 a;
    private final C11458d25 b;

    public C10857cJ7(EnumC21689ty0 enumC21689ty0, C11458d25 c11458d25) {
        AbstractC13042fc3.i(enumC21689ty0, "callReactionType");
        this.a = enumC21689ty0;
        this.b = c11458d25;
    }

    public final C11458d25 a() {
        return this.b;
    }

    public final boolean b() {
        return this.a != EnumC21689ty0.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10857cJ7)) {
            return false;
        }
        C10857cJ7 c10857cJ7 = (C10857cJ7) obj;
        return this.a == c10857cJ7.a && AbstractC13042fc3.d(this.b, c10857cJ7.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C11458d25 c11458d25 = this.b;
        return iHashCode + (c11458d25 == null ? 0 : c11458d25.hashCode());
    }

    public String toString() {
        return "UserReaction(callReactionType=" + this.a + ", peer=" + this.b + Separators.RPAREN;
    }
}
