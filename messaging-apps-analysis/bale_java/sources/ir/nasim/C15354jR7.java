package ir.nasim;

/* renamed from: ir.nasim.jR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15354jR7 implements InterfaceC11693dR7 {
    private final int a;
    private final InterfaceC10929cR7 b;
    private final EO5 c;
    private final long d;
    private final long e;

    public /* synthetic */ C15354jR7(int i, InterfaceC10929cR7 interfaceC10929cR7, EO5 eo5, long j, ED1 ed1) {
        this(i, interfaceC10929cR7, eo5, j);
    }

    private final long h(long j) {
        long j2 = this.e;
        if (j + j2 <= 0) {
            return 0L;
        }
        long j3 = j + j2;
        long jMin = Math.min(j3 / this.d, this.a - 1);
        return (this.c == EO5.a || jMin % ((long) 2) == 0) ? j3 - (jMin * this.d) : ((jMin + 1) * this.d) - j3;
    }

    private final AbstractC8151Ut i(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        long j2 = this.e;
        long j3 = j + j2;
        long j4 = this.d;
        return j3 > j4 ? f(j4 - j2, abstractC8151Ut, abstractC8151Ut2, abstractC8151Ut3) : abstractC8151Ut2;
    }

    @Override // ir.nasim.ZQ7
    public long b(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return (this.a * this.d) - this.e;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.b.c(h(j), abstractC8151Ut, abstractC8151Ut2, i(j, abstractC8151Ut, abstractC8151Ut3, abstractC8151Ut2));
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.b.f(h(j), abstractC8151Ut, abstractC8151Ut2, i(j, abstractC8151Ut, abstractC8151Ut3, abstractC8151Ut2));
    }

    private C15354jR7(int i, InterfaceC10929cR7 interfaceC10929cR7, EO5 eo5, long j) {
        this.a = i;
        this.b = interfaceC10929cR7;
        this.c = eo5;
        if (i < 1) {
            throw new IllegalArgumentException("Iterations count can't be less than 1");
        }
        this.d = (interfaceC10929cR7.d() + interfaceC10929cR7.e()) * 1000000;
        this.e = j * 1000000;
    }
}
