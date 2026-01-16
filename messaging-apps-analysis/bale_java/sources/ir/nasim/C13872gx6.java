package ir.nasim;

import android.graphics.Path;
import ir.nasim.AbstractC24408ya0;
import java.util.List;

/* renamed from: ir.nasim.gx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13872gx6 implements InterfaceC13318g15, AbstractC24408ya0.b, InterfaceC5491Jo3 {
    private final String b;
    private final boolean c;
    private final com.airbnb.lottie.q d;
    private final C22276ux6 e;
    private boolean f;
    private final Path a = new Path();
    private final C17813nc1 g = new C17813nc1();

    public C13872gx6(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, C24642yx6 c24642yx6) {
        this.b = c24642yx6.b();
        this.c = c24642yx6.d();
        this.d = qVar;
        C22276ux6 c22276ux6J = c24642yx6.c().j();
        this.e = c22276ux6J;
        abstractC3236Aa0.j(c22276ux6J);
        c22276ux6J.a(this);
    }

    private void h() {
        this.f = false;
        this.d.invalidateSelf();
    }

    @Override // ir.nasim.InterfaceC13318g15
    public Path A() {
        if (this.f && !this.e.k()) {
            return this.a;
        }
        this.a.reset();
        if (this.c) {
            this.f = true;
            return this.a;
        }
        Path path = (Path) this.e.h();
        if (path == null) {
            return this.a;
        }
        this.a.set(path);
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.g.b(this.a);
        this.f = true;
        return this.a;
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // ir.nasim.InterfaceC14939ik1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.util.List r6, java.util.List r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            int r1 = r6.size()
            if (r0 >= r1) goto L3c
            java.lang.Object r1 = r6.get(r0)
            ir.nasim.ik1 r1 = (ir.nasim.InterfaceC14939ik1) r1
            boolean r2 = r1 instanceof ir.nasim.C16837lw7
            if (r2 == 0) goto L26
            r2 = r1
            ir.nasim.lw7 r2 = (ir.nasim.C16837lw7) r2
            ir.nasim.Dx6$a r3 = r2.k()
            ir.nasim.Dx6$a r4 = ir.nasim.C4156Dx6.a.SIMULTANEOUSLY
            if (r3 != r4) goto L26
            ir.nasim.nc1 r1 = r5.g
            r1.a(r2)
            r2.c(r5)
            goto L39
        L26:
            boolean r2 = r1 instanceof ir.nasim.InterfaceC23462wx6
            if (r2 == 0) goto L39
            if (r7 != 0) goto L31
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L31:
            ir.nasim.wx6 r1 = (ir.nasim.InterfaceC23462wx6) r1
            r1.e(r5)
            r7.add(r1)
        L39:
            int r0 = r0 + 1
            goto L2
        L3c:
            ir.nasim.ux6 r6 = r5.e
            r6.s(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13872gx6.b(java.util.List, java.util.List):void");
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        if (obj == InterfaceC9661aL3.P) {
            this.e.o(c13505gL3);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, this);
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.b;
    }
}
