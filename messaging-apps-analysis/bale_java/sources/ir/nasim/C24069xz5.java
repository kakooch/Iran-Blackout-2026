package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xz5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24069xz5 {
    private final Object a;
    private final Object b;
    private final Object c;
    private final Object d;

    public C24069xz5(Object obj, Object obj2, Object obj3, Object obj4) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
    }

    public final Object a() {
        return this.b;
    }

    public final Object b() {
        return this.c;
    }

    public final Object c() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24069xz5)) {
            return false;
        }
        C24069xz5 c24069xz5 = (C24069xz5) obj;
        return AbstractC13042fc3.d(this.a, c24069xz5.a) && AbstractC13042fc3.d(this.b, c24069xz5.b) && AbstractC13042fc3.d(this.c, c24069xz5.c) && AbstractC13042fc3.d(this.d, c24069xz5.d);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.c;
        int iHashCode3 = (iHashCode2 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.d;
        return iHashCode3 + (obj4 != null ? obj4.hashCode() : 0);
    }

    public String toString() {
        return "Quadruple(first=" + this.a + ", second=" + this.b + ", third=" + this.c + ", fourth=" + this.d + Separators.RPAREN;
    }
}
