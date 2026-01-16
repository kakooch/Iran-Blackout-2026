package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.yv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC24621yv3 implements InterfaceC3676Bw3 {
    private final InterfaceC17414mv3 a;
    private final InterfaceC23450ww3 b;
    private final int c;

    public AbstractC24621yv3(InterfaceC17414mv3 interfaceC17414mv3, InterfaceC23450ww3 interfaceC23450ww3, int i) {
        this.a = interfaceC17414mv3;
        this.b = interfaceC23450ww3;
        this.c = i;
    }

    public abstract C24031xv3 b(int i, Object obj, Object obj2, int i2, int i3, List list, long j, int i4, int i5);

    @Override // ir.nasim.InterfaceC3676Bw3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C24031xv3 a(int i, int i2, int i3, long j) {
        return d(i, j, i2, i3, this.c);
    }

    public final C24031xv3 d(int i, long j, int i2, int i3, int i4) {
        int iM;
        Object objD = this.a.d(i);
        Object objF = this.a.f(i);
        List listN0 = this.b.n0(i, j);
        if (C17833ne1.j(j)) {
            iM = C17833ne1.n(j);
        } else {
            if (!C17833ne1.i(j)) {
                P73.a("does not have fixed height");
            }
            iM = C17833ne1.m(j);
        }
        return b(i, objD, objF, iM, i4, listN0, j, i2, i3);
    }

    public final AbstractC18977pa3 e() {
        return this.a.e();
    }

    public final InterfaceC22264uw3 f() {
        return this.a.b();
    }
}
