package ir.nasim;

import java.util.List;

/* loaded from: classes2.dex */
public final class WQ7 extends UQ7 {
    private final String a;
    private final List b;
    private final int c;
    private final AbstractC12520el0 d;
    private final float e;
    private final AbstractC12520el0 f;
    private final float g;
    private final float h;
    private final int i;
    private final int j;
    private final float k;
    private final float l;
    private final float m;
    private final float n;

    public /* synthetic */ WQ7(String str, List list, int i, AbstractC12520el0 abstractC12520el0, float f, AbstractC12520el0 abstractC12520el02, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, ED1 ed1) {
        this(str, list, i, abstractC12520el0, f, abstractC12520el02, f2, f3, i2, i3, f4, f5, f6, f7);
    }

    public final int A() {
        return this.j;
    }

    public final float B() {
        return this.k;
    }

    public final float C() {
        return this.h;
    }

    public final float E() {
        return this.m;
    }

    public final float F() {
        return this.n;
    }

    public final float I() {
        return this.l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && WQ7.class == obj.getClass()) {
            WQ7 wq7 = (WQ7) obj;
            return AbstractC13042fc3.d(this.a, wq7.a) && AbstractC13042fc3.d(this.d, wq7.d) && this.e == wq7.e && AbstractC13042fc3.d(this.f, wq7.f) && this.g == wq7.g && this.h == wq7.h && AbstractC24405yZ6.e(this.i, wq7.i) && AZ6.e(this.j, wq7.j) && this.k == wq7.k && this.l == wq7.l && this.m == wq7.m && this.n == wq7.n && AbstractC14502i15.d(this.c, wq7.c) && AbstractC13042fc3.d(this.b, wq7.b);
        }
        return false;
    }

    public final AbstractC12520el0 f() {
        return this.d;
    }

    public final float h() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        AbstractC12520el0 abstractC12520el0 = this.d;
        int iHashCode2 = (((iHashCode + (abstractC12520el0 != null ? abstractC12520el0.hashCode() : 0)) * 31) + Float.hashCode(this.e)) * 31;
        AbstractC12520el0 abstractC12520el02 = this.f;
        return ((((((((((((((((((iHashCode2 + (abstractC12520el02 != null ? abstractC12520el02.hashCode() : 0)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31) + AbstractC24405yZ6.f(this.i)) * 31) + AZ6.f(this.j)) * 31) + Float.hashCode(this.k)) * 31) + Float.hashCode(this.l)) * 31) + Float.hashCode(this.m)) * 31) + Float.hashCode(this.n)) * 31) + AbstractC14502i15.e(this.c);
    }

    public final String i() {
        return this.a;
    }

    public final List j() {
        return this.b;
    }

    public final int o() {
        return this.c;
    }

    public final AbstractC12520el0 t() {
        return this.f;
    }

    public final float v() {
        return this.g;
    }

    public final int x() {
        return this.i;
    }

    private WQ7(String str, List list, int i, AbstractC12520el0 abstractC12520el0, float f, AbstractC12520el0 abstractC12520el02, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7) {
        super(null);
        this.a = str;
        this.b = list;
        this.c = i;
        this.d = abstractC12520el0;
        this.e = f;
        this.f = abstractC12520el02;
        this.g = f2;
        this.h = f3;
        this.i = i2;
        this.j = i3;
        this.k = f4;
        this.l = f5;
        this.m = f6;
        this.n = f7;
    }
}
