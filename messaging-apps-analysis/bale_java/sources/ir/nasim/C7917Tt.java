package ir.nasim;

/* renamed from: ir.nasim.Tt, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7917Tt extends AbstractC8151Ut {
    private float a;
    private float b;
    private float c;
    private float d;
    private final int e;

    public C7917Tt(float f, float f2, float f3, float f4) {
        super(null);
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = 4;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public float a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return this.c;
        }
        if (i != 3) {
            return 0.0f;
        }
        return this.d;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public int b() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public void d() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public void e(int i, float f) {
        if (i == 0) {
            this.a = f;
            return;
        }
        if (i == 1) {
            this.b = f;
        } else if (i == 2) {
            this.c = f;
        } else {
            if (i != 3) {
                return;
            }
            this.d = f;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C7917Tt) {
            C7917Tt c7917Tt = (C7917Tt) obj;
            if (c7917Tt.a == this.a && c7917Tt.b == this.b && c7917Tt.c == this.c && c7917Tt.d == this.d) {
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

    public final float h() {
        return this.c;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }

    public final float i() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC8151Ut
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C7917Tt c() {
        return new C7917Tt(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "AnimationVector4D: v1 = " + this.a + ", v2 = " + this.b + ", v3 = " + this.c + ", v4 = " + this.d;
    }
}
