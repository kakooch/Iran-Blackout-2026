package ir.nasim;

/* loaded from: classes2.dex */
public final class CH6 extends AbstractC12520el0 {
    private final long c;

    public /* synthetic */ CH6(long j, ED1 ed1) {
        this(j);
    }

    @Override // ir.nasim.AbstractC12520el0
    public void a(long j, InterfaceC12969fU4 interfaceC12969fU4, float f) {
        long jO;
        interfaceC12969fU4.c(1.0f);
        if (f == 1.0f) {
            jO = this.c;
        } else {
            long j2 = this.c;
            jO = C24381yX0.o(j2, C24381yX0.r(j2) * f, 0.0f, 0.0f, 0.0f, 14, null);
        }
        interfaceC12969fU4.k(jO);
        if (interfaceC12969fU4.r() != null) {
            interfaceC12969fU4.q(null);
        }
    }

    public final long b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CH6) && C24381yX0.q(this.c, ((CH6) obj).c);
    }

    public int hashCode() {
        return C24381yX0.w(this.c);
    }

    public String toString() {
        return "SolidColor(value=" + ((Object) C24381yX0.x(this.c)) + ')';
    }

    private CH6(long j) {
        super(null);
        this.c = j;
    }
}
