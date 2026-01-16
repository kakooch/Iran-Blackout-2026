package ir.nasim;

import ir.nasim.InterfaceC8727Xb3;

/* renamed from: ir.nasim.qq4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19729qq4 implements InterfaceC22264uw3 {
    private final AbstractC21192tG4 a;
    private final Object[] b;
    private final int c;

    /* renamed from: ir.nasim.qq4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ C3348Am4 g;
        final /* synthetic */ C19729qq4 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, int i2, C3348Am4 c3348Am4, C19729qq4 c19729qq4) {
            super(1);
            this.e = i;
            this.f = i2;
            this.g = c3348Am4;
            this.h = c19729qq4;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0039  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(ir.nasim.InterfaceC8727Xb3.a r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r7.c()
                ir.nasim.mw3$a r0 = (ir.nasim.AbstractC17424mw3.a) r0
                ir.nasim.UA2 r0 = r0.getKey()
                int r1 = r6.e
                int r2 = r7.b()
                int r1 = java.lang.Math.max(r1, r2)
                int r2 = r6.f
                int r3 = r7.b()
                int r4 = r7.a()
                int r3 = r3 + r4
                int r3 = r3 + (-1)
                int r2 = java.lang.Math.min(r2, r3)
                if (r1 > r2) goto L57
            L27:
                if (r0 == 0) goto L39
                int r3 = r7.b()
                int r3 = r1 - r3
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                java.lang.Object r3 = r0.invoke(r3)
                if (r3 != 0) goto L3d
            L39:
                java.lang.Object r3 = androidx.compose.foundation.lazy.layout.h.a(r1)
            L3d:
                ir.nasim.Am4 r4 = r6.g
                r4.u(r3, r1)
                ir.nasim.qq4 r4 = r6.h
                java.lang.Object[] r4 = ir.nasim.C19729qq4.a(r4)
                ir.nasim.qq4 r5 = r6.h
                int r5 = ir.nasim.C19729qq4.b(r5)
                int r5 = r1 - r5
                r4[r5] = r3
                if (r1 == r2) goto L57
                int r1 = r1 + 1
                goto L27
            L57:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19729qq4.a.a(ir.nasim.Xb3$a):void");
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC8727Xb3.a) obj);
            return C19938rB7.a;
        }
    }

    public C19729qq4(C24411ya3 c24411ya3, AbstractC17424mw3 abstractC17424mw3) {
        InterfaceC8727Xb3 interfaceC8727Xb3J = abstractC17424mw3.j();
        int iO = c24411ya3.o();
        if (!(iO >= 0)) {
            P73.c("negative nearestRange.first");
        }
        int iMin = Math.min(c24411ya3.t(), interfaceC8727Xb3J.f() - 1);
        if (iMin < iO) {
            this.a = AbstractC21866uG4.a();
            this.b = new Object[0];
            this.c = 0;
        } else {
            int i = (iMin - iO) + 1;
            this.b = new Object[i];
            this.c = iO;
            C3348Am4 c3348Am4 = new C3348Am4(i);
            interfaceC8727Xb3J.a(iO, iMin, new a(iO, iMin, c3348Am4, this));
            this.a = c3348Am4;
        }
    }

    @Override // ir.nasim.InterfaceC22264uw3
    public int c(Object obj) {
        AbstractC21192tG4 abstractC21192tG4 = this.a;
        int iB = abstractC21192tG4.b(obj);
        if (iB >= 0) {
            return abstractC21192tG4.c[iB];
        }
        return -1;
    }

    @Override // ir.nasim.InterfaceC22264uw3
    public Object d(int i) {
        Object[] objArr = this.b;
        int i2 = i - this.c;
        if (i2 < 0 || i2 > AbstractC10242bK.l0(objArr)) {
            return null;
        }
        return objArr[i2];
    }
}
