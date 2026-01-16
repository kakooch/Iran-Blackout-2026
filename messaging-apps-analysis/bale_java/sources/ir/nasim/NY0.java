package ir.nasim;

/* loaded from: classes2.dex */
final class NY0 implements InterfaceC25129zm7 {
    private final long b;

    public /* synthetic */ NY0(long j, ED1 ed1) {
        this(j);
    }

    @Override // ir.nasim.InterfaceC25129zm7
    public float a() {
        return C24381yX0.r(d());
    }

    @Override // ir.nasim.InterfaceC25129zm7
    public long d() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC25129zm7
    public AbstractC12520el0 e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NY0) && C24381yX0.q(this.b, ((NY0) obj).b);
    }

    public int hashCode() {
        return C24381yX0.w(this.b);
    }

    public String toString() {
        return "ColorStyle(value=" + ((Object) C24381yX0.x(this.b)) + ')';
    }

    private NY0(long j) {
        this.b = j;
        if (j != 16) {
            return;
        }
        N73.a("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
    }
}
