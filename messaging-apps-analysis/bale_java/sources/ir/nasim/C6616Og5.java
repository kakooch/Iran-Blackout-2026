package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Og5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6616Og5 {
    private final long a;
    private final long b;
    private final long c;
    private final boolean d;
    private final float e;
    private final long f;
    private final long g;
    private final boolean h;
    private final int i;
    private final long j;
    private List k;
    private long l;
    private boolean m;
    private boolean n;
    private C6616Og5 o;

    public /* synthetic */ C6616Og5(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, ED1 ed1) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6);
    }

    public final void a() {
        C6616Og5 c6616Og5 = this.o;
        if (c6616Og5 == null) {
            this.m = true;
            this.n = true;
        } else if (c6616Og5 != null) {
            c6616Og5.a();
        }
    }

    public final C6616Og5 b(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, List list, long j6) {
        C6616Og5 c6616Og5D = d(j, j2, j3, z, this.e, j4, j5, z2, i, list, j6);
        C6616Og5 c6616Og5 = this.o;
        if (c6616Og5 == null) {
            c6616Og5 = this;
        }
        c6616Og5D.o = c6616Og5;
        return c6616Og5D;
    }

    public final C6616Og5 d(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, List list, long j6) {
        C6616Og5 c6616Og5 = new C6616Og5(j, j2, j3, z, f, j4, j5, z2, false, i, list, j6, this.l, null);
        C6616Og5 c6616Og52 = this.o;
        if (c6616Og52 == null) {
            c6616Og52 = this;
        }
        c6616Og5.o = c6616Og52;
        return c6616Og5;
    }

    public final List e() {
        List list = this.k;
        return list == null ? AbstractC10360bX0.m() : list;
    }

    public final long f() {
        return this.a;
    }

    public final long g() {
        return this.l;
    }

    public final long h() {
        return this.c;
    }

    public final boolean i() {
        return this.d;
    }

    public final float j() {
        return this.e;
    }

    public final long k() {
        return this.g;
    }

    public final boolean l() {
        return this.h;
    }

    public final long m() {
        return this.j;
    }

    public final int n() {
        return this.i;
    }

    public final long o() {
        return this.b;
    }

    public final boolean p() {
        C6616Og5 c6616Og5 = this.o;
        return c6616Og5 != null ? c6616Og5.p() : this.m || this.n;
    }

    public String toString() {
        return "PointerInputChange(id=" + ((Object) AbstractC6122Mg5.d(this.a)) + ", uptimeMillis=" + this.b + ", position=" + ((Object) ZG4.s(this.c)) + ", pressed=" + this.d + ", pressure=" + this.e + ", previousUptimeMillis=" + this.f + ", previousPosition=" + ((Object) ZG4.s(this.g)) + ", previousPressed=" + this.h + ", isConsumed=" + p() + ", type=" + ((Object) AbstractC11873dh5.i(this.i)) + ", historical=" + e() + ",scrollDelta=" + ((Object) ZG4.s(this.j)) + ')';
    }

    public /* synthetic */ C6616Og5(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, long j7, ED1 ed1) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, list, j6, j7);
    }

    private C6616Og5(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
        this.e = f;
        this.f = j4;
        this.g = j5;
        this.h = z2;
        this.i = i;
        this.j = j6;
        this.l = ZG4.b.c();
        this.m = z3;
        this.n = z3;
    }

    public /* synthetic */ C6616Og5(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, int i2, ED1 ed1) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, (i2 & 512) != 0 ? AbstractC11873dh5.a.d() : i, (i2 & 1024) != 0 ? ZG4.b.c() : j6, null);
    }

    private C6616Og5(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, long j7) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6, null);
        this.k = list;
        this.l = j7;
    }
}
