package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Cg4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3767Cg4 {
    private final Object a;
    private final EnumC3533Bg4 b;

    public C3767Cg4(Object obj, EnumC3533Bg4 enumC3533Bg4) {
        AbstractC13042fc3.i(enumC3533Bg4, "action");
        this.a = obj;
        this.b = enumC3533Bg4;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C3767Cg4);
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ModifyData(item=" + this.a + ", action=" + this.b + Separators.RPAREN;
    }
}
