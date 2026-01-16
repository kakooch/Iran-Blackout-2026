package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mX3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17177mX3 extends AbstractC15537jl {
    private final int a;
    private final XV4 b;
    private final boolean c;
    private final String d;
    private final EnumC8893Xt7 e;

    public C17177mX3(int i, XV4 xv4, boolean z, String str, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(xv4, "measuredSize");
        AbstractC13042fc3.i(str, "sharedElementTransitionName");
        this.a = i;
        this.b = xv4;
        this.c = z;
        this.d = str;
        this.e = enumC8893Xt7;
    }

    @Override // ir.nasim.AbstractC15537jl
    public String a() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC15537jl
    public EnumC8893Xt7 b() {
        return this.e;
    }

    public final int c() {
        return this.a;
    }

    public final XV4 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17177mX3)) {
            return false;
        }
        C17177mX3 c17177mX3 = (C17177mX3) obj;
        return this.a == c17177mX3.a && AbstractC13042fc3.d(this.b, c17177mX3.b) && this.c == c17177mX3.c && AbstractC13042fc3.d(this.d, c17177mX3.d) && this.e == c17177mX3.e;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
        EnumC8893Xt7 enumC8893Xt7 = this.e;
        return iHashCode + (enumC8893Xt7 == null ? 0 : enumC8893Xt7.hashCode());
    }

    public String toString() {
        return "MediaExtras(itemCorners=" + this.a + ", measuredSize=" + this.b + ", isIncomingMessage=" + this.c + ", sharedElementTransitionName=" + this.d + ", trafficUsageOrigin=" + this.e + Separators.RPAREN;
    }
}
