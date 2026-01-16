package ir.nasim;

/* renamed from: ir.nasim.jl0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C15538jl0 implements InterfaceC25129zm7 {
    private final AbstractC4147Dw6 b;
    private final float c;

    public C15538jl0(AbstractC4147Dw6 abstractC4147Dw6, float f) {
        this.b = abstractC4147Dw6;
        this.c = f;
    }

    @Override // ir.nasim.InterfaceC25129zm7
    public float a() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC25129zm7
    public long d() {
        return C24381yX0.b.i();
    }

    @Override // ir.nasim.InterfaceC25129zm7
    public AbstractC12520el0 e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15538jl0)) {
            return false;
        }
        C15538jl0 c15538jl0 = (C15538jl0) obj;
        return AbstractC13042fc3.d(this.b, c15538jl0.b) && Float.compare(this.c, c15538jl0.c) == 0;
    }

    public final AbstractC4147Dw6 f() {
        return this.b;
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + Float.hashCode(this.c);
    }

    public String toString() {
        return "BrushStyle(value=" + this.b + ", alpha=" + this.c + ')';
    }
}
