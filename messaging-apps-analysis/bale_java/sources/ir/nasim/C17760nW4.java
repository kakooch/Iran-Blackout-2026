package ir.nasim;

/* renamed from: ir.nasim.nW4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17760nW4 {
    private final String a;
    private final Object b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final String f;
    private final boolean g;

    public C17760nW4(String str, Object obj, boolean z, boolean z2, boolean z3, String str2, boolean z4) {
        this.a = str;
        this.b = obj;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = str2;
        this.g = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17760nW4)) {
            return false;
        }
        C17760nW4 c17760nW4 = (C17760nW4) obj;
        return AbstractC13042fc3.d(this.a, c17760nW4.a) && AbstractC13042fc3.d(this.b, c17760nW4.b) && this.c == c17760nW4.c && this.d == c17760nW4.d && this.e == c17760nW4.e && AbstractC13042fc3.d(this.f, c17760nW4.f) && this.g == c17760nW4.g;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Object obj = this.b;
        int iHashCode2 = (((((((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31;
        String str = this.f;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.g);
    }

    public String toString() {
        return "ParameterInformation(name=" + this.a + ", value=" + this.b + ", fromDefault=" + this.c + ", static=" + this.d + ", compared=" + this.e + ", inlineClass=" + this.f + ", stable=" + this.g + ')';
    }
}
