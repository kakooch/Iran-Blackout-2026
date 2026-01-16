package ir.nasim;

/* renamed from: ir.nasim.pP1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18876pP1 {
    private final boolean a;
    private final boolean b;
    private final EnumC20851si6 c;
    private final boolean d;
    private final boolean e;

    public C18876pP1(boolean z, boolean z2, EnumC20851si6 enumC20851si6, boolean z3, boolean z4) {
        this.a = z;
        this.b = z2;
        this.c = enumC20851si6;
        this.d = z3;
        this.e = z4;
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public final EnumC20851si6 d() {
        return this.c;
    }

    public final boolean e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18876pP1)) {
            return false;
        }
        C18876pP1 c18876pP1 = (C18876pP1) obj;
        return this.a == c18876pP1.a && this.b == c18876pP1.b && this.c == c18876pP1.c && this.d == c18876pP1.d && this.e == c18876pP1.e;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
    }

    public /* synthetic */ C18876pP1(boolean z, boolean z2, boolean z3, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3);
    }

    public C18876pP1(boolean z, boolean z2, boolean z3) {
        this(z, z2, EnumC20851si6.a, z3, true);
    }

    public /* synthetic */ C18876pP1(boolean z, boolean z2, EnumC20851si6 enumC20851si6, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? EnumC20851si6.a : enumC20851si6);
    }

    public /* synthetic */ C18876pP1(boolean z, boolean z2, EnumC20851si6 enumC20851si6) {
        this(z, z2, enumC20851si6, true, true);
    }
}
