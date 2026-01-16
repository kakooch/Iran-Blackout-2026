package ir.nasim;

import ir.nasim.C18667p27;

/* loaded from: classes.dex */
final class CT extends C18667p27.b {
    private final int a;
    private final int b;
    private final boolean c;
    private final boolean d;

    CT(int i, int i2, boolean z, boolean z2) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = z2;
    }

    @Override // ir.nasim.C18667p27.b
    int a() {
        return this.a;
    }

    @Override // ir.nasim.C18667p27.b
    int b() {
        return this.b;
    }

    @Override // ir.nasim.C18667p27.b
    boolean c() {
        return this.c;
    }

    @Override // ir.nasim.C18667p27.b
    boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C18667p27.b)) {
            return false;
        }
        C18667p27.b bVar = (C18667p27.b) obj;
        return this.a == bVar.a() && this.b == bVar.b() && this.c == bVar.c() && this.d == bVar.d();
    }

    public int hashCode() {
        return ((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ (this.c ? 1231 : 1237)) * 1000003) ^ (this.d ? 1231 : 1237);
    }

    public String toString() {
        return "FeatureSettings{cameraMode=" + this.a + ", requiredMaxBitDepth=" + this.b + ", previewStabilizationOn=" + this.c + ", ultraHdrOn=" + this.d + "}";
    }
}
