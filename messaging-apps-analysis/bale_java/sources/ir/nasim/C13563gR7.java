package ir.nasim;

/* renamed from: ir.nasim.gR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13563gR7 implements ZQ7 {
    private final InterfaceC10929cR7 a;
    private final EO5 b;
    private final long c;
    private final long d;

    public /* synthetic */ C13563gR7(InterfaceC10929cR7 interfaceC10929cR7, EO5 eo5, long j, ED1 ed1) {
        this(interfaceC10929cR7, eo5, j);
    }

    private final long h(long j) {
        long j2 = this.d;
        if (j + j2 <= 0) {
            return 0L;
        }
        long j3 = j + j2;
        long j4 = this.c;
        long j5 = j3 / j4;
        return (this.b == EO5.a || j5 % ((long) 2) == 0) ? j3 - (j5 * j4) : ((j5 + 1) * j4) - j3;
    }

    private final AbstractC8151Ut i(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        long j2 = this.d;
        long j3 = j + j2;
        long j4 = this.c;
        return j3 > j4 ? this.a.f(j4 - j2, abstractC8151Ut, abstractC8151Ut3, abstractC8151Ut2) : abstractC8151Ut2;
    }

    @Override // ir.nasim.ZQ7
    public boolean a() {
        return true;
    }

    @Override // ir.nasim.ZQ7
    public long b(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return Long.MAX_VALUE;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.a.c(h(j), abstractC8151Ut, abstractC8151Ut2, i(j, abstractC8151Ut, abstractC8151Ut3, abstractC8151Ut2));
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        return this.a.f(h(j), abstractC8151Ut, abstractC8151Ut2, i(j, abstractC8151Ut, abstractC8151Ut3, abstractC8151Ut2));
    }

    private C13563gR7(InterfaceC10929cR7 interfaceC10929cR7, EO5 eo5, long j) {
        this.a = interfaceC10929cR7;
        this.b = eo5;
        this.c = (interfaceC10929cR7.d() + interfaceC10929cR7.e()) * 1000000;
        this.d = j * 1000000;
    }
}
