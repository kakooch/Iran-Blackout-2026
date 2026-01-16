package ir.nasim;

/* renamed from: ir.nasim.aW0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C9757aW0 implements InterfaceC10351bW0 {
    private final float a;
    private final float b;

    public C9757aW0(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public boolean a(float f) {
        return f >= this.a && f <= this.b;
    }

    @Override // ir.nasim.InterfaceC10967cW0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float j() {
        return Float.valueOf(this.b);
    }

    @Override // ir.nasim.InterfaceC10967cW0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float f() {
        return Float.valueOf(this.a);
    }

    public boolean d(float f, float f2) {
        return f <= f2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C9757aW0) {
            if (!isEmpty() || !((C9757aW0) obj).isEmpty()) {
                C9757aW0 c9757aW0 = (C9757aW0) obj;
                if (this.a != c9757aW0.a || this.b != c9757aW0.b) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.InterfaceC10351bW0, ir.nasim.InterfaceC10967cW0
    public /* bridge */ /* synthetic */ boolean h(Comparable comparable) {
        return a(((Number) comparable).floatValue());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.hashCode(this.a) * 31) + Float.hashCode(this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.InterfaceC10351bW0
    public /* bridge */ /* synthetic */ boolean i(Comparable comparable, Comparable comparable2) {
        return d(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    @Override // ir.nasim.InterfaceC10351bW0, ir.nasim.InterfaceC10967cW0
    public boolean isEmpty() {
        return this.a > this.b;
    }

    public String toString() {
        return this.a + ".." + this.b;
    }
}
