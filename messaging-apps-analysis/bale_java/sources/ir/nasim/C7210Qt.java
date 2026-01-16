package ir.nasim;

/* renamed from: ir.nasim.Qt, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7210Qt extends AbstractC8151Ut {
    private float a;
    private final int b;

    public C7210Qt(float f) {
        super(null);
        this.a = f;
        this.b = 1;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public float a(int i) {
        if (i == 0) {
            return this.a;
        }
        return 0.0f;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public int b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public void d() {
        this.a = 0.0f;
    }

    @Override // ir.nasim.AbstractC8151Ut
    public void e(int i, float f) {
        if (i == 0) {
            this.a = f;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C7210Qt) && ((C7210Qt) obj).a == this.a;
    }

    public final float f() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC8151Ut
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C7210Qt c() {
        return new C7210Qt(0.0f);
    }

    public int hashCode() {
        return Float.hashCode(this.a);
    }

    public String toString() {
        return "AnimationVector1D: value = " + this.a;
    }
}
