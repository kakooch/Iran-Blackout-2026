package ir.nasim;

/* renamed from: ir.nasim.Ui7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8060Ui7 {
    private final float a;
    private final float b;

    public /* synthetic */ C8060Ui7(float f, float f2, ED1 ed1) {
        this(f, f2);
    }

    public final float a() {
        return this.a;
    }

    public final float b() {
        return C17784nZ1.q(this.a + this.b);
    }

    public final float c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8060Ui7)) {
            return false;
        }
        C8060Ui7 c8060Ui7 = (C8060Ui7) obj;
        return C17784nZ1.s(this.a, c8060Ui7.a) && C17784nZ1.s(this.b, c8060Ui7.b);
    }

    public int hashCode() {
        return (C17784nZ1.t(this.a) * 31) + C17784nZ1.t(this.b);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) C17784nZ1.u(this.a)) + ", right=" + ((Object) C17784nZ1.u(b())) + ", width=" + ((Object) C17784nZ1.u(this.b)) + ')';
    }

    private C8060Ui7(float f, float f2) {
        this.a = f;
        this.b = f2;
    }
}
