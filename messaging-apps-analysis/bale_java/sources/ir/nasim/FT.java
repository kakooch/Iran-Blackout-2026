package ir.nasim;

import ir.nasim.G27;

/* loaded from: classes.dex */
final class FT extends G27.b {
    private final int a;
    private final G27 b;

    FT(int i, G27 g27) {
        this.a = i;
        if (g27 == null) {
            throw new NullPointerException("Null surfaceOutput");
        }
        this.b = g27;
    }

    @Override // ir.nasim.G27.b
    public int a() {
        return this.a;
    }

    @Override // ir.nasim.G27.b
    public G27 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G27.b)) {
            return false;
        }
        G27.b bVar = (G27.b) obj;
        return this.a == bVar.a() && this.b.equals(bVar.b());
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "Event{eventCode=" + this.a + ", surfaceOutput=" + this.b + "}";
    }
}
