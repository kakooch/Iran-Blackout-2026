package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.dO2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11661dO2 {
    private final int a;
    private final EnumC5360Iz7 b;

    public C11661dO2(int i, EnumC5360Iz7 enumC5360Iz7) {
        AbstractC13042fc3.i(enumC5360Iz7, "type");
        this.a = i;
        this.b = enumC5360Iz7;
    }

    public final EnumC5360Iz7 a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11661dO2)) {
            return false;
        }
        C11661dO2 c11661dO2 = (C11661dO2) obj;
        return this.a == c11661dO2.a && this.b == c11661dO2.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "GroupTypingEntity(uid=" + this.a + ", type=" + this.b + Separators.RPAREN;
    }
}
