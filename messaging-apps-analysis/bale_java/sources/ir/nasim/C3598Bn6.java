package ir.nasim;

/* renamed from: ir.nasim.Bn6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3598Bn6 {
    private final EnumC10942cT2 a;
    private final long b;
    private final EnumC3359An6 c;
    private final boolean d;

    public /* synthetic */ C3598Bn6(EnumC10942cT2 enumC10942cT2, long j, EnumC3359An6 enumC3359An6, boolean z, ED1 ed1) {
        this(enumC10942cT2, j, enumC3359An6, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3598Bn6)) {
            return false;
        }
        C3598Bn6 c3598Bn6 = (C3598Bn6) obj;
        return this.a == c3598Bn6.a && ZG4.j(this.b, c3598Bn6.b) && this.c == c3598Bn6.c && this.d == c3598Bn6.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + ZG4.o(this.b)) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "SelectionHandleInfo(handle=" + this.a + ", position=" + ((Object) ZG4.s(this.b)) + ", anchor=" + this.c + ", visible=" + this.d + ')';
    }

    private C3598Bn6(EnumC10942cT2 enumC10942cT2, long j, EnumC3359An6 enumC3359An6, boolean z) {
        this.a = enumC10942cT2;
        this.b = j;
        this.c = enumC3359An6;
        this.d = z;
    }
}
