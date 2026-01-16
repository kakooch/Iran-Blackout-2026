package ir.nasim;

/* renamed from: ir.nasim.Qi5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7117Qi5 {
    private final int a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public C7117Qi5(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.a = i;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
        this.f = z5;
    }

    public final boolean a() {
        return this.c;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.e;
    }

    public final int d() {
        return this.a;
    }

    public final boolean e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7117Qi5)) {
            return false;
        }
        C7117Qi5 c7117Qi5 = (C7117Qi5) obj;
        return this.a == c7117Qi5.a && this.b == c7117Qi5.b && this.c == c7117Qi5.c && this.d == c7117Qi5.d && this.e == c7117Qi5.e && this.f == c7117Qi5.f;
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((this.a * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    }

    public /* synthetic */ C7117Qi5(boolean z, boolean z2, boolean z3, boolean z4, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
    }

    public C7117Qi5(boolean z, boolean z2, boolean z3, boolean z4) {
        this(z, z2, z3, EnumC20851si6.a, true, z4);
    }

    public /* synthetic */ C7117Qi5(boolean z, boolean z2, boolean z3, EnumC20851si6 enumC20851si6, boolean z4, boolean z5, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? EnumC20851si6.a : enumC20851si6, (i & 16) != 0 ? true : z4, (i & 32) == 0 ? z5 : true);
    }

    public C7117Qi5(boolean z, boolean z2, boolean z3, EnumC20851si6 enumC20851si6, boolean z4, boolean z5) {
        this(z, z2, z3, enumC20851si6, z4, z5, false);
    }

    public C7117Qi5(boolean z, boolean z2, boolean z3, EnumC20851si6 enumC20851si6, boolean z4, boolean z5, boolean z6) {
        this(AbstractC6456Nq.h(z, enumC20851si6, z5), enumC20851si6 == EnumC20851si6.a, z2, z3, z4, z6);
    }
}
