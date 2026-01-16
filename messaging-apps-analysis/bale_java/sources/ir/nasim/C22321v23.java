package ir.nasim;

/* renamed from: ir.nasim.v23, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22321v23 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final int d;
    private final EnumC19597qd2 e;

    public C22321v23(boolean z, boolean z2, boolean z3, int i, EnumC19597qd2 enumC19597qd2) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = i;
        this.e = enumC19597qd2;
    }

    public static /* synthetic */ C22321v23 b(C22321v23 c22321v23, boolean z, boolean z2, boolean z3, int i, EnumC19597qd2 enumC19597qd2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = c22321v23.a;
        }
        if ((i2 & 2) != 0) {
            z2 = c22321v23.b;
        }
        boolean z4 = z2;
        if ((i2 & 4) != 0) {
            z3 = c22321v23.c;
        }
        boolean z5 = z3;
        if ((i2 & 8) != 0) {
            i = c22321v23.d;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            enumC19597qd2 = c22321v23.e;
        }
        return c22321v23.a(z, z4, z5, i3, enumC19597qd2);
    }

    public final C22321v23 a(boolean z, boolean z2, boolean z3, int i, EnumC19597qd2 enumC19597qd2) {
        return new C22321v23(z, z2, z3, i, enumC19597qd2);
    }

    public final boolean c() {
        return this.a;
    }

    public final EnumC19597qd2 d() {
        return this.e;
    }

    public final int e() {
        return this.d;
    }

    public final boolean f() {
        return this.b;
    }

    public final boolean g() {
        return this.c;
    }

    public /* synthetic */ C22321v23(boolean z, boolean z2, boolean z3, int i, EnumC19597qd2 enumC19597qd2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? true : z2, (i2 & 4) == 0 ? z3 : true, (i2 & 8) != 0 ? 4 : i, (i2 & 16) != 0 ? EnumC19597qd2.b : enumC19597qd2);
    }
}
