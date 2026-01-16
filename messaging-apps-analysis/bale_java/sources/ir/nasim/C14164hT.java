package ir.nasim;

import ir.nasim.N03;

/* renamed from: ir.nasim.hT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C14164hT extends N03.a {
    private final PS4 a;
    private final int b;

    C14164hT(PS4 ps4, int i) {
        if (ps4 == null) {
            throw new NullPointerException("Null packet");
        }
        this.a = ps4;
        this.b = i;
    }

    @Override // ir.nasim.N03.a
    int a() {
        return this.b;
    }

    @Override // ir.nasim.N03.a
    PS4 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof N03.a)) {
            return false;
        }
        N03.a aVar = (N03.a) obj;
        return this.a.equals(aVar.b()) && this.b == aVar.a();
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    public String toString() {
        return "In{packet=" + this.a + ", jpegQuality=" + this.b + "}";
    }
}
