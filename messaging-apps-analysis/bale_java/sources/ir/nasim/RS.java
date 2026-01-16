package ir.nasim;

import ir.nasim.C6602Of0;

/* loaded from: classes.dex */
final class RS extends C6602Of0.b {
    private final PS4 a;
    private final int b;

    RS(PS4 ps4, int i) {
        if (ps4 == null) {
            throw new NullPointerException("Null packet");
        }
        this.a = ps4;
        this.b = i;
    }

    @Override // ir.nasim.C6602Of0.b
    int a() {
        return this.b;
    }

    @Override // ir.nasim.C6602Of0.b
    PS4 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C6602Of0.b)) {
            return false;
        }
        C6602Of0.b bVar = (C6602Of0.b) obj;
        return this.a.equals(bVar.b()) && this.b == bVar.a();
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    public String toString() {
        return "In{packet=" + this.a + ", jpegQuality=" + this.b + "}";
    }
}
