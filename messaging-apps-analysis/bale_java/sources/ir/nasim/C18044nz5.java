package ir.nasim;

/* renamed from: ir.nasim.nz5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18044nz5 implements InterfaceC9934ao1 {
    private final float a;

    public C18044nz5(float f) {
        this.a = f;
    }

    @Override // ir.nasim.InterfaceC9934ao1
    public float a(long j, WH1 wh1) {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C18044nz5) && Float.compare(this.a, ((C18044nz5) obj).a) == 0;
    }

    public int hashCode() {
        return Float.hashCode(this.a);
    }

    public String toString() {
        return "CornerSize(size = " + this.a + ".px)";
    }
}
