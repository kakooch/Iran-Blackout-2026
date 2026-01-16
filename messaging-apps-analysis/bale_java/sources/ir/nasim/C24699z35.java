package ir.nasim;

/* renamed from: ir.nasim.z35, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C24699z35 implements InterfaceC9934ao1 {
    private final float a;

    public C24699z35(float f) {
        this.a = f;
        if (f < 0.0f || f > 100.0f) {
            P73.a("The percent should be in the range of [0, 100]");
        }
    }

    @Override // ir.nasim.InterfaceC9934ao1
    public float a(long j, WH1 wh1) {
        return OD6.h(j) * (this.a / 100.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C24699z35) && Float.compare(this.a, ((C24699z35) obj).a) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.a);
    }

    public String toString() {
        return "CornerSize(size = " + this.a + "%)";
    }
}
