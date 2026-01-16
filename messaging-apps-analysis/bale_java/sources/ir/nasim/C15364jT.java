package ir.nasim;

/* renamed from: ir.nasim.jT, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C15364jT extends AbstractC15728k43 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    C15364jT(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    @Override // ir.nasim.AbstractC15728k43, ir.nasim.Qc8
    public float a() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC15728k43, ir.nasim.Qc8
    public float b() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC15728k43, ir.nasim.Qc8
    public float c() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC15728k43, ir.nasim.Qc8
    public float d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC15728k43)) {
            return false;
        }
        AbstractC15728k43 abstractC15728k43 = (AbstractC15728k43) obj;
        return Float.floatToIntBits(this.a) == Float.floatToIntBits(abstractC15728k43.d()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(abstractC15728k43.a()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(abstractC15728k43.c()) && Float.floatToIntBits(this.d) == Float.floatToIntBits(abstractC15728k43.b());
    }

    public int hashCode() {
        return ((((((Float.floatToIntBits(this.a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003) ^ Float.floatToIntBits(this.d);
    }

    public String toString() {
        return "ImmutableZoomState{zoomRatio=" + this.a + ", maxZoomRatio=" + this.b + ", minZoomRatio=" + this.c + ", linearZoom=" + this.d + "}";
    }
}
