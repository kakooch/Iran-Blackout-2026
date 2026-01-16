package ir.nasim;

/* renamed from: ir.nasim.Rt, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7444Rt extends AbstractC8151Ut {
    private float a;
    private float b;
    private final int c;

    public C7444Rt(float f, float f2) {
        super(null);
        this.a = f;
        this.b = f2;
        this.c = 2;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public float a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i != 1) {
            return 0.0f;
        }
        return this.b;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public int b() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public void d() {
        this.a = 0.0f;
        this.b = 0.0f;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public void e(int i, float f) {
        if (i == 0) {
            this.a = f;
        } else {
            if (i != 1) {
                return;
            }
            this.b = f;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C7444Rt) {
            C7444Rt c7444Rt = (C7444Rt) obj;
            if (c7444Rt.a == this.a && c7444Rt.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final float f() {
        return this.a;
    }

    public final float g() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC8151Ut
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C7444Rt c() {
        return new C7444Rt(0.0f, 0.0f);
    }

    public int hashCode() {
        return (Float.hashCode(this.a) * 31) + Float.hashCode(this.b);
    }

    public String toString() {
        return "AnimationVector2D: v1 = " + this.a + ", v2 = " + this.b;
    }
}
