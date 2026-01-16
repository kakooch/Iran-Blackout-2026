package ir.nasim;

/* renamed from: ir.nasim.St, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7678St extends AbstractC8151Ut {
    private float a;
    private float b;
    private float c;
    private final int d;

    public C7678St(float f, float f2, float f3) {
        super(null);
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = 3;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public float a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            return this.b;
        }
        if (i != 2) {
            return 0.0f;
        }
        return this.c;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public int b() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public void d() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public void e(int i, float f) {
        if (i == 0) {
            this.a = f;
        } else if (i == 1) {
            this.b = f;
        } else {
            if (i != 2) {
                return;
            }
            this.c = f;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C7678St) {
            C7678St c7678St = (C7678St) obj;
            if (c7678St.a == this.a && c7678St.b == this.b && c7678St.c == this.c) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.AbstractC8151Ut
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C7678St c() {
        return new C7678St(0.0f, 0.0f, 0.0f);
    }

    public int hashCode() {
        return (((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c);
    }

    public String toString() {
        return "AnimationVector3D: v1 = " + this.a + ", v2 = " + this.b + ", v3 = " + this.c;
    }
}
