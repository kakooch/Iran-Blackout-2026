package ir.nasim;

import android.view.Surface;
import ir.nasim.Z27;

/* loaded from: classes.dex */
final class HT extends Z27.g {
    private final int a;
    private final Surface b;

    HT(int i, Surface surface) {
        this.a = i;
        if (surface == null) {
            throw new NullPointerException("Null surface");
        }
        this.b = surface;
    }

    @Override // ir.nasim.Z27.g
    public int a() {
        return this.a;
    }

    @Override // ir.nasim.Z27.g
    public Surface b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Z27.g)) {
            return false;
        }
        Z27.g gVar = (Z27.g) obj;
        return this.a == gVar.a() && this.b.equals(gVar.b());
    }

    public int hashCode() {
        return ((this.a ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "Result{resultCode=" + this.a + ", surface=" + this.b + "}";
    }
}
