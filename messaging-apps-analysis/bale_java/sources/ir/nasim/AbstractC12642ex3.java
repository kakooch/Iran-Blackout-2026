package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ex3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC12642ex3 implements InterfaceC3676Bw3 {
    private final InterfaceC8182Uw3 a;
    private final InterfaceC23450ww3 b;
    private final long c;

    public /* synthetic */ AbstractC12642ex3(long j, boolean z, InterfaceC8182Uw3 interfaceC8182Uw3, InterfaceC23450ww3 interfaceC23450ww3, ED1 ed1) {
        this(j, z, interfaceC8182Uw3, interfaceC23450ww3);
    }

    public static /* synthetic */ C12051dx3 e(AbstractC12642ex3 abstractC12642ex3, int i, long j, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndMeasure-0kLqBqw");
        }
        if ((i2 & 2) != 0) {
            j = abstractC12642ex3.c;
        }
        return abstractC12642ex3.d(i, j);
    }

    public abstract C12051dx3 b(int i, Object obj, Object obj2, List list, long j);

    @Override // ir.nasim.InterfaceC3676Bw3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C12051dx3 a(int i, int i2, int i3, long j) {
        return d(i, j);
    }

    public final C12051dx3 d(int i, long j) {
        return b(i, this.a.d(i), this.a.f(i), this.b.n0(i, j), j);
    }

    public final long f() {
        return this.c;
    }

    public final AbstractC18977pa3 g() {
        return this.a.e();
    }

    public final InterfaceC22264uw3 h() {
        return this.a.b();
    }

    private AbstractC12642ex3(long j, boolean z, InterfaceC8182Uw3 interfaceC8182Uw3, InterfaceC23450ww3 interfaceC23450ww3) {
        this.a = interfaceC8182Uw3;
        this.b = interfaceC23450ww3;
        this.c = AbstractC19606qe1.b(0, z ? C17833ne1.l(j) : Integer.MAX_VALUE, 0, z ? Integer.MAX_VALUE : C17833ne1.k(j), 5, null);
    }
}
