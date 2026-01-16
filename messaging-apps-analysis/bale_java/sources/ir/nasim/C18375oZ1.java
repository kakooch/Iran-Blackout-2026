package ir.nasim;

/* renamed from: ir.nasim.oZ1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18375oZ1 implements InterfaceC9934ao1 {
    private final float a;

    public /* synthetic */ C18375oZ1(float f, ED1 ed1) {
        this(f);
    }

    @Override // ir.nasim.InterfaceC9934ao1
    public float a(long j, WH1 wh1) {
        return wh1.w1(this.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C18375oZ1) && C17784nZ1.s(this.a, ((C18375oZ1) obj).a);
    }

    public int hashCode() {
        return C17784nZ1.t(this.a);
    }

    public String toString() {
        return "CornerSize(size = " + this.a + ".dp)";
    }

    private C18375oZ1(float f) {
        this.a = f;
    }
}
