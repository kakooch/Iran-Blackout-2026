package ir.nasim;

/* renamed from: ir.nasim.Si7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7587Si7 {
    private final float a;
    private final float b;
    private final float c;

    public /* synthetic */ C7587Si7(float f, float f2, float f3, ED1 ed1) {
        this(f, f2, f3);
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
        if (!(obj instanceof C7587Si7)) {
            return false;
        }
        C7587Si7 c7587Si7 = (C7587Si7) obj;
        return C17784nZ1.s(this.a, c7587Si7.a) && C17784nZ1.s(this.b, c7587Si7.b) && C17784nZ1.s(this.c, c7587Si7.c);
    }

    public int hashCode() {
        return (((C17784nZ1.t(this.a) * 31) + C17784nZ1.t(this.b)) * 31) + C17784nZ1.t(this.c);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) C17784nZ1.u(this.a)) + ", right=" + ((Object) C17784nZ1.u(b())) + ", width=" + ((Object) C17784nZ1.u(this.b)) + ", contentWidth=" + ((Object) C17784nZ1.u(this.c)) + ')';
    }

    private C7587Si7(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }
}
