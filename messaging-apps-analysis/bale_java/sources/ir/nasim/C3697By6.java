package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.By6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3697By6 {
    private final EnumC18627oy6 a;
    private final int b;

    public C3697By6(EnumC18627oy6 enumC18627oy6, int i) {
        AbstractC13042fc3.i(enumC18627oy6, "type");
        this.a = enumC18627oy6;
        this.b = i;
    }

    public final EnumC18627oy6 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3697By6)) {
            return false;
        }
        C3697By6 c3697By6 = (C3697By6) obj;
        return this.a == c3697By6.a && this.b == c3697By6.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "SharedMediaTab(type=" + this.a + ", id=" + this.b + Separators.RPAREN;
    }
}
