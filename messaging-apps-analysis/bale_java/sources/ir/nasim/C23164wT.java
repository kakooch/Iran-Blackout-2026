package ir.nasim;

import ir.nasim.C11982ds5;

/* renamed from: ir.nasim.wT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C23164wT extends C11982ds5.a {
    private final X22 a;
    private final X22 b;
    private final int c;
    private final int d;

    C23164wT(X22 x22, X22 x222, int i, int i2) {
        if (x22 == null) {
            throw new NullPointerException("Null edge");
        }
        this.a = x22;
        if (x222 == null) {
            throw new NullPointerException("Null postviewEdge");
        }
        this.b = x222;
        this.c = i;
        this.d = i2;
    }

    @Override // ir.nasim.C11982ds5.a
    X22 a() {
        return this.a;
    }

    @Override // ir.nasim.C11982ds5.a
    int b() {
        return this.c;
    }

    @Override // ir.nasim.C11982ds5.a
    int c() {
        return this.d;
    }

    @Override // ir.nasim.C11982ds5.a
    X22 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C11982ds5.a)) {
            return false;
        }
        C11982ds5.a aVar = (C11982ds5.a) obj;
        return this.a.equals(aVar.a()) && this.b.equals(aVar.d()) && this.c == aVar.b() && this.d == aVar.c();
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ this.d;
    }

    public String toString() {
        return "In{edge=" + this.a + ", postviewEdge=" + this.b + ", inputFormat=" + this.c + ", outputFormat=" + this.d + "}";
    }
}
