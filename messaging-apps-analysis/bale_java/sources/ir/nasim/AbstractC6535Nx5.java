package ir.nasim;

/* renamed from: ir.nasim.Nx5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6535Nx5 extends AbstractC8979Yb1 {
    public AbstractC6535Nx5(SA2 sa2) {
        super(sa2, null);
    }

    private final InterfaceC18300oQ7 f(C7252Qx5 c7252Qx5) {
        if (!c7252Qx5.i()) {
            return c7252Qx5.c() != null ? new C22063uc1(c7252Qx5.c()) : c7252Qx5.f() != null ? new C22320v22(c7252Qx5.f()) : new C18854pM6(c7252Qx5.d());
        }
        InterfaceC9102Ym4 interfaceC9102Ym4F = c7252Qx5.f();
        if (interfaceC9102Ym4F == null) {
            Object objG = c7252Qx5.g();
            ZG6 zg6E = c7252Qx5.e();
            if (zg6E == null) {
                zg6E = AbstractC10222bH6.s();
            }
            interfaceC9102Ym4F = AbstractC10222bH6.h(objG, zg6E);
        }
        return new C22320v22(interfaceC9102Ym4F);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034 A[PHI: r5
      0x0034: PHI (r5v2 ir.nasim.v22) = (r5v5 ir.nasim.v22), (r5v6 ir.nasim.v22) binds: [B:17:0x0044, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // ir.nasim.AbstractC8979Yb1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.InterfaceC18300oQ7 b(ir.nasim.C7252Qx5 r4, ir.nasim.InterfaceC18300oQ7 r5) {
        /*
            r3 = this;
            boolean r0 = r5 instanceof ir.nasim.C22320v22
            r1 = 0
            if (r0 == 0) goto L1a
            boolean r0 = r4.i()
            if (r0 == 0) goto L47
            r1 = r5
            ir.nasim.v22 r1 = (ir.nasim.C22320v22) r1
            ir.nasim.Ym4 r5 = r1.b()
            java.lang.Object r0 = r4.d()
            r5.setValue(r0)
            goto L47
        L1a:
            boolean r0 = r5 instanceof ir.nasim.C18854pM6
            if (r0 == 0) goto L36
            boolean r0 = r4.j()
            if (r0 == 0) goto L47
            java.lang.Object r0 = r4.d()
            ir.nasim.pM6 r5 = (ir.nasim.C18854pM6) r5
            java.lang.Object r2 = r5.b()
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r2)
            if (r0 == 0) goto L47
        L34:
            r1 = r5
            goto L47
        L36:
            boolean r0 = r5 instanceof ir.nasim.C22063uc1
            if (r0 == 0) goto L47
            ir.nasim.UA2 r0 = r4.c()
            ir.nasim.uc1 r5 = (ir.nasim.C22063uc1) r5
            ir.nasim.UA2 r2 = r5.b()
            if (r0 != r2) goto L47
            goto L34
        L47:
            if (r1 != 0) goto L4d
            ir.nasim.oQ7 r1 = r3.f(r4)
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6535Nx5.b(ir.nasim.Qx5, ir.nasim.oQ7):ir.nasim.oQ7");
    }

    public abstract C7252Qx5 c(Object obj);

    public final C7252Qx5 d(Object obj) {
        return c(obj);
    }

    public final C7252Qx5 e(Object obj) {
        return c(obj).h();
    }
}
