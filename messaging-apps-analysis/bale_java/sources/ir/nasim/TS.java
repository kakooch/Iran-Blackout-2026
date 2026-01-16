package ir.nasim;

import ir.nasim.GD0;

/* loaded from: classes.dex */
final class TS extends GD0 {
    private final GD0.b a;
    private final GD0.a b;

    TS(GD0.b bVar, GD0.a aVar) {
        if (bVar == null) {
            throw new NullPointerException("Null type");
        }
        this.a = bVar;
        this.b = aVar;
    }

    @Override // ir.nasim.GD0
    public GD0.a c() {
        return this.b;
    }

    @Override // ir.nasim.GD0
    public GD0.b d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GD0)) {
            return false;
        }
        GD0 gd0 = (GD0) obj;
        if (this.a.equals(gd0.d())) {
            GD0.a aVar = this.b;
            if (aVar == null) {
                if (gd0.c() == null) {
                    return true;
                }
            } else if (aVar.equals(gd0.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        GD0.a aVar = this.b;
        return iHashCode ^ (aVar == null ? 0 : aVar.hashCode());
    }

    public String toString() {
        return "CameraState{type=" + this.a + ", error=" + this.b + "}";
    }
}
