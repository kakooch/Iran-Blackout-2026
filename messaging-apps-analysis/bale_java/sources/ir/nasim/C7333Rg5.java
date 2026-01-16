package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Rg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7333Rg5 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final boolean e;
    private final float f;
    private final int g;
    private final boolean h;
    private final List i;
    private final long j;
    private final long k;

    public /* synthetic */ C7333Rg5(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, long j6, ED1 ed1) {
        this(j, j2, j3, j4, z, f, i, z2, list, j5, j6);
    }

    public final boolean a() {
        return this.h;
    }

    public final boolean b() {
        return this.e;
    }

    public final List c() {
        return this.i;
    }

    public final long d() {
        return this.a;
    }

    public final long e() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7333Rg5)) {
            return false;
        }
        C7333Rg5 c7333Rg5 = (C7333Rg5) obj;
        return AbstractC6122Mg5.b(this.a, c7333Rg5.a) && this.b == c7333Rg5.b && ZG4.j(this.c, c7333Rg5.c) && ZG4.j(this.d, c7333Rg5.d) && this.e == c7333Rg5.e && Float.compare(this.f, c7333Rg5.f) == 0 && AbstractC11873dh5.g(this.g, c7333Rg5.g) && this.h == c7333Rg5.h && AbstractC13042fc3.d(this.i, c7333Rg5.i) && ZG4.j(this.j, c7333Rg5.j) && ZG4.j(this.k, c7333Rg5.k);
    }

    public final long f() {
        return this.d;
    }

    public final long g() {
        return this.c;
    }

    public final float h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((((((((((((AbstractC6122Mg5.c(this.a) * 31) + Long.hashCode(this.b)) * 31) + ZG4.o(this.c)) * 31) + ZG4.o(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Float.hashCode(this.f)) * 31) + AbstractC11873dh5.h(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + ZG4.o(this.j)) * 31) + ZG4.o(this.k);
    }

    public final long i() {
        return this.j;
    }

    public final int j() {
        return this.g;
    }

    public final long k() {
        return this.b;
    }

    public String toString() {
        return "PointerInputEventData(id=" + ((Object) AbstractC6122Mg5.d(this.a)) + ", uptime=" + this.b + ", positionOnScreen=" + ((Object) ZG4.s(this.c)) + ", position=" + ((Object) ZG4.s(this.d)) + ", down=" + this.e + ", pressure=" + this.f + ", type=" + ((Object) AbstractC11873dh5.i(this.g)) + ", activeHover=" + this.h + ", historical=" + this.i + ", scrollDelta=" + ((Object) ZG4.s(this.j)) + ", originalEventPosition=" + ((Object) ZG4.s(this.k)) + ')';
    }

    private C7333Rg5(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, long j6) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = z;
        this.f = f;
        this.g = i;
        this.h = z2;
        this.i = list;
        this.j = j5;
        this.k = j6;
    }
}
